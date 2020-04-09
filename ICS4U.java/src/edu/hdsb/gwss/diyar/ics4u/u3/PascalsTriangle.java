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

        for (int i = 0, j = 0; n > i; i++, j++) {
            row(i, j);
            System.out.println("");
        }
    }

    public static int term(int row, int col) {
        
        int term;
        
        if (row == 0 || (col == row - 1 )){
            term = 1;
        }
        else{
            term = 0;
        }
        
        return term;
    }

    public static int row(int row, int col) {

        System.out.print(term(row, col) + " ");
        if (row > 0) {
            row(row - 1, col);
        }
        return 0;
    }
}
