package main;

import main.narzedzia.*;

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

    private TablicaZdarzen tablicaZdarzen;
    private Kolejka kolejka;
    private Kanaly kanaly;

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
        this.K = 1;

        this.t = 0.0;
        this.l = 0;

        try {
            this.wykresy = new Wykresy();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Błąd otwarcia pliku!");
        }

        this.kanaly = new Kanaly(this.K);
        this.kolejka = new Kolejka(this.L);
        this.tablicaZdarzen = new TablicaZdarzen(this.K);
    }

    public void simulate() {
        // Tworzymy pierwsze zdarzenie
        this.tablicaZdarzen.dodajDoTypuI(new Zdarzenie(1, 1.0/this.lambda));
        this.liczba_zgloszen_przybylych++;

        while (t < T) {
            // Szukamy minimum w tablicy
            this.minimum = this.tablicaZdarzen.minimum();

            // Sprawdza czy zdarzenie jest typu I
            if (this.minimum.getTyp() == 1) {
                this.t = this.minimum.getCzas();

                // Czy kolejka jest pełna
                if (l < L) {
                    // Dodaj zdarzenie do kolejki
                    this.kolejka.dodaj(this.minimum);

                    // Kanał obsługi jest pusty
                    if(this.kanaly.czyPustyKanal()) {
                        // Przeniesienie zdarzenia z kolejki do kanalu obslugi (FIFO)
                        Zdarzenie temp = this.kolejka.usun();

                        // Okreslenie momentu konca obslugi zdarzenia przez kanal obslugi
                        double koniecObslugi = this.t + (1.0 / this.mi);

                        // Dodaj do kanału
                        int id = this.kanaly.dodaj(temp, koniecObslugi);

                        // Wstawienie zdarzenia typu II do tablicy zdarzen
                        this.tablicaZdarzen.dodajDoTypuII(id, koniecObslugi);

                        // Ustalenie momentu przyjscia nastepnego zdarzenia
                        ustalenieMomentuPrzyjscia();
                    }
                    else {
                        // Wszystkie kanały są zajęte, zostawiamy zgłoszenie w kolejce

                        // Ustalenie momentu przyjscia nastepnego zdarzenia
                        ustalenieMomentuPrzyjscia();
                    }
                }
                else {
                    // Kolejka jest pełna

                    // Ustalenie momentu przyjscia nastepnego zdarzenia
                    ustalenieMomentuPrzyjscia();
                }
            }
            // Zdarzenie jest typu II
            else {
                this.t = this.minimum.getCzas();

                // Zwróc id kanału
                int id = this.kanaly.getIdKanalu(this.minimum);
                // Zwolnij kanał
                this.kanaly.zwolnij(id);
                this.liczba_zgloszen_obsluzonych++;

                // Czy kolejka jest pusta
                if (l == 0) {
                    // Wstaw INFINITY do tablicy zdarzeń typu II
                    this.tablicaZdarzen.dodajDoTypuIINieskonczonosc(id);

                    // Ustalenie momentu przyjścia następnego zdarzenia
                    ustalenieMomentuPrzyjscia();
                }
                else {
                    // Przeniesienie zdarzenia z kolejki do kanalu obslugi (FIFO)
                    Zdarzenie temp = this.kolejka.usun();

                    // Określenie momentu końca obsługi zdarzenia przez kanał obsługi
                    double koniecObslugi = this.t + (1.0 / this.mi);

                    this.kanaly.dodaj(id, temp, koniecObslugi);

                    // Wstawienie zdarzenia typu II do tablicy zdarzeń
                    this.tablicaZdarzen.dodajDoTypuII(id, koniecObslugi);

                    // Ustalenie momentu przyjścia następnego zdarzenia
                    ustalenieMomentuPrzyjscia();
                }
            }
        }
    }

    private void ustalenieMomentuPrzyjscia() {
        Zdarzenie temp = this.tablicaZdarzen.getTypI();
        this.tablicaZdarzen.dodajDoTypuI(new Zdarzenie(1, temp.getCzas() + (1.0 / this.lambda)));
        this.liczba_zgloszen_przybylych++;
    }

}