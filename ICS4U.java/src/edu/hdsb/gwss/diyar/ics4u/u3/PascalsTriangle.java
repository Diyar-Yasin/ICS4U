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

        row(0, 10);

    }

    public static int term(int row, int col) {
        int answer;

        if (row == 0 || row == 1 || col == 0 || row == col) {
            answer = 1;
        } else {
            answer = term(row - 1, col) + term(row - 1, col - 1);
        }

        return answer;
    }

    public static void row(int startRow, int endRow) {

        for (int i = 0; i <= startRow; i++) {
            System.out.print(term(startRow, i) + " ");

        }
        System.out.println("");
        if (startRow < endRow) {
            row(startRow + 1, endRow);
        }

    }
}
