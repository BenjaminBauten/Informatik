package de.benjaminbauten;

import basis.*;

public class Zahlenraten {

    Fenster fenster;
    BeschriftungsFeld titel, frage, bewertung;
    ZahlenFeld zahl;
    TextFeld bewertung1;

    Integer zufallszahl, gedachteZahl;

    public Zahlenraten(){
        fenster = new Fenster("Zahlenraten", 400, 600);
        titel = new BeschriftungsFeld("Zahlenraten", 20, 20, 200, 20);
        frage = new BeschriftungsFeld("Welche Zahl rätst du?", 20, 80, 200, 20);
        bewertung = new BeschriftungsFeld("Bewertung", 20, 200, 200, 20);
        zahl = new ZahlenFeld(20, 110, 30, 20);
        bewertung1 = new TextFeld(20, 230, 100, 20);

        zufallszahl = Hilfe.zufall(1, 2);
        gedachteZahl = zahl.ganzZahl();

        if (zufallszahl.equals(gedachteZahl)) {
            bewertung.setzeText("gewonnen");
        }
    }

    public void spielen(){

    }

    public void neuesSpiel(){

    }
}
