package org.academiadecodigo.specialcalculator.util;

import org.academiadecodigo.specialcalculator.model.Stack;

/**
 * Created by andre on 14/05/2016.
 */
public class PostfixConversion {
    String postfixExpression;
    Stack operationsStack;

    /**
     * Convert infix to postfix
     * @param str mathematical expression to convert
     * @return string with the postfix expression
     */
    public String toPostfix(String str) {
        String[] strings = str.split(" ");
        this.postfixExpression = "";
        this.operationsStack = new Stack(strings.length);

        for (String s : strings) {
            if(s.matches("^[0-9]*$")) {                 // if is a number goes directly to the postfix expression
                this.postfixExpression += s + " ";
            } else {
                // go check some condition to see if the operation goes to the stack or to the expression
                operatorVerification(s);
            }
        }

        // in the end take the remaining operations from the stack and put them in the expression
        while (!this.operationsStack.isEmpty()) {
            this.postfixExpression += this.operationsStack.pop() + " ";
        }

        return this.postfixExpression;
    }

    public void operatorVerification(String s) {
        // if the stack is empty the operation is pushed to the stack
        if(this.operationsStack.isEmpty()) {
            this.operationsStack.push(s);
        } else {
            String stackOperation = this.operationsStack.pop(); // pop operation from stack to compare with the operation passed as argument

            // if is equals to close parenthesis it will save the value from stack
            // pop the next operation from the stack to see if is a open parenthesis
            // if it is, doesn't goes to the stack otherwise is a operation is pushed to the stack again
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

            // In some calculator and comparing results
            // appearing ^ this two times followed the priority is not applied but with this if it resolve it
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
