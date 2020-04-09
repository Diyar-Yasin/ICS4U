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

        row(0, 10);                                                 //Always starts the row at 0, ending at 10

    }

    public static int term(int row, int col) {                      //Function finds the term at any row, column
        int answer;

        if (row == 0 || row == 1 || col == 0 || row == col) {       //If it is at the start or end of the row or it is the first two rows
            answer = 1;                                             // we already know the answer will be 1
        } else {                                                    //Otherwise, calculate the term by adding the terms that are 1 above it
            answer = term(row - 1, col) + term(row - 1, col - 1);   // and 1 above it and 1 to the left of it
        }

        return answer;
    }

    public static void row(int currentRow, int endRow) {            //Function prints out the entire triangle

        for (int i = 0; i <= currentRow; i++) {                     //As long as more values exist in the row keep printing terms

            if (i == 0) {                                           //If we are on the term of the row..
                for (int j = 0; j < endRow - currentRow; j++) {     //Loop for as many times as the difference between the endRow and 
                    System.out.print(" ");                          // currentRow. (If currentRow == 0 and endRow == 10, it will add
                }                                                   // 10 spaces before placing the first term
            }
            System.out.print(term(currentRow, i) + " ");            //Print the term at row, column with a space after

        }
        System.out.println("");                                     //Moves pointer down a line after the row is complete
        if (currentRow < endRow) {                                  //If we have not reached the final row..
            row(currentRow + 1, endRow);                            //Call row again with 1 added to the currentRow, printing the next
        }                                                           // row down.
    }
}
