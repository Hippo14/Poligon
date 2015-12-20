package main;

import main.narzedzia.Kanal;
import main.narzedzia.Wykresy;
import main.narzedzia.Zdarzenie;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by MSI on 2015-12-20.
 */
public class SMO {

    private int lambda;
    private int mi;
    private int L;
    private int T;
    private int K;

    private double t;
    private int l;

    private Zdarzenie[] tablica;
    private Zdarzenie[] kolejka;

    private Kanal[] kanaly;

    private Zdarzenie minimum;

    private Wykresy wykresy;

    private int liczba_zgloszen_przybylych = 0;
    private int liczba_zgloszen_obsluzonych = 0;

    public SMO() {
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj lambda: ");
        this.lambda = Integer.parseInt(odczyt.nextLine());

        System.out.println("Podaj mi: ");
        this.mi = Integer.parseInt(odczyt.nextLine());

        this.L = 10;
        this.T = 10;
        this.K = 2;

        this.t = 0.0;
        this.l = 0;

        this.kolejka = new Zdarzenie[L];
        this.tablica = new Zdarzenie[this.K + 1];
        this.kanaly = new Kanal[K];

        try {
            this.wykresy = new Wykresy();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Błąd otwarcia pliku!");
        }

        //tworzenie obiektow symulujacych kanaly
        for (int i = 0; i < K; i++)
            this.kanaly[i] = new Kanal(i+1);

        //wstawiamy nieskończoność do tablicy
        for (int i = 0; i < tablica.length; i++)
            tablica[i] = new Zdarzenie(0, Double.POSITIVE_INFINITY);
    }

    public void simulate() {
        // Tworzymy pierwsze zdarzenie
        Zdarzenie zdarzenie = new Zdarzenie(1, 1.0/this.lambda);
        this.liczba_zgloszen_przybylych++;
        this.tablica[0] = zdarzenie;

        while (t < T) {
            // Szukamy minimum w tablicy
            this.minimum = minimum(tablica);

            // Sprawdza czy zdarzenie jest typu I
            if (this.minimum.getTyp() == 1) {
                // Czy kolejka jest pełna
                if (l < L) {
                    // Dodaj zdarzenie do kolejki

                    // Kanał obsługi jest pusty
                    if(czyPustyKanal()) {
                        // Przeniesienie zdarzenia z kolejki do kanalu obslugi (FIFO)

                        // Okreslenie momentu konca obslugi zdarzenia przez kanal obslugi

                        // Wstawienie zdarzenia typu II do tablicy zdarzen

                        // Ustalenie momentu przyjscia nastepnego zdarzenia
                    }
                    else {
                        // Wszystkie kanały są zajęte, zostawiamy zgłoszenie w kolejce

                        // Ustalenie momentu przyjscia nastepnego zdarzenia
                    }
                }
                else {
                    // Kolejka jest pełna

                    // Ustalenie momentu przyjscia nastepnego zdarzenia
                }
            }
            // Zdarzenie jest typu II
            else {
                // Czy kolejka jest pusta
                if (l == 0) {
                    // Wstaw INFINITY do tablicy zdarzeń typu II

                    // Ustalenie momentu przyjścia następnego zdarzenia
                }
                else {
                    // Przeniesienie zdarzenia z kolejki do kanalu obslugi (FIFO)

                    // Określenie momentu końca obsługi zdarzenia przez kanał obsługi

                    // Wstawienie zdarzenia typu II do tablicy zdarzeń

                    // Ustalenie momentu przyjścia następnego zdarzenia
                }
            }
        }
    }

    private boolean czyPustyKanal() {
        for (int i = 0; i < kanaly.length; i++) {
            if (kanaly[i].getWolny()) {
                return true;
            }
        }
        return false;
    }

    private Zdarzenie minimum(Zdarzenie[] tablica) {
        Zdarzenie wynik = tablica[0];
        for (int i=1; i<tablica.length; i++) {
            if (wynik.getCzas() > tablica[i].getCzas()) {
                wynik = tablica[i];
            }
        }
        return wynik;
    }

}