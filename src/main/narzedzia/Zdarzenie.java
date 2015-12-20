package main.narzedzia;

/**
 * Created by MSI on 2015-12-20.
 */
public class Zdarzenie {

    private int typ;
    private double czas;

    public Zdarzenie(int typ, double czas) {
        this.typ = typ;
        this.czas = (czas * 100) / 100;
    }

    public Zdarzenie(Zdarzenie minimum) {
        this.typ = minimum.getTyp();
        this.czas = (minimum.getCzas() * 100) / 100;
    }

    public double getCzas() {
        return (czas * 100) / 100;
    }

    public int getTyp() {
        return typ;
    }
}
