package de.benjaminbauten;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import basis.*;

public class PaintGui extends JFrame {

    private final Paint instance;
    private final Zeichenmethoden zeichenmethoden;
    String[] farbenListe = {"Schwarz", "Rot", "Gelb", "Grün", "Blau"};

    public PaintGui(Paint instance) {
        this.createWindow();
        this.instance = instance;
        zeichenmethoden = new Zeichenmethoden();
    }

    public void createWindow() {

        //Titel GUI setzen
        this.setTitle("Paint Controller");

        //Größe setzten
        this.setSize(200, 200);

        //Operation beim Schließen
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        //Knöpfe
            JToggleButton baumZeichnen = new JToggleButton("Baum plazieren");
            baumZeichnen.addActionListener(e -> {
                if(baumZeichnen.isSelected()){
                    instance.removeMouseListener();
                    instance.addMouseListener("crawlMouseClick");
                    baumZeichnen.setText("Modus Beenden");
                }
                if (!baumZeichnen.isSelected()){
                    instance.removeMouseListener();
                    baumZeichnen.setText("Baum plazieren");
                    instance.addMouseListener("Zeichenmodus");
                }
            });
            this.getContentPane().add(baumZeichnen);

        JToggleButton hausZeichnen = new JToggleButton("Haus plazieren");
        baumZeichnen.addActionListener(e -> {
            if(hausZeichnen.isSelected()){
                instance.removeMouseListener();
                instance.addMouseListener("crawlMouseClick");
                hausZeichnen.setText("Modus Beenden");
            }
            if (!hausZeichnen.isSelected()){
                instance.removeMouseListener();
                hausZeichnen.setText("Baum plazieren");
                instance.addMouseListener("Zeichenmodus");
            }
        });
        this.getContentPane().add(hausZeichnen);

        JToggleButton sternZeichnen = new JToggleButton("Stern plazieren");
        baumZeichnen.addActionListener(e -> {
            if(sternZeichnen.isSelected()){
                instance.removeMouseListener();
                instance.addMouseListener("crawlMouseClick");
                sternZeichnen.setText("Modus Beenden");
            }
            if (!sternZeichnen.isSelected()){
                instance.removeMouseListener();
                sternZeichnen.setText("Baum plazieren");
                instance.addMouseListener("Zeichenmodus");
            }
        });
        this.getContentPane().add(sternZeichnen);

        //Auswahlfeld
        JComboBox farbeWaehlen = new JComboBox(farbenListe);
        farbeWaehlen.addActionListener(e->{
            if(Objects.requireNonNull(farbeWaehlen.getSelectedItem().toString().equals("Rot"))){
                instance.stift.setzeFarbe(Color.RED);
            }
            if(Objects.requireNonNull(farbeWaehlen.getSelectedItem().toString().equals("Gelb"))){
                instance.stift.setzeFarbe(Color.YELLOW);
            }
            if(Objects.requireNonNull(farbeWaehlen.getSelectedItem().toString().equals("Grün"))){
                instance.stift.setzeFarbe(Color.GREEN);
            }
            if(Objects.requireNonNull(farbeWaehlen.getSelectedItem().toString().equals("Blau"))){
                instance.stift.setzeFarbe(Color.BLUE);
            }
            if(Objects.requireNonNull(farbeWaehlen.getSelectedItem().toString().equals("Schwarz"))){
                instance.stift.setzeFarbe(Color.BLACK);
            }
        });
        this.getContentPane().add(farbeWaehlen);

        String[] verschiedeneBreiten = {"dünn", "normal", "dick"};
        JComboBox<String> selectWidth = new JComboBox<>(verschiedeneBreiten);
        selectWidth.addActionListener(e -> {
            if (Objects.requireNonNull(selectWidth.getSelectedItem()).toString().equals("dünn")) {
                instance.stift.setzeLinienBreite(2);
                return;
            }
            if (selectWidth.getSelectedItem().toString().equals("normal")) {
                instance.stift.setzeLinienBreite(4);
                return;
            }
            if (selectWidth.getSelectedItem().toString().equals("dick")) {
                instance.stift.setzeLinienBreite(7);
            }
        });
        this.getContentPane().add(selectWidth);

        //Toggle
        JToggleButton aktiviereRadirgummi = new JToggleButton("Radiergummi aktivieren");
        aktiviereRadirgummi.addActionListener(e -> {
            if (aktiviereRadirgummi.isSelected()) {
                //instance.addMouseListener();
                instance.stift.radiere();
                instance.stift.setzeLinienBreite(40);
                aktiviereRadirgummi.setText("Radiergummi deaktivieren");
                return;
            }
            if (!aktiviereRadirgummi.isSelected()) {
                //instance.removeMouseListener();
                aktiviereRadirgummi.setText("Radirgummi aktivieren");
                instance.stift.setzeStandard();
            }
        });
        this.getContentPane().add(aktiviereRadirgummi);

        JToggleButton zeichenToggle = new JToggleButton("Zeichenmodus aktivieren");
        zeichenToggle.addActionListener(e -> {

            if (zeichenToggle.isSelected()) {
                instance.addMouseListener("Zeichenmodus");
                zeichenToggle.setText("Zeichenmodus deaktivieren");
                aktiviereRadirgummi.setVisible(true);
                return;
            }
            if (!zeichenToggle.isSelected()) {
                instance.removeMouseListener();
                zeichenToggle.setText("Zeichenmodus aktivieren");
                aktiviereRadirgummi.setVisible(false);
            }

        });
        this.getContentPane().add(zeichenToggle);

        //Layout und Sichtbarkeit
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        aktiviereRadirgummi.setVisible(false);


    }

    public void crawlMouseClick(int x, int y) {
        zeichenmethoden.zeichneWeihnachtsbaum(x,y,0);
    }

}

