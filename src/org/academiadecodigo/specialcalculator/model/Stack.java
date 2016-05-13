package org.academiadecodigo.specialcalculator.model;

/**
 * Created by codecadet on 10/05/16.
 */
public class Stack {
    private String[] stack;
    private int stackPosition = 0;

    public Stack(int size) {
        this.stack = new String[size];
    }

    public void push(String str) {
        str = switchOperations(str);

        this.stack[this.stackPosition] = str;
        this.stackPosition++;
    }

    public String pop() {
        this.stackPosition--;
        return this.stack[this.stackPosition]; // add one because is the current position
    }

    public boolean isEmpty() {
        return this.stackPosition == 0;
    }

    public String switchOperations(String str) {
        if((str.equals("+") || str.equals("-")) && this.stackPosition != 0) {

            String strPushed = this.stack[this.stackPosition - 1];

            if(strPushed.equals("*") || strPushed.equals("/")) {
                pop();
                push(str);

                return strPushed;
            } else {
                return str;
            }

        } else {
            return str;
        }
    }

    @Override
    public String toString() {
        String strToReturn = "";

        for (String str : this.stack) {
            if(str == null) {
                return strToReturn;
            }

            strToReturn += str + " ";
        }

        return strToReturn;
    }
}
