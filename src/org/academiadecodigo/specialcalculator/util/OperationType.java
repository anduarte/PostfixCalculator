package org.academiadecodigo.specialcalculator.util;

/**
 * Created by codecadet on 10/05/16.
 */
public enum  OperationType {
    ADD("+"), SUB("-"), MULTI("*"), DIV("/");

    private String symbol;

    OperationType(String symbol) {
        this.symbol = symbol;
    }

    public static OperationType symbolToOperation(String symbol) {
        switch (symbol) {
            case "+":
                return ADD;

            case "-":
                return SUB;

            case "*":
                return MULTI;

            case "/":
                return DIV;

            default:
                return null;
        }
    }
}
