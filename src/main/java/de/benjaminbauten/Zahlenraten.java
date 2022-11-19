package de.benjaminbauten;

import basis.*;

public class Zahlenraten {

    Fenster fenster;
    BeschriftungsFeld titel, frage, bewertung, spielbeschreibung, versucheB;
    ZahlenFeld zahl;
    TextFeld bewertung1;
    int zufallszahl, gedachteZahl, versuche;
    Knopf neu, ende, tippen;

    public Zahlenraten(){
        fenster = new Fenster("Zahlenraten", 400, 600);
        titel = new BeschriftungsFeld("Zahlenraten", 20, 20, 200, 20);
        titel.setzeSchriftGroesse(20);
        frage = new BeschriftungsFeld("Welche Zahl rätst du?", 20, 80, 200, 20);
        bewertung = new BeschriftungsFeld("Bewertung", 20, 200, 200, 20);
        zahl = new ZahlenFeld(20, 110, 30, 20);
        bewertung1 = new TextFeld(20, 230, 100, 20);
        neu = new Knopf("Neu", 60, 300, 60, 30);
        ende = new Knopf("Ende", 150, 300, 60, 30);
        //ende.setzeKnopfLauscher(knopf -> fenster.gibFrei());
        tippen = new Knopf("Tippen", 60, 140, 90, 30);
        spielbeschreibung = new BeschriftungsFeld("Es wird eine zufällige Zahl zwischen 1 und 99 ausgewählt.", 20, 50, 400, 20);

        zufallszahl = Hilfe.zufall(1, 99);
        versuche = 0;
        versucheB = new BeschriftungsFeld(String.valueOf(versuche) + " Versuche", 100, 270, 100, 20);

        this.spielen();
    }

    public void spielen(){
        System.out.println(zufallszahl);
        while (!ende.wurdeGedrueckt()){
            Hilfe.kurzePause();
            if (tippen.wurdeGedrueckt()) {
                gedachteZahl = zahl.ganzZahl();
                versuche = versuche +1;
                versucheB.setzeText(String.valueOf(versuche)+ " Versuche");
            }

            this.auswertung();
            if (ende.wurdeGedrueckt()){
                System.exit(0);
            }

            if (neu.wurdeGedrueckt()){
                neuesSpiel();
            }
        }
    }

    public void neuesSpiel(){
        zufallszahl = Hilfe.zufall(1, 99);
        bewertung1.setzeText("");
        zahl.setzeText("");
        versuche = 0;
        versucheB.setzeText(String.valueOf(versuche)+ " Versuche");
    }

    public void auswertung(){
        if (zufallszahl == gedachteZahl) {
            bewertung1.setzeText("gewonnen");
            //zufallszahl = Hilfe.zufall(1,99);
            //zufallszahl = Hilfe.zufall(1,99);
        } else if(zufallszahl > gedachteZahl) {

            if ((Hilfe.betrag(zufallszahl - gedachteZahl) < 5)) {
                bewertung1.setzeText("heiß");
            } else if ((Hilfe.betrag(zufallszahl - gedachteZahl) < 10)) {
                bewertung1.setzeText("warm");
            } else if ((Hilfe.betrag(zufallszahl - gedachteZahl) < 20)) {
                bewertung1.setzeText("wärmer");
            } else if ((Hilfe.betrag(zufallszahl - gedachteZahl) < 30)) {
                bewertung1.setzeText("kalt");
            } else {
                bewertung1.setzeText("sehr kalt");
            }
        } else if(zufallszahl < gedachteZahl){
            if ((Hilfe.betrag(gedachteZahl - zufallszahl) < 5)) {
                bewertung1.setzeText("heiß");
            } else if ((Hilfe.betrag(gedachteZahl - zufallszahl) < 10)) {
                bewertung1.setzeText("warm");
            } else if ((Hilfe.betrag(gedachteZahl - zufallszahl) < 20)) {
                bewertung1.setzeText("wärmer");
            } else if ((Hilfe.betrag(gedachteZahl - zufallszahl) < 30)) {
                bewertung1.setzeText("kalt");
            } else {
                bewertung1.setzeText("sehr kalt");
            }
        }
    }
}
