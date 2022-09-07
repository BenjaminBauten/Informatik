package de.benjaminbauten;

import basis.*;

import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class DaumenkinoKlasse {

    private Fenster fensterDaumenkino;
    private Stift stift1;

    private Bild bild1, bild2, bild3, bild4;

    public DaumenkinoKlasse(int width, int height, int bildWidth, int bildHeight, int border){
        fensterDaumenkino = new Fenster(width, height);
        fensterDaumenkino.setzeHintergrundFarbe(Color.GRAY);
        stift1 = new Stift();
        stift1.setzeLinienBreite(2);

        bild1 = new Bild(border, border, bildWidth, bildHeight);
        bild2 = new Bild(border, border, bildWidth, bildHeight);
        bild3 = new Bild(border, border, bildWidth, bildHeight);
        bild4 = new Bild(border, border, bildWidth, bildHeight);
        bild1.setzeHintergrundFarbe(Color.WHITE);
        bild2.setzeHintergrundFarbe(Color.WHITE);
        bild3.setzeHintergrundFarbe(Color.WHITE);
        bild4.setzeHintergrundFarbe(Color.WHITE);

    }

    public void fuehreAusKino(){
        System.out.println("Mehode fuehreAusKino ausgeführt.");
        bild1.setzeSichtbar(true);
        bild2.setzeSichtbar(false);
        bild3.setzeSichtbar(false);
        bild4.setzeSichtbar(false);

        stift1.setzeLinienBreite(10);
        stift1.maleAuf(bild1);
        zeichneP1();
        stift1.maleAuf(bild2);
        zeichneP2();
        stift1.maleAuf(bild3);
        zeichneP3();
        stift1.maleAuf(bild4);
        zeichneP4();

        while (true){
            bild1.setzeSichtbar(true);
            Hilfe.pause(250);
            bild1.setzeSichtbar(false);
            bild2.setzeSichtbar(true);
            Hilfe.pause(250);
            bild2.setzeSichtbar(false);
            bild3.setzeSichtbar(true);
            Hilfe.pause(250);
            bild3.setzeSichtbar(false);
//            bild4.setzeSichtbar(true);
//            Hilfe.pause(500);
//            bild4.setzeSichtbar(false);

        }
    }

    public void zeichneP1(){
        stift1.hoch();
        stift1.bewegeBis(100,50);
        stift1.runter();
        stift1.zeichneKreis(20);
        stift1.dreheBis(270);
        stift1.hoch();
        stift1.bewegeUm(20);
        stift1.runter();
        stift1.bewegeUm(40);
        stift1.dreheUm(30);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(-60);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(30);
        stift1.bewegeUm(-30);
        stift1.dreheUm(40);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(-80);
        stift1.bewegeUm(50);
    }

    public void zeichneP2(){
        stift1.hoch();
        stift1.bewegeBis(100,50);
        stift1.runter();
        stift1.zeichneKreis(20);
        stift1.dreheBis(270);
        stift1.hoch();
        stift1.bewegeUm(20);
        stift1.runter();
        stift1.bewegeUm(40);
        stift1.dreheUm(30);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(-60);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(30);
        stift1.bewegeUm(-30);
        stift1.dreheUm(90);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(-180);
        stift1.bewegeUm(50);
    }

    public void zeichneP3(){
        stift1.hoch();
        stift1.bewegeBis(100,50);
        stift1.runter();
        stift1.zeichneKreis(20);
        stift1.dreheBis(270);
        stift1.hoch();
        stift1.bewegeUm(20);
        stift1.runter();
        stift1.bewegeUm(40);
        stift1.dreheUm(30);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(-60);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(30);
        stift1.bewegeUm(-30);
        stift1.dreheUm(120);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(-200);
        stift1.bewegeUm(50);
    }

    public void zeichneP4(){
        stift1.hoch();
        stift1.bewegeBis(100,50);
        stift1.runter();
        stift1.zeichneKreis(20);
        stift1.dreheBis(270);
        stift1.hoch();
        stift1.bewegeUm(20);
        stift1.runter();
        stift1.bewegeUm(40);
        stift1.dreheUm(30);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(-60);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(30);
        stift1.bewegeUm(-30);
        stift1.dreheUm(40);
        stift1.bewegeUm(50);
        stift1.bewegeUm(-50);
        stift1.dreheUm(-80);
        stift1.bewegeUm(50);
    }

}
