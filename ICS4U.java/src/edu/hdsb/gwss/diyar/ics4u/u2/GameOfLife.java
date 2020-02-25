/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u2;

import java.util.Scanner;

/**
 *
 * @author ww
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    public static int CELL_ALIVE = 1;
    public static int CELL_DEAD = 2;

    public static void main(String[] args) {

        // VARIABLES
        int[][] cellGrid = new int[20][20];

        // INPUT
        copy(cellGrid);
    }

    public static int[][] start(int[][] cellGrid) {

        // VARIABLES
        int row;
        int col;
        int cellCount;

        // OBJECTS
        Scanner input = new Scanner(System.in);
        
        // INPUT
        System.out.println("How many living cells do you want?");
        cellCount = input.nextInt();
        
        for (int i = 0; i < cellCount; i++){
            row = (int) (Math.random() * 20 + 1);
            col = (int) (Math.random() * 20 + 1);

            if (cellGrid[row][col] == 0) {
                cellGrid[row][col] = CELL_ALIVE;
            }

        }

        return cellGrid;
    }

    public static int[][] copy(int[][] cellGrid) {

        // VARIABLES
        int[][] copy = new int[20][20];

        // INPUT
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                copy[row][col] = cellGrid[row][col];
            }
        }

        // OUTPUT
        return copy;
    }

}
