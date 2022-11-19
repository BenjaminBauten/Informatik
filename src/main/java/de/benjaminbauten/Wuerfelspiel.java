package de.benjaminbauten;

import basis.*;

public class Wuerfelspiel {

        private Fenster fenster;
        private ZahlenFeld eingabe;
        private BeschriftungsFeld b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
        private Knopf spielerWechseln, neuesSpiel, wuerfeln;

        private int gewuerfelteZahl1, gewuerfelteZahl2, gewuerfelteZahl3, gewuerfelteZahl4, gewuerfelteZahl5, gewuerfelteZahl6;

        private int punktzahlSpieler1, punktzahlSpieler2;

        public Wuerfelspiel(){
                fenster = new Fenster("Würfelspiel", 500, 500);
                b1 = new BeschriftungsFeld("Wie oft möchten Sie würflen?", 20, 20, 300, 20);
                eingabe = new ZahlenFeld(20, 50, 50, 20);
                wuerfeln = new Knopf("Würfeln",20, 80, 80, 40);

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

                //Buttons
                wuerfeln.setzeKnopfLauscher(knopf -> this.spieler1());

        }

        public void spieler1(){
                this.wuerfelMethode(eingabe.ganzZahl());
                this.getPunktzahl();
                this.gewuerfelteZahlenAusgeben();

        }

        public void getPunktzahl(){
                if (gewuerfelteZahl1 == gewuerfelteZahl2){
                        punktzahlSpieler1 = 0;
                } else if(gewuerfelteZahl1 == gewuerfelteZahl3){
                        punktzahlSpieler1 = 0;
                } else if (gewuerfelteZahl2 == gewuerfelteZahl3) {
                        punktzahlSpieler1 = 0;
                } else {
                        punktzahlSpieler1 = eingabe.ganzZahl();
                }
        }

        public void gewuerfelteZahlenAusgeben(){
                b8.setzeText(gewuerfelteZahl1 + "; " + Integer.toString(gewuerfelteZahl2) + "; " + Integer.toString(gewuerfelteZahl3));
                b6.setzeText(Integer.toString(punktzahlSpieler1));
        }
        public void wuerfelMethode(int anzahlWuerfeln){
                if (anzahlWuerfeln <= 6 && anzahlWuerfeln>0) {
                        switch (anzahlWuerfeln) {
                                case 1:
                                        gewuerfelteZahl1 = Hilfe.zufall(1, 6);
                                        break;
                                case 2:
                                        gewuerfelteZahl1 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl2 = Hilfe.zufall(1, 6);
                                        break;
                                case 3:
                                        gewuerfelteZahl1 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl2 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl3 = Hilfe.zufall(1, 6);
                                        break;
                                case 4:
                                        gewuerfelteZahl1 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl2 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl3 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl4 = Hilfe.zufall(1, 6);
                                        break;
                                case 5:
                                        gewuerfelteZahl1 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl2 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl3 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl4 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl5 = Hilfe.zufall(1, 6);
                                        break;
                                case 6:
                                        gewuerfelteZahl1 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl2 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl3 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl4 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl5 = Hilfe.zufall(1, 6);
                                        gewuerfelteZahl6 = Hilfe.zufall(1, 6);
                                        break;
                        }
                        b10.setzeText("");
                } else {
                        b10.setzeText("Eingabe überprüfen");
                }
        }
}
