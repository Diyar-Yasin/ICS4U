/*
Name: Diyar Yasin
Date:
Desc:
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.util.Scanner;

/**
 *
 * @author Diyar
 */
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // VARIABLES
        String inputText;
        String outputText = "";
        int charValue;
        char charSymbol;
        boolean choice = false;
        int rotationCount;
        
        // OBJECTS
        Scanner input = new Scanner(System.in);
        
        // INPUT
        System.out.println("Please input a line of text: ");
        
        inputText = input.nextLine();
        
        System.out.println("How many rotations?");
        
        rotationCount = input.nextInt();
        
        System.out.println("If you are encrypting enter 1, otherwise enter any key:");
        
        if (input.nextInt() == 1) choice = true;
        
        if (choice){
            for(int i = 0;i < inputText.length();i++){
                charValue = inputText.charAt(i) + rotationCount;
                charSymbol = (char) charValue;
                outputText = outputText + charSymbol;
            }
            System.out.println(outputText);
        }
        else {
            
        }
        //Currently: I have a system to encrypt any line however I am not sure how it handles spaces and
        //it does not loop back
        
        // OUTPUT
        
    }
    
}
