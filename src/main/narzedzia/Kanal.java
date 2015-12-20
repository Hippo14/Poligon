package main.narzedzia;

/**
 * Created by MSI on 2015-12-20.
 */
public class Kanal {

    private int id;
    private boolean wolny;
    private double koniecObslugi;
    private Zdarzenie zdarzenie;

    public Kanal(int id) {
        this.id = id;
        this.wolny = true;
        this.koniecObslugi = Double.POSITIVE_INFINITY;
        this.zdarzenie = null;
    }

    public boolean getWolny() {
        return wolny;
    }

    public void dodajZdarzenie(Zdarzenie zdarzenie, double koniecObslugi) {
        this.zdarzenie = zdarzenie;
        this.koniecObslugi = koniecObslugi;
        this.wolny = false;
    }

    public int getId() {
        return id;
    }

    public Zdarzenie getZdarzenie() {
        return zdarzenie;
    }

    public double getKoniecObslugi() {
        return koniecObslugi;
    }

    public void zwolnij() {
        this.zdarzenie = null;
        this.wolny = true;
        this.koniecObslugi = Double.POSITIVE_INFINITY;
    }
}
