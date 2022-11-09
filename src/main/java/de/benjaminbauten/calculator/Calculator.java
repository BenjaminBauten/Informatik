package de.benjaminbauten.calculator;

import basis.*;

import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Calculator {

    private final Knopf resetButton;

    int rundenAuf = 2;

    private final Knopf polyRootsButton;
    Knopf[] numpad = new Knopf[10];
    Knopf[] operator = new Knopf[6];
    TextFeld display;
    BeschriftungsFeld titel;
    OperatorEnum operatorEnum;
    double firstNumber, secondNumber;
    String result = String.valueOf(0);
    boolean canInputSecondNumber = false;
    boolean pressedEquals = false;
    boolean nextIsComma = false;
    public Calculator() {
        new Fenster("Taschenrechner", 300, 500);

        //Tastenbereich
        int startx = 50;
        int starty = 180;
        int breite = 50;
        int hoehe = 50;

        //Numpad
        for (int i = 0; i < 10; i++) {
            numpad[i] = new Knopf(String.valueOf(i));
            numpad[i].setzeGroesse(breite, hoehe);
        }
        //Numpad Positionierung
        numpad[0].setzePosition(startx, starty + 3 * hoehe);
        numpad[1].setzePosition(startx, starty);
        numpad[2].setzePosition(startx + breite, starty);
        numpad[3].setzePosition(startx + 2 * breite, starty);
        numpad[4].setzePosition(startx, starty + hoehe);
        numpad[5].setzePosition(startx + breite, starty + hoehe);
        numpad[6].setzePosition(startx + 2 * breite, starty + hoehe);
        numpad[7].setzePosition(startx, starty + 2 * hoehe);
        numpad[8].setzePosition(startx + breite, starty + 2 * hoehe);
        numpad[9].setzePosition(startx + 2 * breite, starty + 2 * hoehe);

        //Operatorbereich

        for (int i = 0; i < 6; i++) {
            operator[i] = new Knopf();
            operator[i].setzeGroesse(breite, hoehe);
        }

        operator[0].setzePosition(startx + 3 * breite, starty);
        operator[0].setzeText(String.valueOf(OperatorEnum.DIVIDE.character));

        operator[1].setzePosition(startx + 3 * breite, starty + hoehe);
        operator[1].setzeText(String.valueOf(OperatorEnum.MULTIPLY.character));

        operator[2].setzePosition(startx + 3 * breite, starty + 2 * hoehe);
        operator[2].setzeText(String.valueOf(OperatorEnum.MINUS.character));

        operator[3].setzePosition(startx + 3 * breite, starty + 3 * hoehe);
        operator[3].setzeText(String.valueOf(OperatorEnum.PLUS.character));

        operator[4].setzePosition(startx + breite, starty + 3 * hoehe);
        operator[4].setzeText(String.valueOf(OperatorEnum.Comma.character));

        operator[5].setzePosition(startx + 2 * breite, starty + 3 * hoehe);
        operator[5].setzeText(String.valueOf(OperatorEnum.Equals.character));

        //Komponeneten
        display = new TextFeld(startx, starty - 50, breite * 4, 40);
        resetButton = new Knopf("Reset", startx, starty + hoehe * 4 + 20, breite * 4, 30);
        polyRootsButton = new Knopf("Quadratische-Gleichungen", startx, starty + hoehe * 5 + 20, breite * 4, 30);
        titel = new BeschriftungsFeld("Taschenrechner", startx, 20, breite * 4, hoehe);
        titel.setzeSchriftGroesse(20);

        //Start des Programmes
        this.fuehreAus();

    }

    public static void main(String[] args) {
        new Calculator();
    }

    public void fuehreAus() {

        //Reset-Button
        resetButton.setzeKnopfLauscher(knopf -> clearDisplay());

        //Numpad-Buttons
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numpad[i].setzeKnopfLauscher(knopf -> {
                if (canInputSecondNumber) {
                    clearDisplay();
                    canInputSecondNumber = false;
                }
                if (nextIsComma) {
                    result = String.valueOf(Double.parseDouble(result) + (finalI / 10.0));
                    refreshDisplay();
                    nextIsComma = false;
                    return;
                }
                addUpDisplay(finalI);
            });

        }

        //Operator-Buttons
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            operator[i].setzeKnopfLauscher(knopf -> {
                if (finalI < 4) {
                    switch (operator[finalI].text()) {
                        case "/" -> operatorEnum = OperatorEnum.DIVIDE;
                        case "x" -> operatorEnum = OperatorEnum.MULTIPLY;
                        case "-" -> operatorEnum = OperatorEnum.MINUS;
                        case "+" -> operatorEnum = OperatorEnum.PLUS;
                    }
                    operatorSetup();
                } else {
                    nextIsComma = true;
                }
            });
        }

        operator[5].setzeKnopfLauscher(knopf -> {

            if (display.text().length() > 0) {

                if (pressedEquals) {
                    firstNumber = Double.parseDouble(result);
                } else {
                    secondNumber = Double.parseDouble(display.text());
                }


                switch (operatorEnum) {
                    case PLUS -> result = String.valueOf(firstNumber + secondNumber);
                    case MINUS -> result = String.valueOf(firstNumber - secondNumber);
                    case MULTIPLY -> result = String.valueOf(firstNumber * secondNumber);
                    case DIVIDE -> result = String.valueOf(firstNumber / secondNumber);
                }
                refreshDisplay();
                pressedEquals = true;
            }

        });

        polyRootsButton.setzeKnopfLauscher(knopf -> {

            JPanel panel = new JPanel();
            JLabel aLabel = new JLabel("x^2: ");
            JTextField a = new JTextField(5);
            JLabel bLabel = new JLabel("x: ");
            JTextField b = new JTextField(5);
            JLabel cLabel = new JLabel("y: ");
            JTextField c = new JTextField(5);
            panel.add(aLabel);
            panel.add(a);
            panel.add(bLabel);
            panel.add(b);
            panel.add(cLabel);
            panel.add(c);

            int result = JOptionPane.showConfirmDialog(null, panel, "Gleichung eingeben", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {

                double aDouble = Double.parseDouble(a.getText());
                double bDouble = Double.parseDouble(b.getText());
                double cDouble = Double.parseDouble(c.getText());

                final double sqrt = Math.sqrt(Math.pow(bDouble, 2) - 4 * aDouble * cDouble);
                double x1 = (-bDouble + sqrt) / (2 * aDouble);
                double x2 = (-bDouble - sqrt) / (2 * aDouble);

                String xS1 = gerundeteAusgabe(x1);
                String xS2 = gerundeteAusgabe(x2);


                JOptionPane.showMessageDialog(null, "Die Lösungen sind: \nx1 = " + xS1 + "\nx2 = " + xS2);

            }

        });

    }


    public void addUpDisplay(int number) {

        if (result.equals("0")) {
            result = String.valueOf(number);

        } else {
            result = result + number;

        }
        refreshDisplay();
    }

    public void clearDisplay() {

        result = String.valueOf(0);
        refreshDisplay();
    }

    public void refreshDisplay() {
        display.setzeText(String.valueOf(result));

    }

    public void operatorSetup() {
        firstNumber = Double.parseDouble(result);
        canInputSecondNumber = true;
        pressedEquals = false;

    }

    public String gerundeteAusgabe(double wert) {
        StringBuilder sb = new StringBuilder(",##0.");
        for (int i=0; i< rundenAuf; i++)
            sb.append("0");
        DecimalFormat df = new DecimalFormat(sb.toString());
        df.setRoundingMode(RoundingMode.HALF_UP);

        return df.format(wert);
    }
}
