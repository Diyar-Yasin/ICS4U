/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u3;

import java.util.Scanner;

/**
 *
 * @author Diyar
 */
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = 1;
        
        System.out.println("SEQUENCE 1:");
        while (n < 6){
            System.out.println(tnFinder(n));
            n++;
        }
        
        n = 1;
        
        System.out.println("\nSEQUENCE 2:");
        while (n < 6){
            System.out.println(tnFinder2(n));
            n++;
        }
    }

    public static int tnFinder(int n) {

        int answer;

       if (n != 1 && n != 2){
           answer = tnFinder(n - 1) + tnFinder(n - 2);
       }
       else if(n == 1){
           answer = 1;
       }
       else{
           answer = 3;
       }

        return answer;
    }
    
    public static double tnFinder2(int n){
        
        double answer;
        
        if (n != 1){
            answer = Math.sqrt(3 * tnFinder2(n - 1) + 4);
        }
        else{
            answer = 2;
        }
        
        
        return answer;
    }
}
