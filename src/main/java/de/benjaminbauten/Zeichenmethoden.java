package de.benjaminbauten;

import basis.Stift;

public class Zeichenmethoden extends Stift{


    public Zeichenmethoden(){

    }

    public void zeichneWeihnachtsbaum(int x, int y, int rotation) {
        this.bewegeBis(x, y);
        this.dreheBis(rotation);
        this.runter();
        this.bewegeUm(40);
        this.dreheUm(90);
        this.bewegeUm(50);
        this.dreheUm(270);
        this.bewegeUm(100);
        this.dreheUm(135);
        this.bewegeUm(120);
        this.dreheUm(225);
        this.bewegeUm(50);
        this.dreheUm(135);
        this.bewegeUm(120);
        this.dreheUm(90);
        this.bewegeUm(120);
        this.dreheUm(135);
        this.bewegeUm(50);
        this.dreheUm(225);
        this.bewegeUm(120);
        this.dreheUm(135);
        this.bewegeUm(100);
        this.dreheUm(270);
        this.bewegeUm(50);
        this.hoch();
    }

    public void zeichneStern(int x, int y, int rotation) {
        this.bewegeBis(x, y);
        this.dreheBis(rotation);
        this.runter();
        this.bewegeUm(100);
        for (int i = 0; i < 4; i++) {
            this.dreheUm(216);
            this.bewegeUm(100);
        }
        this.hoch();
    }

    public void zeichneE(int x, int y, int rotation) {
        // tragen Sie hier den Code ein
        this.bewegeBis(x, y);
        this.dreheBis(rotation);
        this.runter();
        this.bewegeUm(150);
        this.dreheUm(270);
        this.bewegeUm(50);
        this.dreheUm(270);
        this.bewegeUm(100);
        this.dreheUm(90);
        this.bewegeUm(50);
        this.dreheUm(90);
        this.bewegeUm(100);
        this.dreheUm(270);
        this.bewegeUm(50);
        this.dreheUm(270);
        this.bewegeUm(100);
        this.dreheUm(90);
        this.bewegeUm(50);
        this.dreheUm(90);
        this.bewegeUm(100);
        this.dreheUm(270);
        this.bewegeUm(50);
        this.dreheUm(270);
        this.bewegeUm(150);
        this.dreheUm(270);
        this.bewegeUm(250);
        this.hoch();
    }

    public void zeichneHaus(int x, int y, int rotation){
        this.bewegeBis(x,y);
        this.dreheBis(rotation);
        this.runter();
        this.bewegeUm(150);
        this.dreheUm(90);
        this.bewegeUm(150);
        this.dreheUm(90);
        this.bewegeUm(150);
        this.dreheUm(225);
        this.bewegeUm(106);
        this.dreheUm(270);
        this.bewegeUm(106);
        this.dreheUm(270);
        this.bewegeUm(212);
        this.dreheUm(225);
        this.bewegeUm(150);
        this.dreheUm(225);
        this.bewegeUm(212);
        this.hoch();
    }
}
