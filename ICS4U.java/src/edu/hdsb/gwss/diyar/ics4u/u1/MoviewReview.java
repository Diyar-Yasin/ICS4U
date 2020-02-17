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

        sentenceReview();

    }

    public static double wordReview(String currentWord) throws FileNotFoundException {

        // VARIABLES
        double scoreCount = 0, score = 0, wordRecurrance = 0, averageWordScore = 0, counter = 0;
        String currentLine;

        // OBJECTS
        Scanner fileReader = new Scanner(reviewFile);
        StringTokenizer st;

        // INPUT
        System.out.println("What word are you searching for? ");
        currentWord = input.nextLine().toLowerCase();

        while (fileReader.hasNext()) {
            currentLine = fileReader.nextLine();
            st = new StringTokenizer(currentLine, "-, ");
            counter = 0;
            score = 0;

            score = score + Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {

                if ((st.nextToken().toLowerCase()).equals(currentWord)) {
                    counter++;
                }
            }

            if (counter != 0) {
                wordRecurrance++;
                scoreCount = scoreCount + score;
            }
        }

        averageWordScore = scoreCount / wordRecurrance;

        return averageWordScore;
    }

    public static void sentenceReview() throws Exception {

        // VARIABLES
        String fileName, currentWord;
        int i = 0, recurrance;
        String[] sentence;
        double sentenceScore = 0;

        // OBJECTS
        Scanner fileReader;

        // INPUT
        System.out.println("Input a file name to review: ");
        fileName = input.nextLine();

        fileReader = new Scanner(fileName);

        while (fileReader.hasNext()) {
            i++;
        }

        sentence = new String[i];

        fileReader = new Scanner(fileName); // Bad way to reset pointer to start of file

        for (int n = 0; fileReader.hasNext(); n++) {
            sentence[n] = fileReader.nextLine().toLowerCase();
        }
        // Everything above makes an array with each word in its own memory location
        
        for (int n = 0; n < sentence.length; n++){
            
            recurrance = 0;
            currentWord  = sentence[n];
            
            for (int x = 0; x < sentence.length; x++){ 
            //This for loop compares every word with the currentWord so the "weight" of the word can be taKen into account
                if (currentWord.equals(sentence[x])){
                    //This means that the word recurs
                    recurrance++;
                }
            }
            
            sentenceScore = sentenceScore + recurrance * wordReview(currentWord);  
        }
        
        sentenceScore = sentenceScore/sentence.length;
        
        System.out.println("The average score of words in " + fileName + " is " + sentenceScore);
        
        if (sentenceScore > 2.2){
            System.out.println("The overall sentiment is positive!");
        }
        else if (sentenceScore < 1.8){
            System.out.println("The overall sentiment is negative!");
        }
        else{
            System.out.println("The overall sentiment is neutral.");
        }

        
    }
}


