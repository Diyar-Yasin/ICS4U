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
public class RecursiveFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int x = -5;
        int y = -2;
        int m = 5;
        int n = 5;
        
        System.out.println(functionRun(x, y));
        System.out.println(ackerRun(m, n));
    }
    
    public static int ackerRun(int m, int n){
        
        int answer;
        
        if (m == 0){
            answer = n + 1;
        }
        else if(m > 0 && n == 0){
            answer = ackerRun(m - 1, 1);
        }
        else{
            answer = ackerRun(m-1, ackerRun(m, n-1));
        }
        
        return answer;
    }
    
    public static int functionRun(int x, int y){
        
        int answer;
        
        if (x < y){
            answer = -functionRun(y, x);
        }
        else if(x > y){
            answer = 1 + functionRun(x - 1, y);
        }
        else{
            answer = 0;
        }
        
        return answer;
    }
    
}
