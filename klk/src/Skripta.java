public class Skripta extends Program{

    private SkriptJezik jezik;
    private double cenaInstrukcije;
    private int brojLinija;

    public Skripta(String ime, double potrebnoMemorije, Platforma p, SkriptJezik jezik, double cenaInstrukcije, int brojLinija) {
        super(ime, potrebnoMemorije, p);
        this.jezik = jezik;
        this.cenaInstrukcije = cenaInstrukcije;
        this.brojLinija = brojLinija;
    }

    public SkriptJezik getJezik() {
        return jezik;
    }

    public double getCenaInstrukcije() {
        return cenaInstrukcije;
    }

    public int getBrojLinija() {
        return brojLinija;
    }

    public void setBrojLinija(int brojLinija) {
        this.brojLinija = brojLinija;
    }

    @Override
    public String toString() {
        return "[skripta] " + getIme() + "." + jezik.toString() + " " + getPotrebnoMemorije() + "MB platforma = "
                + getP().getIme() + " broj linija = " + brojLinija + " cena instrukcije = " + cenaInstrukcije;
    }

    @Override
    public double cenaIzvrsavanja() {
        return getP().getBrojInstrukcijaZaUcitavanjeProcesa() + (brojLinija * cenaInstrukcije);
    }

    @Override
    public double memorijskoZauzece() {
        return getPotrebnoMemorije();
    }
}
