public abstract class Program {
    private String ime;
    private double potrebnoMemorije;
    private Platforma p;

    public Program(String ime, double potrebnoMemorije, Platforma y){
        this.ime = ime;
        this.potrebnoMemorije = potrebnoMemorije;
        p = new Platforma(y);
    }

    public Program(Program p1){
        this(p1.ime, p1.potrebnoMemorije, p1.p);
    }
    public abstract double cenaIzvrsavanja();
    public abstract double memorijskoZauzece();

    public String getIme() {
        return ime;
    }

    public double getPotrebnoMemorije() {
        return potrebnoMemorije;
    }

    public Platforma getP() {
        return p;
    }
}
