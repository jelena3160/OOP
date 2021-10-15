package Pakovanje;

public class Kutija extends Paket{

    private double a,b,c;

    public Kutija(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public char vrsta() {
        return 'K';
    }

    @Override
    public double zapremina() {
        double izraz = a*b*c;
        izraz = Double.parseDouble(String.format("%.2f", izraz));
        return izraz;
    }

    @Override
    public double povrsina() {
        return 2*(a*b + a*c + b*c);
    }

    @Override
    public String toString() {
        return "K(" + a +
                ", " + b +
                ", " + c +
                ") V = " + zapremina();
    }
}
