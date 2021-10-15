package Pokemoni;

public class Magija {

    private int snaga;
    private String ime;

    public Magija(int snaga, String ime) {
        this.snaga = snaga;
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public int getSnaga() {
        return snaga;
    }

    @Override
    public String toString() {
        return ime + snaga;
    }


}
