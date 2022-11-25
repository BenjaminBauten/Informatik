package de.benjaminbauten;

import basis.*;

public class Wuerfelspiel {

    private Fenster fenster;
    private ZahlenFeld eingabe;
    private BeschriftungsFeld b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    private Knopf spielerWechseln, neuesSpiel, wuerfeln;

    private String[] ausgabewerte;

    private boolean spieler1, spieler2;

    private int gewuerfelteZahl1, gewuerfelteZahl2, gewuerfelteZahl3, gewuerfelteZahl4, gewuerfelteZahl5, gewuerfelteZahl6;

    private int[] zahlen;
    private int punktzahlSpieler1, punktzahlSpieler2;

    public Wuerfelspiel() {
        fenster = new Fenster("Würfelspiel", 500, 500);
        b1 = new BeschriftungsFeld("Wie oft möchten Sie würflen?", 20, 20, 300, 20);
        eingabe = new ZahlenFeld(20, 50, 50, 20);
        wuerfeln = new Knopf("Würfeln", 20, 80, 80, 40);

        b2 = new BeschriftungsFeld("Spieler 1", 150, 120, 100, 20);
        b3 = new BeschriftungsFeld("Spieler 2", 300, 120, 100, 20);
        b4 = new BeschriftungsFeld("Punktzahl", 20, 150, 100, 20);
        b5 = new BeschriftungsFeld("Zahlen", 20, 180, 100, 20);
        b6 = new BeschriftungsFeld("", 150, 150, 100, 20);
        b7 = new BeschriftungsFeld("", 300, 150, 100, 20);
        b8 = new BeschriftungsFeld("", 150, 180, 100, 20);
        b9 = new BeschriftungsFeld("", 300, 180, 100, 20);
        b10 = new BeschriftungsFeld("", 150, 50, 300, 20);
        b10.setzeSchriftFarbe(Farbe.ROT);

        spielerWechseln = new Knopf("Spieler wechseln", 20, 220, 140, 40);
        neuesSpiel = new Knopf("neues Spiel", 200, 220, 140, 40);

        spieler1 = true;

        //Buttons
        wuerfeln.setzeKnopfLauscher(knopf -> {
            if (spieler1) {
                this.spieler1();
            } else if (spieler2) {
                this.spieler2();
            }
        });

        spielerWechseln.setzeKnopfLauscher(knopf -> this.setSpielerWechseln());

    }

    public void spieler1() {
        this.wuerfelMethode(eingabe.ganzZahl());
        punktzahlSpieler1 = this.getPunktzahl();
        this.gewuerfelteZahlenAusgeben(b6, b8, punktzahlSpieler1);
    }

    public void spieler2() {
        this.wuerfelMethode(eingabe.ganzZahl());
        punktzahlSpieler2 = this.getPunktzahl();

        this.gewuerfelteZahlenAusgeben(b7, b9, punktzahlSpieler2);
    }

    public Integer getPunktzahl() {
            int punktzahl = 0;
        for (int i : zahlen) {
            for (int e : zahlen) {
                    if (i == e) {
                            punktzahl = eingabe.ganzZahl();
                            System.out.println("GLeich");
                    }
            }

        }
        System.out.println("Punktzahl: " + punktzahl);
        return punktzahl;
    }

    public void gewuerfelteZahlenAusgeben(BeschriftungsFeld punktzahlB, BeschriftungsFeld zahlenB, Integer punktzahl) {

            for (int i = 0; i < eingabe.ganzZahl(); i++) {
                    ausgabewerte[i] = String.valueOf(zahlen[i]);
            }
        zahlenB.setzeText(ausgabewerte[1] + " " +  ausgabewerte[2] + " " + ausgabewerte[3]);
        punktzahlB.setzeText(Integer.toString(punktzahl));
    }

    public void wuerfelMethode(int anzahlWuerfeln) {


        if (anzahlWuerfeln <= 6 && anzahlWuerfeln > 0) {
            for (int i = 0; i < anzahlWuerfeln; i++) {
                zahlen[i] = Hilfe.zufall(1, 6);
            }
            b10.setzeText("");
        } else {
            b10.setzeText("Eingabe überprüfen");
        }
    }

    public void setNeuesSpiel() {

    }

    public void setSpielerWechseln() {
        if (spieler1) {
            spieler1 = false;
            spieler2 = true;
        } else {
            spieler2 = false;
            spieler1 = true;
        }
    }
}
