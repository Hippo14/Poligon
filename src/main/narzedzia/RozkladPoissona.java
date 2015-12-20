package main.narzedzia;

import java.util.Random;

/**
 * Created by MSI on 2015-12-20.
 */
public class RozkladPoissona {

    private Random random;

    public RozkladPoissona() {
        this.random = new Random();
    }

    public double lambda(double lambda) {
        double losowaLiczba = (this.random.nextInt(99) + 1) / 100.0;
        double deltaLambda = ( -1.0 / lambda * Math.log(losowaLiczba) );

        return deltaLambda;
    }

    public double mi(double mi) {
        double losowaLiczba = (this.random.nextInt(100) + 1) / 100.0;
        double deltaMi = ( -1.0 / mi * Math.log(losowaLiczba) );

        return deltaMi;
    }

}