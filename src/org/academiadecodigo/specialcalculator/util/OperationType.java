package org.academiadecodigo.specialcalculator.util;

/**
 * Created by codecadet on 10/05/16.
 */
public enum  OperationType {
    ADD("+"), SUB("-"), MULTI("*"), DIV("/");

    private String symbol; // Store the operation symbol

    OperationType(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Checks what is the symbol and returns the operation type
     * @param symbol
     * @return
     */
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
