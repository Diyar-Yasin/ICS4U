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
        int[][] cellGrid = new int[20 + 2][20 + 2];
        int[][] prevGenGrid = new int[20 + 2][20 + 2];
        int gridSize = (cellGrid[0].length - 2) * (cellGrid.length - 2), choice;

        // OBJECTS
        Scanner input = new Scanner(System.in);

        // INPUT
        cellGrid = startUp(cellGrid, gridSize);                          //First create the grid based on how many cells the user wants
        prevGenGrid = copy(cellGrid);                                    //Make a copy so we know what the previous generation looks like
        displayGrid(prevGenGrid);                                        //Display the previous generation

        System.out.println("Advance to next generation? Press 1");
        System.out.println("Press any other key to exit.");
        choice = input.nextInt();

        while (choice == 1) {
            checkCellState(cellGrid);                                        //Update the grid
            displayGrid(cellGrid);                                           //Display the updated grid         

            System.out.println("Advance to next generation? Press 1");
            System.out.println("Press any other key to exit.");
            choice = input.nextInt();
        }

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
            for (int r = 1; r < gridSize; r++) {
                for (int c = 1; c < gridSize; c++) {
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
                row = (int) (Math.random() * (19 + 1) + 1);
                //19 represents a value that will eventually be a variable of the cellGrid.length - 1
                col = (int) (Math.random() * (19 + 1) + 1);
                //The + 1 at the end is so we dont get 0 as an indice

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
        int[][] copy = new int[20 + 2][20 + 2];

        // INPUT
        for (int row = 1; row < cellGrid.length - 1; row++) {
            for (int col = 1; col < cellGrid.length - 1; col++) {
                copy[row][col] = cellGrid[row][col];
            }
        }

        // OUTPUT
        return copy;
    }

    public static void displayGrid(int[][] cellGrid) {

        for (int row = 1; row < cellGrid.length - 1; row++) {
            for (int col = 1; col < cellGrid.length - 1; col++) {
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
        for (int r = 1; r < cellGrid.length - 1; r++) {
            for (int c = 1; c < cellGrid.length - 1; c++) {
                cellState = cellGrid[r][c];
                neighCount = countNeigh(cellState, cellGrid, r, c);

                switch (neighCount) {
                    case 0:
                        if (cellState == CELL_ALIVE) {
                            cellState = CELL_DEAD;
                        }
                        break;
                    case 1:
                        if (cellState == CELL_ALIVE) {
                            cellState = CELL_DEAD;
                        }
                        break;
                    case 2:
                    case 3:
                        if (cellState == CELL_DEAD) {
                            cellState = CELL_ALIVE;
                        }
                        break;
                    default:
                        if (cellState == CELL_ALIVE) {
                            cellState = CELL_DEAD;
                        }
                        break;
                }

                cellGrid[r][c] = cellState;
            }
        }
    }

    public static int countNeigh(int cellState, int[][] cellGrid, int r, int c) {

        // VARIABLES
        int counting = 0;

        // INPUT        
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (cellGrid[r + x][c + y] == CELL_ALIVE) {
                    counting++;
                }
            }
        }

        if (cellGrid[r][c] == CELL_ALIVE) {
            counting = counting - CELL_ALIVE;
        } else if (cellGrid[r][c] == CELL_DEAD) {
            counting = counting - CELL_DEAD;
        }

        return counting;
    }
}
