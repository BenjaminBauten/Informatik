package de.benjaminbauten;

import basis.Fenster;
import basis.Hilfe;

import java.io.IOException;


public class GallopierendesPferd {

    private final Fenster fensterPferd;

    public GallopierendesPferd() throws IOException {
        fensterPferd = new Fenster("erstes Kino", 300, 200);
        this.setFensterPferd();
    }

    public void setFensterPferd() throws IOException {
        while (true) {
            for (int i = 0; i < 15; i++) {


                fensterPferd.ladeBildInZeichenflaeche(new java.io.File("./repo/de/Bilder/Muybridge_race_horse_animated-" + i + ".png").getCanonicalPath());
                Hilfe.pause(66);
            }

        }
    }

}
