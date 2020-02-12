/*
 * Rotten Tomatoes
 * ICS4U.2020.S2
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author YOU
 */
public class MoviewReview {

    // CLASS CONSTANTS
    private static final String FS = File.separator;
    private static final int MENU_WORD_SCORE = 1;
    private static final int MENU_SENTENCE_SCORE = 2;
    private static final int MENU_WORD_MAX_MIN = 3;
    private static final int MENU_WORD_SORT = 4;
    private static final int MENU_EXIT = 5;

    // CLASS VARIABLES
    private static File reviewFile = new File("." + FS + "data" + FS + "movie.review" + FS + "MovieReviews.txt");
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        

    }
    
    public static void wordReview(String fileName) throws FileNotFoundException{
        
        // VARIABLES
        String currentWord;
        int score;
        double scoreCount = 0;
        int counter = 0;
        double wordRecurrance = 0;
        double averageWordScore;
        String currentLine;
        String nextLine;
        
        // OBJECTS
        Scanner fileReader = new Scanner(fileName);

        // INPUT
        
        while (fileReader.hasNext()) {
            
            scoreCount = 0;
            currentLine = fileReader.nextLine();
       
            scoreCount = scoreCount + Integer.parseInt(currentLine.substring(0,1));
            currentWord = currentLine.substring(3, currentLine.length());
             
            while(fileReader.hasNext()){
                
                nextLine = fileReader.nextLine();
                
                if ((currentWord.toLowerCase()).equals((nextLine.toLowerCase()).substring(3, nextLine.length()))){
                    scoreCount = scoreCount + Integer.parseInt(nextLine.substring(0,1));
                    wordRecurrance++;
                }
            }
            
            averageWordScore = averageWordScore + score/wordRecurrance; //This needs to be weighted but its not working rn
            
        }

        averageWordScore = scoreCount/wordRecurrance;

    }
    
    public static void sentenceReview() throws FileNotFoundException{
        
        // VARIABLES
        String fileName;
        
        // INPUT
        System.out.println("Input a file name to review: ");
        fileName = input.nextLine();
        
        
        wordReview(fileName);
    }

}
