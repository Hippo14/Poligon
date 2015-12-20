package main.narzedzia;

/**
 * Created by MSI on 2015-12-20.
 */
public class TablicaZdarzen {

    private Zdarzenie tablica[];

    public TablicaZdarzen(int K) {
        this.tablica = new Zdarzenie[K + 1];

        for (int i = 0; i < this.tablica.length; i++) {
            this.tablica[i] = new Zdarzenie(0, Double.POSITIVE_INFINITY);
        }
    }

    public void dodajDoTypuI(Zdarzenie zdarzenie) {
        this.tablica[0] = zdarzenie;
    }

    public Zdarzenie minimum() {
        Zdarzenie wynik = this.tablica[0];
        for (int i=1; i<this.tablica.length; i++) {
            if (wynik.getCzas() > this.tablica[i].getCzas()) {
                wynik = this.tablica[i];
            }
        }
        return wynik;
    }

    public void dodajDoTypuII(int i, double koniecObslugi) {
        this.tablica[i] = new Zdarzenie(2, koniecObslugi);
    }

    public void dodajDoTypuIINieskonczonosc(int i) {
        this.tablica[i] = new Zdarzenie(2, Double.POSITIVE_INFINITY);
    }

    public Zdarzenie getTypI() {
        return this.tablica[0];
    }
}
