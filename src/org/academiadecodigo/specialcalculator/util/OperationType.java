package org.academiadecodigo.specialcalculator.util;

/**
 * Created by codecadet on 10/05/16.
 */
public enum  OperationType {
    ADD("+", 0), SUB("-", 0), MULTI("*", 1), DIV("/", 1), POW("^", 2);

    private String symbol;  // Operation symbol
    private int priority;   // Give a priority to the operation. Used on the postfix conversion

    OperationType(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
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

            case "^":
                return POW;

            default:
                return null;
        }
    }
}
