/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.sideprojects;

import java.util.Scanner;

/**
 *
 * @author Diyar
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // VARIABLES
        String[][] board = new String[3][3];
        boolean noWinner = true, XTurn = true;
        int turnsCounter = 0;

        // GAME
        buildBoard(board);
        displayBoard(board);

        while (noWinner) {

            playMove(board, XTurn);
            turnsCounter++;

            displayBoard(board);
            noWinner = winnerCheck(board, XTurn, noWinner, turnsCounter);

            if (noWinner) {
                XTurn = false;
                playMove(board, XTurn);
                turnsCounter++;

                displayBoard(board);
                noWinner = winnerCheck(board, XTurn, noWinner, turnsCounter);
                XTurn = true;
            }
        }

    }

    public static void buildBoard(String[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = "#";
            }
        }
    }

    public static void displayBoard(String[][] board) {

        int numberCoordinate = 1;

        System.out.println("A B C");
        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (col != 2) {
                    System.out.print(board[row][col] + "|");
                } else {
                    System.out.println(board[row][col] + " " + numberCoordinate);
                    numberCoordinate++;
                }

            }
            if (row != 2) {
                System.out.println("-+-+-");
            }

        }
    }

    public static void playMove(String[][] board, boolean XTurn) {

        //There is no check for if an X/O is already there
        String choice;
        Scanner input = new Scanner(System.in);
        int row, col;

        System.out.println("Where would you like to move?");
        choice = input.nextLine();

        row = Integer.parseInt(choice.substring(1, 2)) - 1;
        col = choice.charAt(0) - 65;

        if (XTurn) {
            board[row][col] = "X";
        } else {
            board[row][col] = "O";
        }
    }

    public static boolean winnerCheck(String[][] board, boolean XTurn, boolean noWinner, int turnsCounter) {

        if (turnsCounter > 4) {

            for (int i = 0; i < board.length; i++) {

                if (!board[i][0].equals("#") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                    noWinner = false;
                    i = board.length;

                } else if (!board[0][i].equals("#") && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) {
                    noWinner = false;
                    i = board.length;

                }

            }

            if (noWinner) {
                if (!board[0][0].equals("#") && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
                    noWinner = false;
                } else if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
                    noWinner = false;
                }
            }

            if (!noWinner) {
                if (XTurn) {
                    System.out.println("X wins!");
                } else {
                    System.out.println("O wins!");
                }
            }
        }

        if (turnsCounter == 9 && noWinner) {
            noWinner = false;
            System.out.println("It's a tie!");
        }

        return noWinner;
    }

}
