package de.benjaminbauten;

public class Main {

    public static void main(String[] s) {

        EKlasse programm = new EKlasse(1000,1000);
        programm.zeichneStern(300,300,0);
        programm.zeichneE(100,100,0);
        programm.zeichneWeihnachtsbaum(400,600, 0);
        programm.zeichneHaus(300,300,0);

        Gui gui = new Gui(programm);
    }

}
