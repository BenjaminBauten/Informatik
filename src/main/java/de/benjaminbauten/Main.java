package de.benjaminbauten;

public class Main {

    public static void main(String[] s) {

        EKlasse programm = new EKlasse(1000,1000);
        programm.zeichneStern(300,100,0);
        programm.zeichneStern(500,150,0);
//        programm.zeichneE(100,100,0);
        programm.zeichneWeihnachtsbaum(200,600, 0);
        programm.zeichneHaus(500,600,0);

        Gui gui = new Gui(programm);
    }

}
