package de.benjaminbauten;

import basis.*;

import java.util.Arrays;
import java.util.Random;

public class SortingArrrays {

    private Fenster fenster = new Fenster("Sorting Arrays", 800, 500);
    private Stift stift = new Stift();

    private int länge = 300;
    public int[] zahlen = new int[länge];

    public SortingArrrays(){
        for (int i = 0; i < länge; i++) {
            zahlen[i] = Hilfe.zufall(1,300);
        }
        stift.dreheUm(90);
        stift.setzeLinienBreite(2);
        bubbleSort();
    }
    private void bubbleSort(){
        //System.out.println(Arrays.toString(zahlen));
        double startTime = System.currentTimeMillis();
        int obergrenze = zahlen.length-1;
        while(obergrenze>1){
            //boolean nocheinerunde = false;
            int neueObergrenze = 1;
            for (int i=0; i<obergrenze; ++i){
                if (zahlen[i] > zahlen[i+1]){
                    swap(zahlen, i, i+1);
                    //nocheinerunde = true;
                    neueObergrenze = i;
                }
            }
            obergrenze = neueObergrenze;
            //zeichnen();
            Hilfe.pause(40);
        }
        System.out.println(System.currentTimeMillis() - startTime);
        //System.out.println(Arrays.toString(zahlen));

    }

    private void selectionSort(){
        for (int i = 0; i <länge; i++) {

        }
    }

    private void swap(int[] zahlen, int i, int i1) {

        int zahlen1 = zahlen[i];
        zahlen[i] = zahlen[i1];
        zahlen[i1] = zahlen1;
    }

    public void zeichnen(){
        fenster.loescheAlles();
        for (int i = 0; i < zahlen.length; i++) {
            stift.bewegeBis(10+i*2, 400);
        stift.runter();
        stift.bewegeUm(zahlen[i]);
        stift.hoch();
        }
    }
}
