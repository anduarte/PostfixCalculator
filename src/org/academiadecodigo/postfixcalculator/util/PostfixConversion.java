package org.academiadecodigo.postfixcalculator.util;

import org.academiadecodigo.postfixcalculator.model.Stack;

/**
 * Created by andre on 14/05/2016.
 * <p>
 * Class that handles with the conversion from infix to postfix
 */
public class PostfixConversion {
    private String postfixExpression;

    /** Stack which handle the priority of the operations */
    private Stack operationsStack;

    /**
     * Convert infix to postfix.
     * <p>
     * @param str mathematical expression to convert
     * @return Postfix expression
     */
    public String toPostfix(String str) {
        String[] strings = str.split(" ");
        this.postfixExpression = "";
        this.operationsStack = new Stack(strings.length);

        for (String s : strings) {
            if(s.matches("^[0-9]*$")) {                 // if is a number goes directly to the postfix expression
                this.postfixExpression += s + " ";
            } else {
                // check some condition to see if the operation goes to the stack or to the expression
                operatorVerification(s);
            }
        }

        // in the end take the remaining operations from the stack and put them in the expression
        while (!this.operationsStack.isEmpty()) {
            this.postfixExpression += this.operationsStack.pop() + " ";
        }

        return this.postfixExpression;
    }

    /**
     * Organize the operation.
     * <p>Verify the priority of the operation and manipulate the stack operations.
     * <p>
     * @param s Operation
     */
    public void operatorVerification(String s) {
        // if the stack is empty the operation is pushed to the stack
        if(this.operationsStack.isEmpty()) {
            this.operationsStack.push(s);
        } else {
            String stackOperation = this.operationsStack.pop(); // pop operation from stack to compare with the operation passed as argument

            // if is equals to close parenthesis it will save the value from stack
            // pop the next operation from the stack to see if is a open parenthesis
            // if it is, don't go to the stack, if is a operation is pushed to the stack again
            if(s.equals(")")) {
                this.postfixExpression += stackOperation + " ";
                stackOperation = this.operationsStack.pop();

                if(!stackOperation.equals("(")) {
                    this.operationsStack.push(stackOperation);
                }

                return;
            }

            // if the operation from the stack or the operation from the argument is equals to the open parenthesis
            // it pushes the argument and the stack operation back to stack
            // because only the closed parenthesis can pop the open parenthesis
            // and the operation can't be compared to "(" so it goes to the stack without check priorities
            if(s.equals("(") || stackOperation.equals("(")) {
                this.operationsStack.push(stackOperation);
                this.operationsStack.push(s);
                return;
            }

            int sPriority = OperationType.symbolToOperation(s).getPriority();
            int stackOperationPriority = OperationType.symbolToOperation(stackOperation).getPriority();

            // In some calculators
            // appearing ^ this two times followed, the priority is not applied
            /*if(s.equals("^") && stackOperation.equals("^")) {
                this.operationsStack.push(s);
                this.operationsStack.push(stackOperation);
                return;
            }*/

            // if the operation pop from the stack has an higher priority or equals to the string passed as argument
            // the popped operations go to the expression and the string is pushed
            // else are both pushed to the stack with the stack operation going first
            if(stackOperationPriority >= sPriority) {
                this.postfixExpression += stackOperation + " ";
            } else {
                this.operationsStack.push(stackOperation);
            }

            this.operationsStack.push(s);
        }
    }

}
