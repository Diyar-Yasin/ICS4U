/*
Name: Diyar Yasin
Date: Feb. 10, 020
Desc: Takes a sentence and determines if it is happy/sad depending on the amount f
:-) and :-( emoticons present
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

        StringTokenizer happy = new StringTokenizer(inputText, ":)");
        
        StringTokenizer sad = new StringTokenizer(inputText, ":(");
        
        while (happy.hasMoreTokens()){
            
            if (happy.nextToken().equals("-")){
                happyCount++;
            }
        }
        
        while (sad.hasMoreTokens()){
            if (sad.nextToken().equals("-")){
                sadCount++;
            }
        }
        
        // OUTPUT
        if (happyCount > sadCount){
            System.out.println("It is happy!");
        }
        else if (sadCount > happyCount){
            System.out.println("It is sad!");
        }
        else{
            System.out.println("It is neutral.");
        }
    }

}
