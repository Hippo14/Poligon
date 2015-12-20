package main.narzedzia;

import java.util.LinkedList;

/**
 * Created by MSI on 2015-12-20.
 */
public class Kolejka {

    //private Zdarzenie[] kolejka;
    private LinkedList<Zdarzenie> kolejka;
    private int L;

    public Kolejka(int L) {
        this.L = L;
        this.kolejka = new LinkedList<>();
    }

    public void dodaj(Zdarzenie minimum) {
//        for (int i = 0; i < this.kolejka.length; i++)
//            if (kolejka[i] == null) {
//                kolejka[i] = new Zdarzenie(minimum);
//                break;
//            }
        this.kolejka.add(minimum);
    }

    public Zdarzenie usun() {
        Zdarzenie temp = this.kolejka.getFirst();
        this.kolejka.removeFirst();

        return temp;
    }
}
