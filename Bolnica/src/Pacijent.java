public class Pacijent implements Izleciv, Comparable<Pacijent>{

    private String ime, prezime;
    private int id, duzinaLecenja;
    private boolean zarazen;
    private ZaraznaBolest dijagnoza;

    public Pacijent(String ime, String prezime, int id, ZaraznaBolest bolest) {
        this.ime = ime;
        this.prezime = prezime;
        this.id = id;
        dijagnoza = bolest;
        duzinaLecenja = 0;
        zarazen = false;
   }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getId() {
        return id;
    }

    public int getDuzinaLecenja() {
        return duzinaLecenja;
    }

    public void setDuzinaLecenja(int duzinaLecenja) {
        this.duzinaLecenja = duzinaLecenja;
    }

    public boolean isZarazen() {
        return zarazen;
    }

    public void setZarazen(boolean zarazen) {
        this.zarazen = zarazen;
    }

    public ZaraznaBolest getDijagnoza() {
        return dijagnoza;
    }



    @Override
    public void leci(int brojDana) {
        setDuzinaLecenja(duzinaLecenja + brojDana);
    }

    @Override
    public boolean izlecen() {
        if(duzinaLecenja >= dijagnoza.getDuzinaBolesti())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " " + ime + " " + prezime + "\n" + (izlecen() ? "" : "boluje od: " + dijagnoza.toString() +
                " vreme do izlecenja: " + (dijagnoza.getDuzinaBolesti() - duzinaLecenja));
    }

    @Override
    public int compareTo(Pacijent o) {
        if(dijagnoza instanceof Korona && o.getDijagnoza() instanceof Grip)
            return -1;
        else if(dijagnoza instanceof Korona && o.getDijagnoza() instanceof Korona ||
                dijagnoza instanceof Grip && o.getDijagnoza() instanceof Grip)
            return Integer.compare(o.getDijagnoza().getDuzinaBolesti(), dijagnoza.getDuzinaBolesti());
        else if(dijagnoza instanceof Grip && o.getDijagnoza() instanceof Korona)
            return 1;
        else
            return 0;

    }
}
