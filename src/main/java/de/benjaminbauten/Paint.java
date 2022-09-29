package de.benjaminbauten;

import basis.Fenster;
import basis.MausLauscherStandard;
import basis.Stift;

import java.awt.*;

public class Paint extends Fenster {

    public Stift stift;
    private MausLauscherStandard mausLauscherStandard;

    private final PaintGui paintGui;

    public Paint() {
        this.setzeGroesse(500, 500);
        this.setzeTitel("Benjamin-Paint");

        stift = new Stift();
        paintGui = new PaintGui(this);

    }

    public void addMouseListener(String s) {
        mausLauscherStandard = new MausLauscherStandard() {
            @Override
            public void bearbeiteMausDruck(Object o, int i, int i1) {
                if (s.equals("crawlMouseClick")) {
                    paintGui.crawlMouseClick(i,i1);
                    return;
                }
                if (s.equals("Zeichenmodus")){
                    stift.runter();
                }

            }

            @Override
            public void bearbeiteMausDruckRechts(Object o, int i, int i1) {

            }

            @Override
            public void bearbeiteMausLos(Object o, int i, int i1) {
                if (s.equals("Zeichenmodus")) {
                    stift.hoch();
                }
            }

            @Override
            public void bearbeiteMausLosRechts(Object o, int i, int i1) {

            }

            @Override
            public void bearbeiteMausBewegt(Object o, int i, int i1) {
                stift.bewegeBis(i, i1);
            }

            @Override
            public void bearbeiteMausGezogen(Object o, int i, int i1) {

            }
        };
        this.setzeMausLauscherStandard(mausLauscherStandard);
    }

    public void removeMouseListener() {
        this.entferneMausLauscherStandard(this.mausLauscherStandard);
    }


}
