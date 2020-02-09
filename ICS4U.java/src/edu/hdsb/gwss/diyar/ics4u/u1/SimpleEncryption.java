/*
Name: Diyar Yasin
Date: Feb. 9, 2020
Desc: Encrypts or decrypts a sentence by rotating each character a variable number of times
through the alphabet. 
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
        int rotationHolder;

        // OBJECTS
        Scanner input = new Scanner(System.in);

        // INPUT
        System.out.println("Please input a line of text: ");

        inputText = input.nextLine();

        System.out.println("How many rotations? 1-25");

        rotationCount = input.nextInt();
        rotationHolder = rotationCount;

        if (rotationCount > 25 || rotationCount < 1) {
            System.out.println("INVALID INPUT");
            return;
        }

        System.out.println("If you are encrypting enter 1, otherwise enter any key:");

        if (input.nextInt() == 1) {
            choice = true;
        }

        if (choice) {
            //Encrypt the inputText
            for (int i = 0; i < inputText.length(); i++) {

                if (inputText.charAt(i) > 64 && inputText.charAt(i) < 91) {
                    //It is uppercase
                    if (inputText.charAt(i) + rotationCount > 91) {
                        //If we rotate and go over Z, we must rewind back to A
                        rotationCount = inputText.charAt(i) + rotationCount - 91;
                        //This is how many more times we must rotate

                        charValue = 65 + rotationCount;
                        //64 is value under A 
                    } else {
                        //This means the rotations dont cross Z
                        charValue = inputText.charAt(i) + rotationCount;
                    }

                    charSymbol = (char) charValue;
                    outputText = outputText + charSymbol;

                } else if (inputText.charAt(i) > 96 && inputText.charAt(i) < 123) {
                    //It is lowercase
                    if (inputText.charAt(i) + rotationCount > 123) {
                        rotationCount = inputText.charAt(i) + rotationCount - 123;

                        charValue = 97 + rotationCount;
                    } else {
                        charValue = inputText.charAt(i) + rotationCount;
                    }
                    charSymbol = (char) charValue;
                    outputText = outputText + charSymbol;
                } else {
                    //This means it is a space, which means no rotations are needed
                    outputText = outputText + inputText.charAt(i);
                }

                rotationCount = rotationHolder;
                //This ensures that we can reset the rotationCount after each char iteration
            }
        } else {
            //Decrypt the inputText
            for (int i = 0; i < inputText.length(); i++) {

                if (inputText.charAt(i) > 64 && inputText.charAt(i) < 91) {
                    //It is uppercase
                    if (inputText.charAt(i) - rotationCount < 64) {
                        //If we rotate and under A, we must rewind back to Z
                        rotationCount = rotationCount - (inputText.charAt(i) - 64);
                        //This is how many more times we must rotate

                        charValue = 90 - rotationCount;
                        //64 is value under A 
                    } else {
                        //This means the rotations dont cross Z
                        charValue = inputText.charAt(i) - rotationCount;
                    }

                    charSymbol = (char) charValue;
                    outputText = outputText + charSymbol;

                } else if (inputText.charAt(i) > 96 && inputText.charAt(i) < 123) {
                    //It is lowercase
                    if (inputText.charAt(i) - rotationCount < 96) {
                        rotationCount = rotationCount - (inputText.charAt(i) - 96);

                        charValue = 122 - rotationCount;
                    } else {
                        charValue = inputText.charAt(i) - rotationCount;
                    }

                    charSymbol = (char) charValue;
                    outputText = outputText + charSymbol;

                } else {
                    //This means it is a space, which means no rotations are needed
                    outputText = outputText + inputText.charAt(i);
                }

                rotationCount = rotationHolder;
                //This ensures that we can reset the rotationCount after each char iteration
            }
        }

        // OUTPUT
        System.out.println(outputText);
    }

}
