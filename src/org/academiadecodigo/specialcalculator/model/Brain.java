package org.academiadecodigo.specialcalculator.model;

import org.academiadecodigo.specialcalculator.util.OperationType;

/**
 * Created by codecadet on 10/05/16.
 */
public class Brain {

    /* ALLOWED OPERATIONS */
    private double sum(float number1, float number2) {
        return number1 + number2;
    }

    private double subtraction(float number1, float number2) {
        return number1 - number2;
    }

    private double division(float number1, float number2) {
        return number1 / number2;
    }

    private double multiplication(float number1, float number2) {
        return number1 * number2;
    }

    private double power(float number1, float number2) {
        return Math.pow(number1, number2);
    }

    /**
     * Responsible for doing the operations
     * @param number
     * @param number2
     * @param op
     * @return the result of the operation
     */
    public double runOperation(float number, float number2, OperationType op) {
        switch (op) {
            case ADD: return  this.sum(number, number2);
            case MULTI: return this.multiplication(number, number2);
            case SUB: return this.subtraction(number, number2);
            case DIV: return this.division(number, number2);
            case POW: return this.power(number, number2);
            default: return 0.0D;
        }
    }
}
