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
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 4;
        
        row(n);
    }
    
    public static int term(int row, int col){
        //finds the term at row, col
        int answer = 0;
        
        if (row == col || col == 0){
            answer = 1;
        }
        
        

        return answer;
    }
    
    public static void row(int row){
        //prints the triangle 
        
        if (row >= 0){
            System.out.println(term(row, row) + " ");
            row(row - 1);
        }
    }
}
