package BusPlus;

public class Personalizovana extends BusPlus{

    private Kategorija kategorija;
    private boolean imaDopunu;

    public Personalizovana(int id, int zona, Kategorija kategorija, boolean imaDopunu) {
        super(id, zona);
        this.kategorija = kategorija;
        this.imaDopunu = imaDopunu;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public boolean isImaDopunu() {
        return imaDopunu;
    }

    @Override
    public String toString() {
        return "[" + getKategorija() + "] zona: " + super.getZona() + " | " + (isImaDopunu() ? " dopunjena" : " bez dopune");
    }
}
