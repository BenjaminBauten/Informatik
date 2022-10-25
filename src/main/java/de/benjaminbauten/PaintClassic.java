package de.benjaminbauten;
import basis.*;

import java.awt.*;

public class PaintClassic {

    private Fenster fenster;
    private Stift stift;
    private Maus maus;
    private Tastatur tastatur = new Tastatur();
    public PaintClassic(int breite, int hoehe){
        fenster = new Fenster("Zeichenfläche", breite, hoehe);
        stift = new Stift();
        maus = new Maus();
        zeichnen();
    }

    public void zeichnen(){
        //while() {
            if (tastatur.wurdeGedrueckt()){
                tastatur.holeZeichen();
                switch (tastatur.aktuellesZeichen()){
                    case 'r' : stift.setzeLinienBreite(20); stift.radiere();
                    case 'b' : stift.runter();stift.setzeFarbe(Color.BLUE);
                    case 'z' : stift.runter(); stift.setzeLinienBreite(10);
                }

            //}
            Hilfe.kurzePause();
            stift.bewegeBis(maus.hPosition(), maus.vPosition());
            if (maus.istGedrueckt()){
                stift.runter();
            }
            if (!maus.istGedrueckt()){
                stift.hoch();
            }

        }

        while(maus.istGedrueckt()){
            stift.runter();
            stift.bewegeBis(maus.hPosition(), maus.vPosition());
        }
    }

    public void Tastatur(){
        if (tastatur.wurdeGedrueckt()){
            tastatur.holeZeichen();
            switch (tastatur.aktuellesZeichen()){
                case 'r' : stift.radiere(); stift.setzeLinienBreite(50);
                case 'b' : stift.runter();stift.setzeFarbe(Color.BLUE);
                case 'z' : stift.runter(); stift.setzeLinienBreite(1);
            }

        }
    }

}
