/*
 * Rotten Tomatoes
 * ICS4U.2020.S2
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

        // VARIABLES
        int choice;
        boolean loop = true;
        double[] wordValues = new double[2];
        String currentWord;

        // INPUT
        while (loop) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1: Get the score of a word");
            System.out.println("2: Get the average score of words in a file (one word per line)");
            System.out.println("3: Find the highest or lowest scoring words in a file");
            System.out.println("4: Sort words from a file into positive.txt and negative.txt");
            System.out.println("5: Exit the program");

            choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("\nWhat is the word you are searching for?");
                    currentWord = input.nextLine().toLowerCase();

                    wordValues = wordReview(currentWord);
                    
                    System.out.println("The word " + currentWord + " appears " + wordValues[1] + " times.");
                    System.out.println("The average word score is " + wordValues[0]/wordValues[1]);
                    break;

                case 2:
                    sentenceReview(choice);
                    break;

                case 3:
                    sentenceReview(choice);
                    break;

                case 4:
                    sentenceReview(choice);
                    break;

                case 5:
                    loop = false;
                    break;

            }
        }

    }

    public static double[] wordReview(String currentWord) throws FileNotFoundException {

        // VARIABLES
        double scoreCount = 0, score = 0, wordRecurrance = 0, averageWordScore = 0, counter = 0;
        String currentLine;
        double[] wordValues = new double[2];

        // OBJECTS
        Scanner fileReader = new Scanner(reviewFile);
        StringTokenizer st;

        // INPUT
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

        wordValues[0] = scoreCount;
        wordValues[1] = wordRecurrance;

        return wordValues;
    }

    public static void sentenceReview(int choice) throws Exception {

        // VARIABLES
        String fileName, currentWord;
        int i = 0;
        String[] sentence;
        double sentenceScore = 0, totalWordScore = 0, totalRecurrance = 0;
        double[] wordValues = new double[2], wordScores, recurranceScores;

        // OBJECTS
        Scanner fileReader;

        // INPUT
        System.out.println("Input a file name to review: ");
        fileName = input.nextLine();

        File file = new File(".//data//movie.review//" + fileName);

        fileReader = new Scanner(file); //Add an arraylist

        while (fileReader.hasNext()) {
            fileReader.nextLine();
            i++;
        }

        sentence = new String[i];

        fileReader = new Scanner(file); // Bad way to reset pointer to start of file, use arraylist

        for (int n = 0; fileReader.hasNext(); n++) {
            sentence[n] = fileReader.nextLine().toLowerCase();
        }

        // Everything above makes an array with each word in its own memory location
        wordScores = new double[sentence.length];
        recurranceScores = new double[sentence.length];

        for (int n = 0; n < sentence.length; n++) {

            currentWord = sentence[n];
            wordValues = wordReview(currentWord);
            wordScores[n] = wordValues[0];
            recurranceScores[n] = wordValues[1];
        }

        for (int n = 0; n < sentence.length; n++) {
            totalWordScore = totalWordScore + wordScores[n];
            totalRecurrance = totalRecurrance + recurranceScores[n];
        }

        sentenceScore = totalWordScore / totalRecurrance;

        // OUTPUT
        switch (choice) {
            case 2:
                System.out.println("The average score of words in " + fileName + " is " + sentenceScore);

                if (sentenceScore > 2.2) {
                    System.out.println("The overall sentiment is positive!");
                } else if (sentenceScore < 1.8) {
                    System.out.println("The overall sentiment is negative!");
                } else {
                    System.out.println("The overall sentiment is neutral.");
                }
                break;
            case 3:
                maxMinValues(wordScores, recurranceScores, sentence);
                break;
            case 4:
                scoreSort(wordScores, recurranceScores, sentence);
                break;
        }

    }

    public static void maxMinValues(double[] wordScores, double[] recurranceScores, String[] sentence) {

        // VARIABLES
        double max = wordScores[0] / recurranceScores[0], min = wordScores[0] / recurranceScores[0];
        String maxWord = sentence[0], minWord = sentence[0];

        // INPUT
        // Find the max
        for (int n = 1; n < wordScores.length; n++) {

            if (max < (wordScores[n] / recurranceScores[n])) {
                max = wordScores[n] / recurranceScores[n];
                maxWord = sentence[n];
            }

        }
        // Find the min
        for (int n = 1; n < wordScores.length; n++) {

            if (min > (wordScores[n] / recurranceScores[n])) {
                min = wordScores[n] / recurranceScores[n];
                minWord = sentence[n];
            }

        }

        // OUTPUT
        System.out.println("The most positive word is " + maxWord + " with a score of " + max);
        System.out.println("The most negative word is " + minWord + " with a score of " + min);

    }

    public static void scoreSort(double[] wordScores, double[] recurranceScores, String[] sentence) throws FileNotFoundException {

        // VARIABLES
        File fileOutputPos = new File(".//data//movie.review//positive.txt");
        File fileOutputNeg = new File(".//data//movie.review//negative.txt");

        PrintWriter outputPos = new PrintWriter(fileOutputPos);
        PrintWriter outputNeg = new PrintWriter(fileOutputNeg);

        // INPUT
        for (int n = 0; n < wordScores.length; n++) {
            if ((wordScores[n] / recurranceScores[n]) < 1.8) {
                outputNeg.println(sentence[n]);
            } else if ((wordScores[n] / recurranceScores[n]) > 2.2) {
                outputPos.println(sentence[n]);
            }
        }

        outputPos.close();
        outputNeg.close(); //Do i close anything in the other methods? Do I need to?
    }
}
