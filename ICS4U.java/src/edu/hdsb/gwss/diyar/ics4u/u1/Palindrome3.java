/*
Name: Diyar Yasin
Date: Feb. 8, 2020
Desc: Program that checks if a sentence is a palindrome
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ww
 */
public class Palindrome3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // VARIABLES
        String s = "";
        String t = "";
        String n = "";
        String k = "";

        // OBJECTS
        Scanner input = new Scanner(System.in);

        // INPUT
        System.out.println("Input a sentence: ");

        s = (input.nextLine()).toLowerCase();
        // Set original line to lowercase (since program does not care about case)

        StringTokenizer st = new StringTokenizer(s);
        // Tokenize the original line into seperate words so each word can be flipped and
        // concatenated to a new String variable

        while (st.hasMoreTokens()) {

            n = st.nextToken();
            t = "";
            // Reset t so that it can be reused for each subsequent word

            for (int i = n.length(); i > 0; i--) {
                // Adds each character back to String t going from last indice to the first
                // Flipping the word

                t = t + n.substring(i - 1, i);

            }
            t = t + " ";
            //Adds a space after each word
            k = t + k;
            // Adds each flipped word t to line k
        }

        k = k.trim();
        s = s.trim();
        /* 
        * There will be an extra space at the end of every line in k because each word (t) has a " " added
        * this means I must also trim the original line (s) in case a sentence like " racecar " is inputted.
        * it ensures I do not compare "racecar" to " racecar ", both will be trimmed down
        */
        
        // OUTPUT
        if (s.equals(k)) {
            System.out.println(k + " is a palindrome!");
        } else {
            System.out.println(k + " is not a palindrome!");
        }
        // Compares original string s to concatenated string k and outputs
    }
}
