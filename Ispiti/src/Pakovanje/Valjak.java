package Pakovanje;

public class Valjak extends Paket{

    private double a, h;

    public Valjak(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public char vrsta() {
        return 'V';
    }

    @Override
    public double zapremina() {
        double izraz = a*a*h*Math.PI;
        izraz = Double.parseDouble(String.format("%.2f", izraz));
        return izraz;
    }

    @Override
    public double povrsina() {
        return 2*a*a*Math.PI + 2*a*h;
    }
    @Override
    public String toString() {
        return "V(" + a +
                ", " + h +
                ") V = " + zapremina();
    }
}
