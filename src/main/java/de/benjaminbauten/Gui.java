package de.benjaminbauten;

import javax.swing.*;


public class Gui {

    public Gui(EKlasse programm) {

        this.mainframe(programm);
    }

    public void mainframe(EKlasse programm) {

        JFrame frame = new JFrame();
        frame.setSize(800, 800);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton zeichneHausButton = new JButton("Zeichne Haus");
        zeichneHausButton.addActionListener(e -> {
            JTextField x = new JTextField(10);
            JTextField y = new JTextField(10);
            JTextField r = new JTextField(10);

            JPanel dialog = new JPanel();
            dialog.add(new JLabel("x"));
            dialog.add(x);
            dialog.add(new JLabel("y"));
            dialog.add(y);
            dialog.add(new JLabel("rotation"));
            dialog.add(r);

            int result = JOptionPane.showConfirmDialog(null, dialog, "Postion wählen", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION){
                programm.zeichneHaus(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Integer.parseInt(r.getText()));
            }
        });

        JButton zeichneBaumButton = new JButton("zeichne Baum");
        zeichneBaumButton.addActionListener(e -> {
            JTextField x = new JTextField(10);
            JTextField y = new JTextField(10);
            JTextField r = new JTextField(10);

            JPanel dialog = new JPanel();
            dialog.add(new JLabel("x"));
            dialog.add(x);
            dialog.add(new JLabel("y"));
            dialog.add(y);
            dialog.add(new JLabel("rotation"));
            dialog.add(r);

            int result = JOptionPane.showConfirmDialog(null, dialog, "Postion wählen", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                programm.zeichneWeihnachtsbaum(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Integer.parseInt(r.getText()));
            }
        });

            zeichneHausButton.setBounds(0,0,100,50);
        zeichneBaumButton.setBounds(500,500,100,50);
            frame.add(zeichneHausButton);
            frame.add(zeichneBaumButton);
        frame.setVisible(true);

//            frame.getContentPane().add(zeichneHausButton);
//            frame.getContentPane().add(zeichneBaumButton);
//            frame.getContentPane().add(zeichneBaumButton);
//        frame.setVisible(true);


    }

}
