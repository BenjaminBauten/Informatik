package de.benjaminbauten;
import basis.*;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;


public class ArrayTest {

    public Fenster fenster;
    public String[] tiere;
    public BeschriftungsFeld b1, b2;
    public Knopf ok;

    public ZahlenFeld eingabeAnzahl;



    public ArrayTest(){
        fenster = new Fenster("Arrays", 500, 500);
        b1 = new BeschriftungsFeld("", 100, 100, 300, 20);
        b2 = new BeschriftungsFeld("Wie viel Tiere möchten Sie eingeben?", 100, 250, 300, 20);

        eingabeAnzahl = new ZahlenFeld(100, 300, 100, 20);
        //eingabeTiere.setzeTextFeldLauscher();

        ok = new Knopf("OK", 100, 150, 70, 30);
        ok.setzeKnopfLauscher(knopf -> eingabeTiere());

    }

    public void ausfuehren(){
        tiere = new String[3];
        tiere[0] = "Ameise";
        tiere[1] = "Hund";
        tiere[2] = "Gecko";
        System.out.println(tiere[0] + ", " + tiere[1] + ", " + tiere[2]);
        b1.setzeText(tiere[0] + ", " + tiere[1] + ", " + tiere[2]);
    }

    public void eingabeTiere(){

        tiere = new String[eingabeAnzahl.ganzZahl()];
        for (int i = 0; i < eingabeAnzahl.ganzZahl(); i++) {
            tiere[i] = JOptionPane.showInputDialog("Wähle Tier Nr." + (i + 1));
            b1.setzeText(Arrays.toString(tiere));
        }

        //b1.setzeText(tiere[0] + ", " + tiere[1] + ", " + tiere[2]);
    }

}
