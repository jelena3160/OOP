package BorbaHranom;

public class Supa extends Hrana{
    private double temperatura;

    public Supa(double tezina, double domet, double temperatura) {
        super(tezina, domet);
        this.temperatura = temperatura;
    }
    public Supa(Supa s){
        this(s.getTezina(), s.getDomet(), s.temperatura);
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void baci(){
        String ind;
        if(temperatura < 30)
            ind = "ledena";
        else if(temperatura <= 45)
            ind = "mlaka";
        else
            ind = "vrela";

        System.out.println(ind + " supa krstari vazduhom ka svojoj meti");
    }

    @Override
    public String toString() {
        return "[Supa] " +
                " temperatura: " + temperatura +
                "C, " + super.toString();
    }
}
