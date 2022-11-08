package de.benjaminbauten;

import basis.*;

import java.util.Arrays;

public class Taschenrechner {

    private Fenster fenster;
    private Tastatur tastatur;

    private Knopf k0, k1, k2, k3, k4, k5, k6, k7, k8, k9, kGeteilt, kMal, kMinus, kPlus, kGleich, kKomma, ende;
    private int breite, hoehe, startx, starty;

    Character[] zahlZeichen = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.'};
    Character[] operatorZeichen = {'+', '-', '*', '/'};
    TextFeld ausgabeUndEingabe;
    BeschriftungsFeld titel;

    public String ausgabetext;
    private double letzteZahl;
    private char letztesZeichen = '+';


    public Taschenrechner() {
        //Tastenbereich
        startx = 50;
        starty = 180;
        breite = 50;
        hoehe = 50;
        fenster = new Fenster("Taschenrechner", 300, 450);
        k0 = new Knopf("0", startx, starty + hoehe * 3, breite, hoehe);
        k1 = new Knopf("1", startx, starty, breite, hoehe);
        k2 = new Knopf("2", startx + breite, starty, breite, hoehe);
        k3 = new Knopf("3", startx + breite * 2, starty, breite, hoehe);
        k4 = new Knopf("4", startx, starty + hoehe, breite, hoehe);
        k5 = new Knopf("5", startx + breite, starty + hoehe, breite, hoehe);
        k6 = new Knopf("6", startx + breite * 2, starty + hoehe, breite, hoehe);
        k7 = new Knopf("7", startx, starty + hoehe * 2, breite, hoehe);
        k8 = new Knopf("8", startx + breite, starty + hoehe * 2, breite, hoehe);
        k9 = new Knopf("9", startx + breite * 2, starty + hoehe * 2, breite, hoehe);
        kGeteilt = new Knopf("/", startx + breite * 3, starty, breite, hoehe);
        kMal = new Knopf("x", startx + breite * 3, starty + hoehe, breite, hoehe);
        kMinus = new Knopf("-", startx + breite * 3, starty + hoehe * 2, breite, hoehe);
        kPlus = new Knopf("+", startx + breite * 3, starty + hoehe * 3, breite, hoehe);
        kGleich = new Knopf("=", startx + breite * 2, starty + hoehe * 3, breite, hoehe);
        kKomma = new Knopf(".", startx + breite, starty + hoehe * 3, breite, hoehe);

        //Rest
        ausgabeUndEingabe = new TextFeld(startx, starty - 50, breite * 4, 40);
        ende = new Knopf("Ende", startx, starty + hoehe * 4 + 20, breite * 4, 30);
        titel = new BeschriftungsFeld("Taschenrechner", startx, 20, breite * 4, hoehe);
        titel.setzeSchriftGroesse(20);
        tastatur = new Tastatur();
        ausgabetext = "";

        //Start des Programmes
        this.fuehreAus();
    }

    public void fuehreAus() {

        kGleich.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                operatoren();
                ausgabetext = Double.toString(letzteZahl);
                //System.out.println(letzteZahl);
                ausgabeUndEingabe.setzeText(ausgabetext);
            }
        });

        k0.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k0.text();
                System.out.println(ausgabetext);
            }
        });

        k1.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k1.text();
                System.out.println(ausgabetext);
            }
        });

        k2.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k2.text();
                System.out.println(ausgabetext);
            }
        });

        k3.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k3.text();
                System.out.println(ausgabetext);
            }
        });

        k4.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k4.text();
                System.out.println(ausgabetext);
            }
        });

        k5.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k5.text();
                System.out.println(ausgabetext);
            }
        });

        k6.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k6.text();
                System.out.println(ausgabetext);
            }
        });

        k7.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k7.text();
                System.out.println(ausgabetext);
            }
        });

        k8.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k8.text();
                System.out.println(ausgabetext);
            }
        });

        k9.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k9.text();
                System.out.println(ausgabetext);
            }
        });
        kKomma.setzeKnopfLauscher(new KnopfLauscher() {
            @Override
            public void bearbeiteKnopfDruck(Knopf knopf) {
                ausgabetext = ausgabetext + k9.text();
                System.out.println(ausgabetext);
            }
        });


        while (!ende.wurdeGedrueckt()) {
            Hilfe.kurzePause();



            this.buttonGedrueckt(kKomma);
            this.operatorGedrueckt(kGeteilt);
            this.operatorGedrueckt(kMal);
            this.operatorGedrueckt(kMinus);
            this.operatorGedrueckt(kPlus);

            //Tastureingabe
            if (tastatur.wurdeGedrueckt()) {
                tastatur.holeZeichen();

                if (Arrays.asList(zahlZeichen).contains(tastatur.aktuellesZeichen())) {
                    ausgabetext = ausgabetext + tastatur.aktuellesZeichen();
                    //ausgabe.setzeText(ausgabetext);
                }

                if (Arrays.asList(operatorZeichen).contains(tastatur.aktuellesZeichen())) {
                    this.operatoren();
                }

                //System.out.println(ausgabetext);

            }
            ausgabeUndEingabe.setzeText(ausgabetext);
        }
        fenster.gibFrei();
    }

    public void operatoren() {
        switch (letztesZeichen) {
            case '+':
                letzteZahl = letzteZahl + Double.parseDouble(ausgabetext);
                break;
            case '-':
                letzteZahl = letzteZahl - Double.parseDouble(ausgabetext);
                break;
            case '*':
                letzteZahl = letzteZahl * Double.parseDouble(ausgabetext);
                break;
            case '/':
                letzteZahl = letzteZahl / Double.parseDouble(ausgabetext);
                break;
        }
        ausgabetext = "";
        ausgabeUndEingabe.setzeText(ausgabetext);
        letztesZeichen = tastatur.aktuellesZeichen();
    }


    public void buttonGedrueckt(Knopf knopf) {
        if (knopf.wurdeGedrueckt()) {
            ausgabetext = ausgabetext + knopf.text();
            System.out.println(ausgabetext);
        }
    }

    public void operatorGedrueckt(Knopf knopf) {
        if (knopf.wurdeGedrueckt()) {
            switch (Character.toChars(knopf.text())) {
                case '+':
                    System.out.println(ausgabetext);
                    letzteZahl = letzteZahl + Double.parseDouble(ausgabetext);
                    letztesZeichen = '+';
                    break;
                case '-':
                    letzteZahl = letzteZahl - Double.parseDouble(ausgabetext);
                    letztesZeichen = '-';
                    break;
                case '*':
                    letzteZahl = letzteZahl * Double.parseDouble(ausgabetext);
                    letztesZeichen = '*';
                    break;
                case '/':
                    letzteZahl = letzteZahl / Double.parseDouble(ausgabetext);
                    letztesZeichen = '/';
                    break;
            }
            ausgabetext = "";
            ausgabeUndEingabe.setzeText(ausgabetext);
        }
    }

}
