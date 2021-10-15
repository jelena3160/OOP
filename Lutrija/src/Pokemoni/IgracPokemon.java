package Pokemoni;

public class IgracPokemon extends Pokemon{

    private int izabranaMagija;

    public IgracPokemon(String ime, int nivo, Magija magija1, Magija magija2) {
        super(ime, nivo, magija1, magija2);
        this.izabranaMagija = 1;
    }

    public int getIzabranaMagija() {
       return izabranaMagija;
    }

    public void setIzabranaMagija(int i){
        if(i != 1 && i != 2)
            return;
        else
            this.izabranaMagija = i;
    }


    @Override
    public void baciMagiju(Pokemon neprijatelj) {
        if(izabranaMagija == 1){
            neprijatelj.nanesiStetu(getMagija1().getSnaga());
        }
    }
}
