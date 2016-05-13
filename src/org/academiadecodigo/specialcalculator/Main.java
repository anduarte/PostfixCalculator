package org.academiadecodigo.specialcalculator;

import org.academiadecodigo.specialcalculator.model.Stack;

/**
 * Created by codecadet on 10/05/16.
 */
public class Main {
    public static void main(String[] args) {

        String[] expression = "1 2 5 9 1 * + + *".split(" ");

        Controller controller = new Controller();

        controller.fillStacks(expression);
        controller.showResult();

    }
}
