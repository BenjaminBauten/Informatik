package de.benjaminbauten;
import basis.*;

import java.awt.*;

public class Ballwurf {

    private Fenster fenster1;
    private Bild bildBall;
    private Bild bildPerson1;
    private Bild bildPerson2;
    private String pfad;
    public Ballwurf(){
        fenster1 = new Fenster("Ballwurf",1000,800);
        pfad = "/Users/danielbauten/IdeaProjects/Informatik/src/main/java/de/benjaminbauten/BildBallwurf/Jonah.png";
        bildBall = new Bild(pfad);
        bildBall.setzePosition(80,230);
        bildPerson1 = new Bild("/Users/danielbauten/IdeaProjects/Informatik/src/main/java/de/benjaminbauten/BildBallwurf/WerferHelge.png");
        bildPerson2 = new Bild("/Users/danielbauten/IdeaProjects/Informatik/src/main/java/de/benjaminbauten/BildBallwurf/Werfer2Helge.png");
        bildPerson1.setzePosition(400,200);
        bildPerson2.setzePosition(5, 200);
        //fenster1.ladeBildInZeichenflaeche(pfad);
        this.Ballwurf();
    }

    public void Ballwurf(){
        while (true) {
            this.bewegeNachRechts();
            this.bewegeNachLinks();
        }
    }

    public void bewegeNachRechts(){
//        while(bildBall.hPosition()<550){
//            bildBall.setzePosition(bildBall.hPosition()+2, bildBall.vPosition());
//            Hilfe.pause(2);
//        }

        for (double i = -1; i < 1;){
            bildBall.setzePosition(bildBall.hPosition()+1, bildBall.vPosition() + i);
            i = i+0.0045;
            Hilfe.pause(3);
        }
    }

    public void bewegeNachLinks(){
//        while (bildBall.hPosition()>80){
//            bildBall.setzePosition(bildBall.hPosition()-2, bildBall.vPosition());
//            Hilfe.pause(2);
//        }
        for (double i = -1; i < 1;){
            bildBall.setzePosition(bildBall.hPosition()-1, bildBall.vPosition() + i);
            i = i+0.0045;
            Hilfe.pause(3);
        }
    }


}
