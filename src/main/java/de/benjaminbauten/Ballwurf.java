package de.benjaminbauten;

import basis.Bild;
import basis.Fenster;
import basis.Hilfe;

import java.io.IOException;

public class Ballwurf {

    private Bild bildBall;

    public Ballwurf() throws IOException {
        new Fenster("Ballwurf", 1000, 800);
        this.initialize();
    }

    public void initialize() throws IOException{
        bildBall = new Bild(new java.io.File("./repo/de/BildBallwurf/Jonah.png").getCanonicalPath());
        Bild bildPerson1 = new Bild(new java.io.File("./repo/de/BildBallwurf/WerferHelge.png").getCanonicalPath());
        Bild bildPerson2 = new Bild(new java.io.File("./repo/de/BildBallwurf/Werfer2Helge.png").getCanonicalPath());

        bildBall.setzePosition(80, 230);
        bildPerson1.setzePosition(400, 200);
        bildPerson2.setzePosition(5, 200);
        this.throwBall();
    }

    public void throwBall() {
        while (true) {
            this.bewegeNachRechts();
            this.bewegeNachLinks();
        }
    }

    public void bewegeNachRechts() {

        for (double i = -1; i < 1; ) {
            bildBall.setzePosition(bildBall.hPosition() + 1, bildBall.vPosition() + i);
            i = i + 0.0045;
            Hilfe.pause(3);
        }
    }

    public void bewegeNachLinks() {
        for (double i = -1; i < 1; ) {
            bildBall.setzePosition(bildBall.hPosition() - 1, bildBall.vPosition() + i);
            i = i + 0.0045;
            Hilfe.pause(3);
        }
    }


}
