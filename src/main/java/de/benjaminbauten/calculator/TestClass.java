package de.benjaminbauten.calculator;

import basis.*;
//import jdk.incubator.vector.VectorOperators;

import javax.swing.*;

public class TestClass {

    public static void main(String[] args) {

        //TestClass testClass = new TestClass();
    }

    private Fenster fenster;
    private Knopf programmBeenden;
    private Bild bild1;
    private Knopf bildVerschieben;
    public TestClass() {

        fenster = new Fenster();
        programmBeenden = new Knopf("Programm Beenden", 100, 100, 200, 50);
        bildVerschieben = new Knopf("Bild verschieben",100,100,400, 50);
        bild1 = new Bild();
        bild1.setzeHintergrundFarbe(Farbe.GRAU);



    }

        public void verschieben()
        {
            //bild1.setzePosition(positionx, positiony);
        }
    }

