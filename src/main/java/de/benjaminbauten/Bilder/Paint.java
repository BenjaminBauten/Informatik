package de.benjaminbauten.Bilder;

import basis.Fenster;
import basis.MausLauscherStandard;
import basis.Stift;

public class Paint extends Fenster {

    Stift stift;

    public Paint() {
        this.setzeGroesse(500, 500);
        this.setzeTitel("Benjamin-Paint");

        stift = new Stift();
    }

    public Paint addMouseListener() {
        this.setzeMausLauscherStandard(this.getMouseListener());
        return this;
    }

    public MausLauscherStandard getMouseListener() {
        return new MausLauscherStandard() {
            @Override
            public void bearbeiteMausDruck(Object o, int i, int i1) {
                stift.runter();
            }

            @Override
            public void bearbeiteMausDruckRechts(Object o, int i, int i1) {

            }

            @Override
            public void bearbeiteMausLos(Object o, int i, int i1) {
                stift.hoch();
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
    }


}
