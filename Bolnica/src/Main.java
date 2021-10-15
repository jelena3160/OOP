import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {
    private static Bolnica bolnica = new Bolnica();
    private static boolean ucitano = false;

    private static <T> void ispisiListu(List<T> lista, TextArea ta){
        ta.clear();
        for(T t: lista)
            ta.appendText(t + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage Stage) {
        HBox root = new HBox(10);
        root.setPadding(new Insets(10,35,10,10));

        VBox levo = new VBox(10);
        Button btUcitaj = new Button("Ucitaj pacijente");
        Button btSledeci = new Button("Sledeci");
        Label lbBrDana = new Label("Broj dana");
        TextField tfBrDana = new TextField();
        Button btUbrzaj = new Button("Ubrzaj vreme!");
        Label lbGreska = new Label("Greska");
        lbGreska.setVisible(false);
        lbGreska.setTextFill(Color.RED);
        ToggleGroup tg = new ToggleGroup();
        RadioButton rbSve = new RadioButton("Sve");
        rbSve.setSelected(true);
        rbSve.setToggleGroup(tg);
        RadioButton rbKorona = new RadioButton("Korona");
        rbKorona.setToggleGroup(tg);
        Button btPrikazi = new Button("Prikazi statistike");
        Button btUnesi = new Button("Unesi");

        levo.getChildren().addAll(btUcitaj, btSledeci, lbBrDana, tfBrDana, btUbrzaj, lbGreska, rbSve, rbKorona, btPrikazi, btUnesi);

        VBox desno = new VBox(10);
        Label lbCekaju = new Label("Cekaju");
        TextArea taCekaonica = new TextArea();
        Label lbIzolacija = new Label("U izolaciji");
        TextArea taIzolacija = new TextArea();
        Label lbZdravi = new Label("Zdravi");
        TextArea taZdravi = new TextArea();
        taCekaonica.setEditable(false);
        taIzolacija.setEditable(false);
        taZdravi.setEditable(false);

        desno.getChildren().addAll(lbCekaju, taCekaonica, lbIzolacija, taIzolacija, lbZdravi, taZdravi);

        btUcitaj.setOnAction(e ->{
            if(ucitano)
                return;
            bolnica.ucitaj();
            ucitano = true;
            Collections.sort(bolnica.getCekaonica());
            ispisiListu(bolnica.getCekaonica(), taCekaonica);

        });

        btSledeci.setOnAction(e -> {
            if(bolnica.getCekaonica().isEmpty()){
                taCekaonica.clear();
                taCekaonica.appendText("Niko ne ceka");
            }
            else{
                bolnica.sledeci();
                ispisiListu(bolnica.getCekaonica(), taCekaonica);
                ispisiListu(bolnica.getIzolacija(), taIzolacija);
                ispisiListu(bolnica.getZdravi(), taZdravi);
            }
        });

        btUbrzaj.setOnAction(e -> {
            try {
                int brDana = Integer.parseInt((tfBrDana.getText()));
                if (brDana <= 0) {
                    lbGreska.setVisible(true);
                    tfBrDana.clear();
                    return;
                } else {
                    lbGreska.setVisible(false);
                    for (Pacijent p : bolnica.getIzolacija()) {
                        p.leci(brDana);
                    }
                    bolnica.getZdravi().addAll(bolnica.getIzolacija().stream().filter(pacijent -> pacijent.izlecen()).collect(Collectors.toList()));
                    bolnica.setIzolacija(bolnica.getIzolacija().stream().filter(pacijent -> !pacijent.izlecen()).collect(Collectors.toList()));
                    ispisiListu(bolnica.getIzolacija(), taIzolacija);
                    ispisiListu(bolnica.getZdravi(), taZdravi);
                }
            }catch(NumberFormatException ex){
                ex.printStackTrace();
            }

        });

        root.getChildren().addAll(levo, desno);

        Scene scena = new Scene(root, 800,600);
        Stage.setScene(scena);
        Stage.setTitle("Bolnica");
        Stage.show();


    }
}
