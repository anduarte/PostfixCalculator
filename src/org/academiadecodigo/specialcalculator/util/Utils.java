package org.academiadecodigo.specialcalculator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by codecadet on 19/05/16.
 */
public class Utils {

    /**
     * @return String with the input
     * @throws IOException
     */
    public static String readInput() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(inputStreamReader);

        return keyboard.readLine();
    }

    /**
     * Process the expression received from the input to be correctly reade
     * @param expression
     * @return
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
