package de.benjaminbauten;

import basis.*;

public class EKlasse {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Fenster fenster1;
    private IgelStift stift1;

    /**
     * Konstruktor für Objekte der Klasse EKlasse
     */
    public EKlasse(int breite, int hoehe) {
        // Instanzvariable initialisieren
        fenster1 = new Fenster(breite, hoehe);
        stift1 = new IgelStift();
    }

    public void zeichneWeihnachtsbaum(int x, int y, int rotation) {
        stift1.bewegeBis(x, y);
        stift1.dreheBis(rotation);
        stift1.runter();
        stift1.bewegeUm(40);
        stift1.dreheUm(90);
        stift1.bewegeUm(50);
        stift1.dreheUm(270);
        stift1.bewegeUm(100);
        stift1.dreheUm(135);
        stift1.bewegeUm(120);
        stift1.dreheUm(225);
        stift1.bewegeUm(50);
        stift1.dreheUm(135);
        stift1.bewegeUm(120);
        stift1.dreheUm(90);
        stift1.bewegeUm(120);
        stift1.dreheUm(135);
        stift1.bewegeUm(50);
        stift1.dreheUm(225);
        stift1.bewegeUm(120);
        stift1.dreheUm(135);
        stift1.bewegeUm(100);
        stift1.dreheUm(270);
        stift1.bewegeUm(50);
        stift1.hoch();
    }

    public void zeichneStern(int x, int y, int rotation) {
        stift1.bewegeBis(x, y);
        stift1.dreheBis(rotation);
        stift1.runter();
        stift1.bewegeUm(100);
        for (int i = 0; i < 4; i++) {
            stift1.dreheUm(216);
            stift1.bewegeUm(100);
        }
        stift1.hoch();
    }

    public void zeichneE(int x, int y, int rotation) {
        // tragen Sie hier den Code ein
        stift1.bewegeBis(x, y);
        stift1.dreheBis(rotation);
        stift1.runter();
        stift1.bewegeUm(150);
        stift1.dreheUm(270);
        stift1.bewegeUm(50);
        stift1.dreheUm(270);
        stift1.bewegeUm(100);
        stift1.dreheUm(90);
        stift1.bewegeUm(50);
        stift1.dreheUm(90);
        stift1.bewegeUm(100);
        stift1.dreheUm(270);
        stift1.bewegeUm(50);
        stift1.dreheUm(270);
        stift1.bewegeUm(100);
        stift1.dreheUm(90);
        stift1.bewegeUm(50);
        stift1.dreheUm(90);
        stift1.bewegeUm(100);
        stift1.dreheUm(270);
        stift1.bewegeUm(50);
        stift1.dreheUm(270);
        stift1.bewegeUm(150);
        stift1.dreheUm(270);
        stift1.bewegeUm(250);
        stift1.hoch();
    }

    public void zeichneHaus(int x, int y, int rotation){
        stift1.bewegeBis(x,y);
        stift1.dreheBis(rotation);
        stift1.runter();
        stift1.bewegeUm(150);
        stift1.dreheUm(90);
        stift1.bewegeUm(150);
        stift1.dreheUm(90);
        stift1.bewegeUm(150);
        stift1.dreheUm(225);
        stift1.bewegeUm(106);
        stift1.dreheUm(270);
        stift1.bewegeUm(106);
        stift1.dreheUm(270);
        stift1.bewegeUm(212);
        stift1.dreheUm(225);
        stift1.bewegeUm(150);
        stift1.dreheUm(225);
        stift1.bewegeUm(212);
    }
}
