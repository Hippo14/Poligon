package main.narzedzia;

import java.util.LinkedList;

/**
 * Created by MSI on 2015-12-20.
 */
public class Kolejka {

    //private Zdarzenie[] kolejka;
    private LinkedList<Zdarzenie> kolejka;
    private int L;
    public int count;

    public Kolejka(int L) {
        this.L = L;
        this.kolejka = new LinkedList<>();
        this.count = 0;
    }

    public void dodaj(Zdarzenie minimum) {
//        for (int i = 0; i < this.kolejka.length; i++)
//            if (kolejka[i] == null) {
//                kolejka[i] = new Zdarzenie(minimum);
//                break;
//            }
        this.kolejka.add(minimum);
        this.count++;
    }

    public Zdarzenie usun() {
        Zdarzenie temp = this.kolejka.getFirst();
        this.kolejka.removeFirst();
        this.count--;

        return temp;
    }

    public int getCount() {
        return count;
    }
}
