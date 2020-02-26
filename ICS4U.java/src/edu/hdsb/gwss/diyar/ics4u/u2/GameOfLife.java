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
    static final int CELL_EMPTY = 0;
    static final int CELL_ALIVE = 1;
    static final int CELL_DEAD = 2;

    public static void main(String[] args) {

        // VARIABLES
        int[][] cellGrid = new int[20][20];
        int[][] prevGenGrid = new int[20][20];
        int gridSize = cellGrid[0].length * cellGrid.length;

        // INPUT
        cellGrid = startUp(cellGrid, gridSize);
        prevGenGrid = copy(cellGrid);
        displayGrid(prevGenGrid);
        displayGrid(cellGrid);
    }

    public static int[][] startUp(int[][] cellGrid, int gridSize) {

        // VARIABLES
        int cellCount;
        boolean allEmpty = true;

        // OBJECTS
        Scanner input = new Scanner(System.in);

        // INPUT
        System.out.println("How many living cells do you want?");
        cellCount = input.nextInt();

        if (cellCount < gridSize / 2) { //What if they input over 400 cellCount? Or under 0? I have no solution for this case yet
            cellGrid = addCells(cellCount, cellGrid, allEmpty, gridSize);
        } else if (cellCount > gridSize / 2) {
            for (int r = 0; r < 20; r++) {
                for (int c = 0; c < 20; c++) {
                    cellGrid[r][c] = 1;
                }
            }
            allEmpty = false;
            cellGrid = addCells(cellCount, cellGrid, allEmpty, gridSize);

        }
        return cellGrid;
    }

    public static int[][] addCells(int cellCount, int[][] cellGrid, boolean allEmpty, int gridSize) {

        // VARIABLES
        int row;
        int col;

        // INPUT
        if (allEmpty) {
            for (int i = 0; i < cellCount;) {
                row = (int) (Math.random() * 19);
                col = (int) (Math.random() * 19);

                if (cellGrid[row][col] == CELL_EMPTY) {
                    cellGrid[row][col] = CELL_ALIVE;
                    i++;
                }

            }
        } else {
            for (int i = gridSize - cellCount; i > 0;) {
                row = (int) (Math.random() * 19);
                col = (int) (Math.random() * 19);

                if (cellGrid[row][col] == CELL_ALIVE) {
                    cellGrid[row][col] = CELL_EMPTY;
                    i--;
                }

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

    public static void displayGrid(int[][] cellGrid) {

        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                System.out.print(cellGrid[row][col] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void checkCellState(int[][] cellGrid) {

        // VARIABLES
        int neighCount;
        int cellState;
        
        // INPUT
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                cellState = cellGrid[r][c];
                neighCount = countNeigh(cellState);
                switch neighCount{
                    case:
                }
            }
        }
    }
    
    public static int countNeigh(int cellState){
        
        return cellState;
    }

}
