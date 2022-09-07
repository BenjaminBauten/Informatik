package de.benjaminbauten;
import basis.*;

public class BilderGalerie {

    private Fenster fenster2;
    private Bild bild1, bild2;
    private Stift stift2;

    public BilderGalerie(int breite, int hoehe){
        fenster2 = new Fenster("Galerie", breite, hoehe);
        stift2 = new Stift();
        bild1 = new Bild(50,50, 150,100);
        bild2 = new Bild(200, 200, 200,200);
        bild1.setzeHintergrundFarbe(Farbe.GRAU);
        bild2.setzeHintergrundFarbe(Farbe.ROT);
    }


    public void zeichneAlles(){
        stift2.runter();
        stift2.maleAuf(bild2);
        stift2.bewegeBis(100,100);
        stift2.zeichneKreis(70);
        stift2.maleAuf(bild1);
        stift2.bewegeBis(20, 20);
        stift2.zeichneRechteck(100,70);
    }


}
