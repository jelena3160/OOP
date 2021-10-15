package BorbaHranom;

public class Jabuka extends Hrana{

    private String boja;

    public Jabuka(double tezina, double domet, String boja) {
        super(tezina, domet);
        this.boja = boja;
    }

    public Jabuka(Jabuka j){
        this(j.getTezina(), j.getDomet(), j.boja);
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public void baci(){
        System.out.println((getTezina() > 200 ? "ogromna " : "") + boja + " jabuka leti kroz vazduh");
    }

    @Override
    public String toString() {
        return "[Jabuka] " +
                "boja: " + boja  + super.toString();
    }
}
