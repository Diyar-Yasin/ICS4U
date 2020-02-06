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
public class Palindrome2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // VARIABLES
        String s;
        String t = "";
        String n = "";
        
        // OBJECTS
        Scanner input = new Scanner(System.in);
        
        // INPUT
        System.out.println("Input a sentence: ");
        
        s = (input.nextLine()).toLowerCase();
        
        StringTokenizer st = new StringTokenizer( s );
        
        
        while( st.hasMoreTokens() ){
            
          n = st.nextToken();
          t = "";
            
          for (int i = n.length();i > 0;i--){
            
             t = t + n.substring(i-1, i);
              
         }
        if (n.equals(t)) System.out.println(n + " is a palindrome!");
        else System.out.println(n + " is not a palindrome!");
        }
    }
    
}
