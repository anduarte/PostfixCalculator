package org.academiadecodigo.postfixcalculator.model;

/**
 * Created by codecadet on 10/05/16.
 * <p>
 * Stack class
 */
public class Stack {
    private String[] stack;
    private int stackPosition;  // total of values in the stack

    /**
     * Construct a stack
     * <p>
     * @param size Stack size
     */
    public Stack(int size) {
        this.stackPosition = 0;
        this.stack = new String[size];
    }

    /**
     * Push a value to the stack
     * <p>
     * @param str
     */
    public void push(String str) {
        this.stack[this.stackPosition] = str;
        this.stackPosition++;
    }

    /**
     * Pops a value out of the stack
     * <p>
     * @return
     */
    public String pop() {
        this.stackPosition--;
        return this.stack[this.stackPosition];
    }

    /**
     * checks if the stack is empty
     * <p>
     * @return
     */
    public boolean isEmpty() {
        return this.stackPosition == 0;
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
