package Pokemoni;

public abstract class Pokemon {
    private String ime;
    private int nivo, zivot;
    private Magija magija1, magija2;

    public Pokemon(String ime, int nivo, Magija magija1, Magija magija2) {
        this.ime = ime;
        this.nivo = nivo;
        this.zivot = 100;
        this.magija1 = magija1;
        this.magija2 = magija2;
    }

    public String getIme() {
        return ime;
    }

    public int getNivo() {
        return nivo;
    }

    public int getZivot() {
        return zivot;
    }

    public Magija getMagija1() {
        return magija1;
    }

    public Magija getMagija2() {
        return magija2;
    }

    public void nanesiStetu(int kolikoStete){
        int noviZivot = zivot - kolikoStete;
    }

    public abstract void baciMagiju(Pokemon neprijatelj);

    @Override
    public String toString() {
        return "[lvl" + nivo + "] " + ime;
    }
}
