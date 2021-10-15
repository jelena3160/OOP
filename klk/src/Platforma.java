public class Platforma {
    private String ime;
    private double brojInstrukcijaZaUcitavanjeProcesa, memorijaZaProces;

    public Platforma(String ime, double brojInstrukcijaZaUcitavanjeProcesa, double memorijaZaProces){
        this.ime = ime;
        this.brojInstrukcijaZaUcitavanjeProcesa = brojInstrukcijaZaUcitavanjeProcesa;
        this.memorijaZaProces = memorijaZaProces;
    }

    public Platforma(Platforma p){
        this(p.ime, p.brojInstrukcijaZaUcitavanjeProcesa, p.memorijaZaProces);
    }

    public String getIme() {
        return ime;
    }

    public double getBrojInstrukcijaZaUcitavanjeProcesa() {
        return brojInstrukcijaZaUcitavanjeProcesa;
    }

    public double getMemorijaZaProces() {
        return memorijaZaProces;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setBrojInstrukcijaZaUcitavanjeProcesa(double brojInstrukcijaZaUcitavanjeProcesa) {
        this.brojInstrukcijaZaUcitavanjeProcesa = brojInstrukcijaZaUcitavanjeProcesa;
    }

    public void setMemorijaZaProces(double memorijaZaProces) {
        this.memorijaZaProces = memorijaZaProces;
    }

    @Override
    public String toString() {
        return "- " + ime + " broj instrukcija za ucitavanje procesa = " + brojInstrukcijaZaUcitavanjeProcesa +
                " memorija za proces = " + memorijaZaProces + "MB";
    }
}
