import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Listic {
    private int premija;

    public Listic(int premija) {
        this.premija = premija;
    }

    public int getPremija() {
        return premija;
    }

    public abstract int odrediDobitak();
    public abstract String proveriDobitak();


    public static Random random = new Random();
    public static List<Integer> izvlacenje(int brojLoptica, int gornjaGranica){
        List<Integer> lista = new ArrayList<>();
        while(brojLoptica > 0){
            int noviBroj = random.nextInt(gornjaGranica + 1);

            while(lista.contains(noviBroj))
                noviBroj = random.nextInt(gornjaGranica + 1);

            lista.add(noviBroj);
        }
        return lista;
    }
}
