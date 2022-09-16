package de.benjaminbauten;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PaintGui extends JFrame {

    private final Paint instance;

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

        //Knöpfe
        String[] verschiedeneBreiten = {"dünn", "normal", "dick"};
        JComboBox<String> selectWidth = new JComboBox<>(verschiedeneBreiten);
        selectWidth.addActionListener(e -> {
            if (Objects.requireNonNull(selectWidth.getSelectedItem()).toString().equals("dünn")) {
                instance.stift.setzeLinienBreite(3);
                return;
            }
            if (selectWidth.getSelectedItem().toString().equals("normal")) {
                instance.stift.setzeLinienBreite(5);
                return;
            }
            if (selectWidth.getSelectedItem().toString().equals("dick")) {
                instance.stift.setzeLinienBreite(8);
            }
        });
        this.getContentPane().add(selectWidth);

        //Toggle
        JToggleButton zeichenToggle = new JToggleButton("Zeichenmodus aktivieren");
        zeichenToggle.addActionListener(e -> {

            if (zeichenToggle.isSelected()) {
                instance.addMouseListener();
                zeichenToggle.setText("Zeichenmodus deaktivieren");
                return;
            }
            if (!zeichenToggle.isSelected()) {
                instance.removeMouseListener();
                zeichenToggle.setText("Zeichenmodus aktivieren");
            }

        });
        this.getContentPane().add(zeichenToggle);

        JToggleButton aktiviereRadirgummi = new JToggleButton("Radiergummi aktivieren");
        aktiviereRadirgummi.addActionListener(e -> {
            if (aktiviereRadirgummi.isSelected()) {
                instance.addMouseListener();
                instance.stift.radiere();
                instance.stift.setzeLinienBreite(40);
                aktiviereRadirgummi.setText("Radiergummi deaktivieren");
            }
            if (!aktiviereRadirgummi.isSelected()) {
                instance.removeMouseListener();
                aktiviereRadirgummi.setText("Radirgummi aktivieren");
                instance.stift.setzeStandard();
            }
        });
        this.getContentPane().add(aktiviereRadirgummi);


        //Layout und Sichtbarkeit
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

}

