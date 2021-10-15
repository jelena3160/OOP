public class KompiliranProgram extends Program{

    private int brojInstrukcija;

    public KompiliranProgram(String ime, double potrebnoMemorije, Platforma p, int brojInstrukcija) {
        super(ime, potrebnoMemorije, p);
        this.brojInstrukcija = brojInstrukcija;
    }
    public KompiliranProgram(KompiliranProgram kp){
        this(kp.getIme(), kp.getPotrebnoMemorije(), kp.getP(), kp.brojInstrukcija);
    }



    public int getBrojInstrukcija() {
        return brojInstrukcija;
    }

    @Override
    public String toString() {
        return "[kompiliran program] " + super.getIme() + " " + getPotrebnoMemorije() + "MB platforma = " + getP().getIme()
                + " broj instrukcija = " + brojInstrukcija;
    }

    @Override
    public double cenaIzvrsavanja() {
        return brojInstrukcija + getP().getBrojInstrukcijaZaUcitavanjeProcesa();
    }

    @Override
    public double memorijskoZauzece() {
        return getPotrebnoMemorije() + getP().getMemorijaZaProces();
    }
}
