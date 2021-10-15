package Pakovanje;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static List<Paket> paketi = new ArrayList<>();
    public static List<Kutija> kutije = new ArrayList<>();
    public static boolean ind1 = false, ind2 = false;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10,10,10,10));

        Button btPregled = new Button("Pregled paketa");
        TextArea taPregled = new TextArea();
        taPregled.setEditable(false);

        HBox hb = new HBox(10);
        Label lbCena = new Label("Cena zastitne folije");
        TextField tfCena = new TextField();

        hb.getChildren().addAll(lbCena, tfCena);

        TextArea taIspis = new TextArea();
        taIspis.setEditable(false);
        Button btIzracunaj = new Button("Izracunaj cenu dodatnog paketa");

        root.getChildren().addAll(btPregled, taPregled, hb, taIspis, btIzracunaj);

        btPregled.setOnAction(e -> {
            try {
                List<String> lista = Files.readAllLines(Paths.get("paketi.txt"));
                if(lista.isEmpty())
                    taPregled.setText("Prazan spisak paketa!");
                else{
                    taPregled.setText("DEO ZA PRAG" + "\n");
                    for(String linija : lista)
                        taPregled.appendText(linija + "\n");
                }
                taPregled.appendText("-----------------------" + "\n");
                Paket p;
                for(String lines: lista){
                    String[] tokeni = lines.split(", ");
                    char tip = tokeni[0].trim().charAt(0);
                    int a = Integer.parseInt(tokeni[1].trim());
                    int b = Integer.parseInt(tokeni[2].trim());
                    if(tip == 'K'){
                        int c = Integer.parseInt(tokeni[3].trim());
                        p = new Kutija(a,b,c);
                        paketi.add(p);
                    }
                    else{
                        p = new Valjak(a,b);
                        paketi.add(p);
                    }

                }
                if(!ind2) {
                    for (Paket p1 : paketi) {
                        taPregled.appendText(p1.toString() + "\n");
                    }
                    ind2 = true;
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        btIzracunaj.setOnAction(e -> {
            boolean ind = false;
            if(!ind1) {
                for (Paket paket : paketi) {
                    if (paket instanceof Kutija) {
                        taIspis.appendText(paket.toString() + ", P =" + String.format("%.2f", paket.povrsina()) + "\n");
                        ind = true;
                    }
                }
                if (!ind) {
                    taIspis.setText("Nema kutija medju paketima");
                }
                if (tfCena.getText().isEmpty())
                    taIspis.appendText("Nije uneta cena");

                ind1= true;
            }

        });

        Scene scena = new Scene(root, 350,450);
        stage.setScene(scena);
        stage.setTitle("Paketi");
        stage.show();

    }
}
