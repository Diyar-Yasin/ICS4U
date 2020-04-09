/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u3;

import java.util.ArrayList;

/**
 *
 * @author Diyar
 */
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 10;

        for (int i = 0; n > i; i++) {
            row(i);
            System.out.println("");
        }
    }

    public static int term(int row, int col) {
        
        int term;
        
        if (row == 0){
            //This makes sure that the last number placed in a row is always 1, but the first number still needs work
            term = 1;
        }
        else{
            term = 0;
        }
        
        return term;
    }

    public static int row(int row) {
        //Currently the row and main methods work fine to produce a triangle of any size I want, but how to fill in the proper
        //terms is my major issue

        System.out.print(term(row, 0) + " ");
        if (row > 0) {
            row(row - 1);
        }
        return 0;
    }
}
