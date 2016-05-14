package org.academiadecodigo.specialcalculator;

/**
 * Created by codecadet on 10/05/16.
 */
public class Main {
    public static void main(String[] args) {

        String[] expression = "1 2 5 * +".split(" ");

        Controller controller = new Controller();
        controller.calculate(expression);

    }
}
