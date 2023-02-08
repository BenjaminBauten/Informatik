package de.benjaminbauten;

import java.lang.reflect.Array;

public class CaesarVerschluesselung {

    private String eingabe = "Jonah ist ein Bot";
    private String ausgabe;
    private char[] buchstabe;
    private int verschiebeUm = 4;
    private char[] abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public CaesarVerschluesselung(){
        //buchstabe = new Character[eingabe.length()];
        this.verschluesseln();
        System.out.println(ausgabe);

    }

    public void verschluesseln(){
        char[] buchstabe = eingabe.toCharArray();

        for (int i = 0; i < buchstabe.length; i++) {
            int laenge = abc.length;
            for (int j = 0; j < laenge; j++) {
                if (buchstabe[i] == abc[j]) {
                    buchstabe[i] = abc[j + verschiebeUm];
                    //System.out.println(buchstabe[i]);
                    laenge = j;
                }
            }
        }
        //System.out.println(buchstabe);
        ausgabe = String.valueOf(buchstabe);
    }

    public void entschluesseln(){
        char[] buchstabe = eingabe.toCharArray();
        for (int i = 0; i < buchstabe.length; i++) {
            int laenge = abc.length;
            for (int j = 0; j < laenge; j++) {
                if (buchstabe[i] == abc[j]) {
                    buchstabe[i] = abc[j - verschiebeUm];
                    //System.out.println(buchstabe[i]);
                    laenge = j;
                }
            }
        }
        //System.out.println(buchstabe);
        ausgabe = String.valueOf(buchstabe);
    }
}
