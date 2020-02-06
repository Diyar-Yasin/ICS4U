/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ww
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // VARIABLES
        String s;
        String t = "";
        
        // OBJECTS
        Scanner input = new Scanner(System.in);
        
        // INPUT
        System.out.println("Input a word: ");
        
        s = (input.nextLine()).toLowerCase();
        
        for (int i = s.length();i > 0;i--){
            
            t = t + s.substring(i-1, i);        
        }
        
        if (s.equals(t)) System.out.println(s + " is a palindrome!");
        else System.out.println(s + " is not a palindrome!");
        
        
 
    }
   
}
