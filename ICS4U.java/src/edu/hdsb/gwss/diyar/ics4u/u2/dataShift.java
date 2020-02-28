/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u2;

/**
 *
 * @author ww
 */
public class dataShift {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // VARIABLES
        int[][] data = {
            {2, 0, 0, 2},
            {0, 2, 2, 0},
            {0, 0, 0, 2},
            {2, 0, 2, 2}
        };
        
        display(data);
    }
    
    public static void display(int[][] data){
        for (int r = 0; r < 4; r++){
            for (int c = 0; c < 4; c++){
                System.out.print(data[r][c] + " ");
            }
            System.out.println("");
        }
    }
    
    public static int[][] shiftLeft(int[][] data){
        
    }
    
}
