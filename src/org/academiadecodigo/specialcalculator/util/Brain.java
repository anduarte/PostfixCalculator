package org.academiadecodigo.specialcalculator.util;

/**
 * Created by codecadet on 10/05/16.
 */
public class Brain {

    /* ALLOWED OPERATIONS */
    private float sum(float number1, float number2) {
        return number1 + number2;
    }

    private float subtraction(float number1, float number2) {
        return number1 - number2;
    }

    private float division(float number1, float number2) {
        return number1 / number2;
    }

    private float multiplication(float number1, float number2) {
        return number1 * number2;
    }

    /**
     * Responsible for doing the operations
     * @param number
     * @param number2
     * @param op
     * @return the result of the operation
     */
    public float runOperation(float number, float number2, OperationType op) {
        switch (op) {
            case ADD: return  this.sum(number, number2);
            case MULTI: return this.multiplication(number, number2);
            case SUB: return this.subtraction(number, number2);
            case DIV: return this.division(number, number2);
            default: return 0.0F;
        }
    }
}
