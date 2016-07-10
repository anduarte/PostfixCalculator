package org.academiadecodigo.postfixcalculator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by codecadet on 19/05/16.
 */
public class Utils {

    /**
     * Read the user input
     * <p>
     * @return Input
     * @throws IOException
     */
    public static String readInput() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(inputStreamReader);

        return keyboard.readLine();
    }

    /**
     * Process the expression received from the input to be correctly readed
     * <p>
     * @param expression readed from the input
     * @return the expression in the way that the program can read
     */
    public static String processExpression(String[] expression) {
        String str = "";

        for(int i = 0; i < expression.length; i++) {
            String strCompareOld = expression[i];

            if (strCompareOld.matches("^[0-9]*$")) {
                str += strCompareOld + "";
            } else if(strCompareOld.equals("(")) {
                str += strCompareOld + " ";
            } else if(strCompareOld.equals(")")) {
                str += " " + strCompareOld;
            } else if(!strCompareOld.equals(" ")) {
                str += " " + strCompareOld + " ";
            }
        }

        return str;
    }
}
