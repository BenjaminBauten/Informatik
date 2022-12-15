package de.benjaminbauten;

import basis.*;

import java.util.Arrays;

public class SortingArrrays {

    private Fenster fenster = new Fenster("Sorting Arrays", 500, 500);
    private Stift stift = new Stift();
    public int[] zahlen = new int[100];

    public SortingArrrays(){
        for (int i = 0; i < 100; i++) {
            zahlen[i] = Hilfe.zufall(1, 100);
        }
        stift.dreheUm(90);
        bubbleSort();
    }
    private void bubbleSort(){
        System.out.println(Arrays.toString(zahlen));
        for (int n = zahlen.length; n>1; --n){
            for (int i=0; i<n-1; ++i){
                if (zahlen[i] > zahlen[i+1]){
                    swap(zahlen, i, i+1);
                }
                zeichnen();
                Hilfe.pause(2);
            } // Ende innere for-Schleife
        }
        System.out.println(Arrays.toString(zahlen));

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
