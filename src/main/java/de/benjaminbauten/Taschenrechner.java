package de.benjaminbauten;

import basis.*;

public class Taschenrechner {
    private Fenster fenster;
    private Knopf k0,k1, k2, k3, k4, k5, k6, k7, k8, k9, kGeteilt, kMal, kMinus, kPlus, kGleich, kKomma, ende;
    private int breite, hoehe, startx, starty;
    TextFeld ausgabe;
    BeschriftungsFeld titel;

    public Taschenrechner(){
        //Tastenbereich
        startx = 50;
        starty = 180;
        breite = 50;
        hoehe = 50;
        fenster = new Fenster("Taschenrechner", 300, 450);
        k0 = new Knopf("0", startx, starty+hoehe*3, breite, hoehe);
        k1 = new Knopf("1", startx, starty, breite, hoehe);
        k2 = new Knopf("2", startx + breite, starty, breite, hoehe);
        k3 = new Knopf("3", startx + breite*2, starty, breite, hoehe);
        k4 = new Knopf("4", startx, starty + hoehe, breite, hoehe);
        k5 = new Knopf("5", startx + breite, starty + hoehe, breite, hoehe);
        k6 = new Knopf("6", startx + breite*2, starty + hoehe, breite, hoehe);
        k7 = new Knopf("7", startx, starty + hoehe*2, breite, hoehe);
        k8 = new Knopf("8", startx + breite, starty + hoehe*2, breite, hoehe);
        k9 = new Knopf("9", startx + breite*2, starty + hoehe*2, breite, hoehe);
        kGeteilt = new Knopf("/", startx + breite*3, starty, breite, hoehe);
        kMal = new Knopf("x", startx + breite*3, starty + hoehe, breite, hoehe);
        kMinus = new Knopf("-", startx + breite*3, starty + hoehe*2, breite, hoehe);
        kPlus = new Knopf("+", startx + breite*3, starty + hoehe*3, breite, hoehe);
        kGleich = new Knopf("=", startx + breite*2, starty + hoehe*3, breite, hoehe);
        kKomma = new Knopf(".", startx + breite, starty + hoehe*3, breite, hoehe);

        //Rest
        ausgabe = new TextFeld(startx, starty - 50, breite*4, 40);
        ende = new Knopf("Ende", startx, starty + hoehe*4 + 20, breite*4, 30);
        titel = new BeschriftungsFeld("Taschenrechner", startx, 20, breite*4, hoehe);
        titel.setzeSchriftGroesse(20);
    }


}
