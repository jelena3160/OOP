package BusPlus;

public class Nepersonalizovana extends BusPlus{
    private int kredit;
    private boolean ocitana;

    public static int cenaVoznje = 90;

    public Nepersonalizovana(int id, int zona, int kredit, boolean ocitana) {
        super(id, zona);
        this.kredit = kredit;
        this.ocitana = ocitana;
    }

    public int getKredit() {
        return kredit;
    }

    public boolean isOcitana() {
        return ocitana;
    }

    public boolean nedovoljnoKredita(){
        if(kredit - Nepersonalizovana.cenaVoznje > 0)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Nepersonalizovana{" +
                "kredit=" + kredit +
                ", ocitana=" + ocitana +
                "} " + super.toString();
    }
}
