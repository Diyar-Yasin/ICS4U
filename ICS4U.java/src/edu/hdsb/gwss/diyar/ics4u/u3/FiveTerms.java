/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u3;

/**
 *
 * @author Diyar
 */
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = 1;                                          //n represents the number of terms
        
        System.out.println("SEQUENCE 1:");
        while (n < 6){                                      //This will run 5 times (printing 5 terms)
            System.out.println(tnFinder(n));                //Calls and returns the value of each term of the sequence
            n++;
        }
        
        n = 1;                                              //Reset n back to 1 so we can get the first five terms of a new sequence
            
        System.out.println("\nSEQUENCE 2:");
        while (n < 6){                                      //This will run 5 times (printing 5 terms) 
            System.out.println(tnFinder2(n));               //Calls and returns the value of each term of the sequence
            n++;
        }
    }

    public static int tnFinder(int n) {

       int answer;

       if (n != 1 && n != 2){                               //As long as n is not the first two terms we use the base terms from
           answer = tnFinder(n - 1) + tnFinder(n - 2);      // n == 1 and n == 2 to solve for the nth term we want
       }
       else if(n == 1){                                     //n == 1 and n == 3 are both the base values we use to calculate
           answer = 1;                                      // subsequent terms in the pattern
       }
       else{
           answer = 3;
       }

       return answer;
    }
    
    public static double tnFinder2(int n){                  //In our second sequence the answer must be a double since we need to hold
                                                            // decimal values
        double answer;
        
        if (n != 1){                                        //n == 1 has a base value of 2, any other value is calculatable using the
            answer = Math.sqrt(3 * tnFinder2(n - 1) + 4);   // following recursive formula
        }
        else{
            answer = 2;
        }
        
        
        return answer;
    }
}
