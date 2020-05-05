/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.sideprojects;

import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author Diyar
 */
public class Chess {

    /**
     * @param args the command line arguments
     */
    static final char EMPTY = 'o';

    static final char B_PAWN = 'p';
    static final char B_KNIGHT = 'n';
    static final char B_BISHOP = 'b';
    static final char B_ROOK = 'r';
    static final char B_QUEEN = 'q';
    static final char B_KING = 'k';

    static final char W_PAWN = 'P';
    static final char W_KNIGHT = 'N';
    static final char W_BISHOP = 'B';
    static final char W_ROOK = 'R';
    static final char W_QUEEN = 'Q';
    static final char W_KING = 'K';

    public static void main(String[] args) {

        // VARIABLES
        char[][] board = new char[8][8];
        char[][] prevBoard = new char[8][8];
        boolean game = true;
        String move, moveTo;
        int[] pieceLocation = new int[2];
        int[] moveToLocation = new int[2];
        int[][] availableMoves = new int[28][2];

        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 2; j++) {
                availableMoves[i][j] = 8; //8 is a value that will never be a piece location, this way if the row/col is 8,8 we know that 
                //particular move is not possible
            }
        }

        // OBJECTS
        Scanner input = new Scanner(System.in);

        // INPUT
        setUpBoard(board);

        while (game) {

            copyBoard(prevBoard, board);
            displayBoard(board);

            System.out.println("What is the location of the piece would you like to move? e.g. A6, G3");
            move = input.nextLine();
            findLocation(move, pieceLocation);

            if (board[pieceLocation[0]][pieceLocation[1]] != EMPTY) {
                availableMoves = checkAvailableMoves(prevBoard, pieceLocation);

                System.out.println("Where would you like to move this piece?");
                moveTo = input.nextLine();
                System.out.println("");

                findLocation(moveTo, moveToLocation); //This will take the new location e.g. A6 and convert it into a row, col

                if (possibleMoveCheck(availableMoves, moveToLocation)) {
                    //If the move is possible, execute it

                    board[moveToLocation[0]][moveToLocation[1]] = board[pieceLocation[0]][pieceLocation[1]];
                    board[pieceLocation[0]][pieceLocation[1]] = EMPTY;

                } else {
                    System.out.println("This move is not possible!");
                    System.out.println("");
                }
                //This will compare the value found from findLocation above to all
                // available moves that piece can make

            } else {
                System.out.println("This square is empty!");
                System.out.println("");
            }

        }

    }

    public static boolean possibleMoveCheck(int[][] availableMoves, int[] pieceLocation) {

        boolean moveAvailable = false;

        for (int i = 0; i < 28.; i++) {
            if (pieceLocation[0] == availableMoves[i][0]) {
                if (pieceLocation[1] == availableMoves[i][1]) {
                    i = 28; //End the function because we know that the move is possible
                    moveAvailable = true;
                }
            }
        }
        return moveAvailable;
    }

    public static void setUpBoard(char[][] board) {

        board[0][0] = W_ROOK;
        board[0][1] = W_KNIGHT;
        board[0][2] = W_BISHOP;
        board[0][3] = W_KING;
        board[0][4] = W_QUEEN;
        board[0][5] = W_BISHOP;
        board[0][6] = W_KNIGHT;
        board[0][7] = W_ROOK;

        board[7][0] = B_ROOK;
        board[7][1] = B_KNIGHT;
        board[7][2] = B_BISHOP;
        board[7][3] = B_KING;
        board[7][4] = B_QUEEN;
        board[7][5] = B_BISHOP;
        board[7][6] = B_KNIGHT;
        board[7][7] = B_ROOK;

        for (int i = 0; i < 8; i++) {
            board[1][i] = W_PAWN;
            board[2][i] = EMPTY;
            board[3][i] = EMPTY;
            board[4][i] = EMPTY;
            board[5][i] = EMPTY;
            board[6][i] = B_PAWN;
        }
    }

    public static void copyBoard(char[][] prevBoard, char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                prevBoard[i][j] = board[i][j];
            }
        }
    }

    public static void displayBoard(char[][] board) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static int[] findLocation(String move, int[] pieceLocation) {

        int col = move.charAt(0);
        int row = Integer.parseInt(move.substring(1, 2));

        pieceLocation[0] = 8 - row;
        pieceLocation[1] = col - 65;

        return pieceLocation;
    }

    public static int[][] checkAvailableMoves(char[][] prevBoard, int[] pieceLocation) {

        //TO ADD:
        //A system like pawnCheck for every other type of piece:
        //Rook
        //Knight
        //Bishop
        //King
        //Queen
        
        char piece = prevBoard[pieceLocation[0]][pieceLocation[1]];
        int[][] availableMoves = new int[28][2];//28 moves is max for queen, 2 for row and col

        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 2; j++) {
                availableMoves[i][j] = 8; //8 is a value that will never be a piece location, this way if the row/col is 8,8 we know that 
                //particular move is not possible
            }
        }

        switch (piece) {
            case 'p': //Will move to 'P' and perform pawnCheck without me having to copy and paste the code under case 'P' for case 'p'
            case 'P':
                availableMoves = pawnCheck(prevBoard, pieceLocation, piece, availableMoves);
                break;
            case 'n':
            case 'N':
                availableMoves = knightCheck(prevBoard, pieceLocation, piece, availableMoves);
                break;
            default:
                break;
        }

        return availableMoves;
    }
    
    public static int[][] knightCheck(char[][] prevBoard, int[] pieceLocation, char piece, int[][] availableMoves){
        
        //WHITE PIECE MOVE CHECK
        
        
        if (piece == 'n'){
            
            //TOP-RIGHT
            if (prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'p' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'n' ||
                    prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'b' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'r'
                    || prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'q' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'k'){
                //AVAILABLE MOVE
            }
            //TOP-LEFT
            if (prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'p' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'n' ||
                    prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'b' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'r'
                    || prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'q' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'k'){
                //AVAILABLE MOVE
            }
            //RIGHT-TOP
            if(prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'p' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'n' ||
                    prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'b' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'r'
                    || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'q' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'k'){
                //AVAILABLE MOVE
            }
            //RIGHT-BOT
            if(prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'p' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'n' ||
                    prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'b' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'r'
                    || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'q' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'k' ){
                //AVAILABLE MOVE
            }
            //LEFT-TOP
            if(prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'p' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'n' ||
                    prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'b' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'r'
                    || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'q' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'k' ){
                //AVAILABLE MOVE
            }
            //LEFT-BOT
            if(prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'p' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'n' ||
                    prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'b' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'r'
                    || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'q' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'k' ){
                //AVAILABLE MOVE
            }
            //DOWN-RIGHT
            if(prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'p' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'n' ||
                    prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'b' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'r'
                    || prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'q' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'k' ){
                //AVAILABLE MOVE
            }
            //DOWN-LEFT
            if(prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'p' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'n' ||
                    prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'b' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'r'
                    || prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'q' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'k' ){
                //AVAILABLE MOVE
            }
        }
        //BLACK PIECE MOVE CHECK
        else{
            //TOP-RIGHT
            if (prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'P' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'N' ||
                    prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'B' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'R'
                    || prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'Q' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] + 1] != 'K'){
                //AVAILABLE MOVE
            }
            //TOP-LEFT
            if (prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'P' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'N' ||
                    prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'B' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'R'
                    || prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'Q' || prevBoard[pieceLocation[0] - 2][pieceLocation[1] - 1] != 'K'){
                //AVAILABLE MOVE
            }
            //RIGHT-TOP
            if(prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'P' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'N' ||
                    prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'B' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'R'
                    || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'Q' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 2] != 'K'){
                //AVAILABLE MOVE
            }
            //RIGHT-BOT
            if(prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'P' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'N' ||
                    prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'B' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'R'
                    || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'Q' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 2] != 'K' ){
                //AVAILABLE MOVE
            }
            //LEFT-TOP
            if(prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'P' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'N' ||
                    prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'B' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'R'
                    || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'Q' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 2] != 'K' ){
                //AVAILABLE MOVE
            }
            //LEFT-BOT
            if(prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'P' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'N' ||
                    prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'B' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'R'
                    || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'Q' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 2] != 'K' ){
                //AVAILABLE MOVE
            }
            //DOWN-RIGHT
            if(prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'P' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'N' ||
                    prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'B' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'R'
                    || prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'Q' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] + 1] != 'K' ){
                //AVAILABLE MOVE
            }
            //DOWN-LEFT
            if(prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'P' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'N' ||
                    prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'B' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'R'
                    || prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'Q' || prevBoard[pieceLocation[0] + 2][pieceLocation[1] - 1] != 'K' ){
                //AVAILABLE MOVE
            }
        }
        
        return availableMoves;
    }

    public static int[][] pawnCheck(char[][] prevBoard, int[] pieceLocation, char piece, int[][] availableMoves) {

        //TO ADD:
        //En passant should be implemented eventually
        //Same with pins on the king, right now the pawn won't be able to capture the king at all
        //If pawns reach end of board, there is no error checking for that!

        //WHITE PIECE MOVE CHECK
        if (piece == 'p') {
            if (pieceLocation[0] == 6) { //White pawns will only be at this row if its move 1, so they can move 2 squares up 
                if (prevBoard[pieceLocation[0] - 2][pieceLocation[1]] == EMPTY && prevBoard[pieceLocation[0] - 1][pieceLocation[1]] == EMPTY) {

                    //TOP TOP
                    availableMoves[0][0] = pieceLocation[0] - 2;
                    availableMoves[0][1] = pieceLocation[1];

                }
            }
            if (prevBoard[pieceLocation[0] - 1][pieceLocation[1]] == EMPTY) {

                // TOP
                availableMoves[1][0] = pieceLocation[0] - 1;
                availableMoves[1][1] = pieceLocation[1];

            }
            if (prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 1] == 'R' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 1] == 'P'
                    || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 1] == 'N' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 1]
                    == 'B' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] + 1] == 'Q') {

                //TOP RIGHT
                availableMoves[2][0] = pieceLocation[0] - 1;
                availableMoves[2][1] = pieceLocation[1] + 1;

            }
            if (prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 1] == 'R' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 1] == 'P'
                    || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 1] == 'N' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 1]
                    == 'B' || prevBoard[pieceLocation[0] - 1][pieceLocation[1] - 1] == 'Q') {

                // TOP LEFT
                availableMoves[3][0] = pieceLocation[0] - 1;
                availableMoves[3][1] = pieceLocation[1] - 1;
            }

            //BLACK PIECE MOVE CHECK
        } else {
            if (pieceLocation[0] == 1) { //Black pieces on move 1 will only be on this row, and will never return to the row once moved
                if (prevBoard[pieceLocation[0] + 2][pieceLocation[1]] == EMPTY && prevBoard[pieceLocation[0] + 1][pieceLocation[1]] == EMPTY) {

                    //BOT BOT
                    availableMoves[0][0] = pieceLocation[0] + 2;
                    availableMoves[0][1] = pieceLocation[1];

                }
            }
            if (prevBoard[pieceLocation[0] + 1][pieceLocation[1]] == EMPTY) {

                // BOT
                availableMoves[1][0] = pieceLocation[0] + 1;
                availableMoves[1][1] = pieceLocation[1];

            }
            if (prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 1] == 'R' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 1] == 'P'
                    || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 1] == 'N' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 1]
                    == 'B' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] + 1] == 'Q') {

                //BOT RIGHT
                availableMoves[2][0] = pieceLocation[0] + 1;
                availableMoves[2][1] = pieceLocation[1] + 1;

            }
            if (prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 1] == 'R' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 1] == 'P'
                    || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 1] == 'N' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 1]
                    == 'B' || prevBoard[pieceLocation[0] + 1][pieceLocation[1] - 1] == 'Q') {

                // BOT LEFT
                availableMoves[3][0] = pieceLocation[0] + 1;
                availableMoves[3][1] = pieceLocation[1] - 1;

            }
        }

        return availableMoves;
    }

}
