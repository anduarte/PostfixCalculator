package org.academiadecodigo.specialcalculator;

import org.academiadecodigo.specialcalculator.util.PostfixConversion;

/**
 * Created by codecadet on 10/05/16.
 */
public class Main {
    public static void main(String[] args) {
        PostfixConversion postfixConversion = new PostfixConversion();
        Controller controller = new Controller();

        String str = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";

        System.out.println("Expression to check: " + str);

        str = postfixConversion.toPostfix(str);

        System.out.println("Postfix expression: " + str);

        String[] expression = str.split(" ");

        System.out.print("Result: ");

        controller.calculate(expression);
    }
}
