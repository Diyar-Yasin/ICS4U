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
        
        wordReview();
        
    }
    
    public static void wordReview() throws FileNotFoundException{
        
        // VARIABLES
        double scoreCount = 0, score = 0, wordRecurrance = 0, averageWordScore = 0, counter = 0;
        String currentWord, currentLine, nextLine;
        
        // OBJECTS
        Scanner fileReader = new Scanner(reviewFile);
        StringTokenizer st;
        
        // INPUT
        System.out.println("What word are you searching for? ");
        currentWord = input.nextLine().toLowerCase();
        
        while (fileReader.hasNext()){
            currentLine = fileReader.nextLine();
            st = new StringTokenizer(currentLine, "-, ");
            counter = 0;
            score = 0;
            
            score = score + Integer.parseInt(st.nextToken());
            
            while(st.hasMoreTokens()){
                
                if((st.nextToken().toLowerCase()).equals(currentWord)){
                    counter++;
                }
            }
            
            if (counter != 0){
                wordRecurrance++;
                scoreCount = scoreCount + score;
            }
        }
        
        averageWordScore = scoreCount/wordRecurrance;
        
        System.out.println("It recurrs " + wordRecurrance + " times");
        System.out.println("With average score of " + averageWordScore);
    }
    
    public static void sentenceReview() throws Exception{
        
        // VARIABLES
        String fileName;
        
        // INPUT
        System.out.println("Input a file name to review: ");
        fileName = input.nextLine();
        
        
    }

}
