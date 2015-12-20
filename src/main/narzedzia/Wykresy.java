package main.narzedzia;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by MSI on 2015-12-19.
 */
public class Wykresy {

    private PrintWriter wykres;
    private PrintWriter wykres1;    // Przyjście zgłoszenia do systemu
    private PrintWriter wykres2;    // Zajętość kolejki
    private PrintWriter wykres3;    // Zajętość kanału
    private PrintWriter wykres4;    // Liczba zgłoszeń przybytych do systemu
    private PrintWriter wykres5;    // Liczba zgłoszeń obsłużonych przez system

    public Wykresy() throws FileNotFoundException {
        this.wykres = new PrintWriter("wykres.txt");
        this.wykres1 = new PrintWriter("wykres1.txt");
        this.wykres2 = new PrintWriter("wykres2.txt");
        this.wykres3 = new PrintWriter("wykres3.txt");
        this.wykres4 = new PrintWriter("wykres4.txt");
        this.wykres5 = new PrintWriter("wykres5.txt");
    }

    public void close() {
        this.wykres.close();
        this.wykres1.close();
        this.wykres2.close();
        this.wykres3.close();
        this.wykres4.close();
        this.wykres5.close();
    }

    public void dodajDoWykresu(double lambda, double mi, int K) {
        wykres.println("lambda: " + lambda);
        wykres.println("mi: " + mi);
        wykres.println("liczba kanałów: " + K);
    }

    public void dodajDoWykresu1(double czas) {
        wykres1.println(czas);
    }

    public void dodajDoWykresu2(int count, double t) {
        wykres2.println(t + "\t" + count);
    }

    public void dodajDoWykresu3(int count, double t) {
        wykres3.println(t + "\t" + count);
    }

    public void dodajDoWykresu4(int liczba_zgloszen_przybylych, double v) {
        wykres4.println(Math.floor(v) + "\t" + liczba_zgloszen_przybylych);
    }

    public void dodajDoWykresu5(int liczba_zgloszen_obsluzonych, double v) {
        wykres5.println(Math.floor(v) + "\t" + liczba_zgloszen_obsluzonych);
    }
}