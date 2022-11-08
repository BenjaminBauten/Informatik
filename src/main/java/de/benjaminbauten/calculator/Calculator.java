package de.benjaminbauten.calculator;

import basis.*;


public class Calculator {

    private final Knopf resetButton;
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
        Fenster fenster = new Fenster("Taschenrechner", 300, 450);

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
                        case "/":
                            operatorEnum = OperatorEnum.DIVIDE;
                            break;
                        case "x":
                            operatorEnum = OperatorEnum.MULTIPLY;
                            break;
                        case "-":
                            operatorEnum = OperatorEnum.MINUS;
                            break;
                        case "+":
                            operatorEnum = OperatorEnum.PLUS;
                            break;
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
                    case PLUS:
                        result = String.valueOf(firstNumber + secondNumber);
                        break;
                    case MINUS:
                        result = String.valueOf(firstNumber - secondNumber);
                        break;
                    case MULTIPLY:
                        result = String.valueOf(firstNumber * secondNumber);
                        break;
                    case DIVIDE:
                        result = String.valueOf(firstNumber / secondNumber);
                        break;

                }
                refreshDisplay();
                pressedEquals = true;
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
}
