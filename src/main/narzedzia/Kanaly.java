package main.narzedzia;

/**
 * Created by MSI on 2015-12-20.
 */
public class Kanaly {

    private Kanal[] kanaly;
    private int K;

    public Kanaly(int K) {
        this.K = K;
        this.kanaly = new Kanal[this.K];

        for (int i = 0; i < this.kanaly.length; i++) {
            this.kanaly[i] = new Kanal(i+1);
        }
    }

    public boolean czyPustyKanal() {
        for (int i = 0; i < kanaly.length; i++) {
            if (kanaly[i].getWolny()) {
                return true;
            }
        }
        return false;
    }

    public int dodaj(Zdarzenie zdarzenie, double koniecObslugi) {
        int id = 0;

        for (int i = 0; i < this.kanaly.length; i++) {
            if (kanaly[i].getWolny()) {
                kanaly[i].dodajZdarzenie(zdarzenie, koniecObslugi);
                id = kanaly[i].getId();
                break;
            }
        }

        return id;
    }

    public int getIdKanalu(Zdarzenie zdarzenie) {
        int id = 0;
        for (int i = 0; i < this.kanaly.length; i++) {
            if (zdarzenie.getCzas() == this.kanaly[i].getKoniecObslugi()) {
                id = this.kanaly[i].getId();
            }
        }

        return id;
    }

    public void zwolnij(int id) {
        this.kanaly[id + 1].zwolnij();
    }

    public void dodaj(int i, Zdarzenie zdarzenie, double koniecObslugi) {
        if (this.kanaly[i].getWolny()) {
            this.kanaly[i].dodajZdarzenie(zdarzenie, koniecObslugi);
        }
    }
}
