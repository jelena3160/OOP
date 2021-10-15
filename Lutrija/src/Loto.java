import java.util.List;

import static java.lang.Math.pow;

public class Loto extends Listic{

    private List<Integer> lotoListic;
    public static List<Integer> dobitnaKombinacija;

    public Loto(int premija, List<Integer> lotoListic) {
        super(premija);
        this.lotoListic = lotoListic;
    }

    public List<Integer> getLotoListic() {
        return lotoListic;
    }

    public static List<Integer> getDobitnaKombinacija() {
        return dobitnaKombinacija;
    }

    public void setLotoListic(List<Integer> lotoListic) {
        this.lotoListic = lotoListic;
    }

    public static void setDobitnaKombinacija(List<Integer> dobitnaKombinacija) {
        Loto.dobitnaKombinacija = dobitnaKombinacija;
    }

    public int odrediBrojPogodaka(){
        int i = 0;
        for(Integer x: lotoListic){
            if(dobitnaKombinacija.contains(x))
                i++;
        }
        return i;
    }

    @Override
    public int odrediDobitak() {
        if(odrediBrojPogodaka() < 3)
            return 0;
        return (int) (super.getPremija() / (pow(10, 7- odrediBrojPogodaka())));
    }

    @Override
    public String proveriDobitak() {
        return (odrediDobitak() == 0 ? "Nema nagrade" : "Imate " + odrediBrojPogodaka() + " osvojili ste " + odrediDobitak() + "RSD") ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int broj: lotoListic){
            sb.append(broj).append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }
}
