package de.benjaminbauten;
import basis.*;


public class gallopierendesPferd {

    private Fenster fensterPferd;

    public gallopierendesPferd(){
        fensterPferd = new Fenster();
        setFensterPferd();
    }

    public void setFensterPferd(){
        while (true){
            for (int i = 0; i<15; i++){

                fensterPferd.ladeBildInZeichenflaeche("/Users/danielbauten/IdeaProjects/Informatik/src/main/java/de/benjaminbauten/Bilder/Muybridge_race_horse_animated-" + i + ".png");
                Hilfe.pause(66);
            }

        }
    }

}
