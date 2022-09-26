package de.benjaminbauten;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PaintGui extends JFrame {

    private final Paint instance;
    String[] farbenListe = {"Schwarz", "Rot", "Gelb", "Grün", "Blau"};

    public PaintGui(Paint instance) {
        this.createWindow();
        this.instance = instance;
    }

    public void createWindow() {

        //Titel GUI setzen
        this.setTitle("Paint Controller");

        //Größe setzten
        this.setSize(200, 200);

        //Operation beim Schließen
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


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

        //Knöpfe
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
                instance.addMouseListener();
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

}

