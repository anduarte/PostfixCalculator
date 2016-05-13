package org.academiadecodigo.specialcalculator;

import org.academiadecodigo.specialcalculator.model.Stack;
import org.academiadecodigo.specialcalculator.util.Brain;
import org.academiadecodigo.specialcalculator.util.Display;
import org.academiadecodigo.specialcalculator.util.OperationType;

/**
 * Created by codecadet on 10/05/16.
 */
public class Controller {
    Stack valueStack;
    Stack operationsStack;

    public void fillStacks(String[] expression) {
        this.valueStack = new Stack(expression.length);
        this.operationsStack = new Stack(expression.length);

        int index = 0;

        while (index < expression.length) {
            String str = expression[index];

            if(str.matches("^[0-9]*$")) {
                valueStack.push(str);
            } else {
                operationsStack.push(str);
            }

            index++;
        }
    }

    public void showResult() {
        Brain brain = new Brain();
        Display display = new Display();

        float result = 0.0F;

        while(!this.operationsStack.isEmpty()) {

            float value1 = Float.parseFloat(this.valueStack.pop());
            float value2 = Float.parseFloat(this.valueStack.pop());
            OperationType op = OperationType.symbolToOperation(this.operationsStack.pop());

            result = brain.runOperation(value1, value2, op);

            this.valueStack.push(result + "");
        }

        display.showResult(Float.parseFloat(this.valueStack.pop()));
    }

}
