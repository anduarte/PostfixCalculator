package org.academiadecodigo.specialcalculator;

import org.academiadecodigo.specialcalculator.model.Stack;
import org.academiadecodigo.specialcalculator.model.Brain;
import org.academiadecodigo.specialcalculator.model.Display;
import org.academiadecodigo.specialcalculator.util.OperationType;

/**
 * Created by codecadet on 10/05/16.
 */
public class Controller {
    Stack valueStack;

    public void calculate(String[] expression) {
        this.valueStack = new Stack(expression.length); // create a stack for the values
        Brain brain = new Brain();                      // create the brain
        Display display = new Display();                // create the display
        double result;                                   // store the result
        int index = 0;                                  // position on the expression

        while (index < expression.length) {
            String str = expression[index];

            if(str.matches("^[0-9]*$")) {   // if is a number push to stack
                valueStack.push(str);
            } else {                        // otherwise calculate

                float value2 = Float.parseFloat(this.valueStack.pop());
                float value1 = Float.parseFloat(this.valueStack.pop());
                OperationType op = OperationType.symbolToOperation(str);

                result = brain.runOperation(value1, value2, op);

                this.valueStack.push(result + "");
            }

            index++;
        }

        display.showResult(Float.parseFloat(this.valueStack.pop()));
    }
}
