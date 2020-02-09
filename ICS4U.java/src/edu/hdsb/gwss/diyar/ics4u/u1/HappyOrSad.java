/*
Name: Diyar Yasin
Date:
Desc:
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Diyar
 */
public class HappyOrSad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // VARIABLES
        int happyCount = 0;
        int sadCount = 0;
        String inputText;

        // OBJECTS
        Scanner input = new Scanner(System.in);

        // INPUT
        System.out.println("Input a sentence: ");

        inputText = input.nextLine();

        StringTokenizer st = new StringTokenizer(inputText, ":()");
        
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
            //Current problem: I am cutting out the : and () w/ StringTokenizer and I need that to evaluate
        }

        // OUTPUT
    }

}
