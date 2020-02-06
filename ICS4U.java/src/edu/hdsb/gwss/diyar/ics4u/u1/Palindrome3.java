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
        
        StringTokenizer st = new StringTokenizer( s );
        
        
        while( st.hasMoreTokens() ){
            
          n = st.nextToken();
          t = "";
            
          for (int i = n.length();i > 0;i--){
            
             t = t + n.substring(i-1, i);
              
         }
          
          k = k + t;
            
        }
        
        // NOT WORKING RN
        System.out.println(s);
        
        System.out.println(k);
        
        if (s.equals(k)) System.out.println(s + " is a palindrome!");
        else System.out.println(s + " is not a palindrome!");
    }  
}
