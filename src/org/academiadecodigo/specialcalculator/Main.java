package org.academiadecodigo.specialcalculator;

import org.academiadecodigo.specialcalculator.util.PostfixConversion;
import org.academiadecodigo.specialcalculator.util.Utils;

import java.io.IOException;

/**
 * Created by codecadet on 10/05/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PostfixConversion postfixConversion = new PostfixConversion();
        Controller controller = new Controller();

        // Test
        //String str = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"; // problem when converting this to postfix because of priorities
                                                        // in postfix conversion resolve it but don't no what is right
        //String str = "1 * ( 2 + 3 ) * 4";
        //String str = "( 1 + 2 ) * ( 3 - 4 )";
        //String str = "( 5 + 3 ) * 12 / 3";
        //String str = "1 ^ 2 / ( 5 * 3 ) + 10";

        System.out.print("Write the infix expression:\n> ");
        String input = Utils.readInput();

        String expression = Utils.processExpression(input.split(""));
        System.out.println("Expression to check: " + expression);

        expression = postfixConversion.toPostfix(expression);
        System.out.println("Postfix expression: " + expression);

        String[] finalExpression = expression.split(" ");
        System.out.print("Result: ");

        controller.calculate(finalExpression);
    }
}
