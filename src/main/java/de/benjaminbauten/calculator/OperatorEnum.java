package de.benjaminbauten.calculator;

public enum OperatorEnum {
    DIVIDE('/'),
    MULTIPLY('*'),
    MINUS('-'),
    PLUS('+'),
    Comma('.'),
    Equals('=');


    public final char character;

    OperatorEnum(char character) {
        this.character = character;
    }

}
