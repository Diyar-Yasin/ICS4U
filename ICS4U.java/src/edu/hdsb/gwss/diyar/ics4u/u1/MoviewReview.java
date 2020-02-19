/*
 * Rotten Tomatoes
 * ICS4U.2020.S2
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author YOU
 */
public class MoviewReview {

    // CLASS CONSTANTS
    private static final String FS = File.separator;

    // CLASS VARIABLES
    private static File reviewFile = new File("." + FS + "data" + FS + "movie.review" + FS + "MovieReviews.txt");
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // VARIABLES
        int choice;
        boolean loop = true;
        double[] wordValues;
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

                    if (wordValues[1] == 0) {
                        System.out.println("The word " + currentWord + " doesn't exist!");
                    } else {
                        System.out.println("The word " + currentWord + " appears " + wordValues[1] + " times.");
                        System.out.println("The average word score is " + wordValues[0] / wordValues[1]);
                    }
                    break;

                case 2:
                    sentenceReview();
                    break;

                case 3:
                    maxMinValues();
                    break;

                case 4:
                    scoreSort();
                    break;

                case 5:
                    loop = false;
                    break;

            }
        }

    }

    public static double[] wordReview(String currentWord) throws FileNotFoundException {

        // VARIABLES
        double scoreCount = 0, score = 0, wordRecurrance = 0, counter = 0;
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

                if ((st.nextToken().toLowerCase()).equals(currentWord.toLowerCase())) {
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

    public static void sentenceReview() throws Exception {

        // VARIABLES
        String fileName, currentWord;
        ArrayList<String> sentence = new ArrayList<>();
        double sentenceScore = 0, totalWordScore = 0, totalRecurrance = 0;
        double[] wordValues = new double[2], wordScores, recurranceScores;

        // OBJECTS
        Scanner fileReader;
        File file;

        // INPUT
        System.out.println("\nInput a file name to review: ");
        fileName = input.nextLine();

        file = new File(".//data//movie.review//" + fileName);

        fileReader = new Scanner(file);

        for (int n = 0; fileReader.hasNext(); n++) {
            sentence.add(fileReader.nextLine());
        }

        // Everything above makes an array with each word in its own memory location
        wordScores = new double[sentence.size()];
        recurranceScores = new double[sentence.size()];

        for (int n = 0; n < sentence.size(); n++) {

            currentWord = sentence.get(n);
            wordValues = wordReview(currentWord);
            wordScores[n] = wordValues[0];
            recurranceScores[n] = wordValues[1];
        }

        for (int n = 0; n < sentence.size(); n++) {
            totalWordScore = totalWordScore + wordScores[n];
            totalRecurrance = totalRecurrance + recurranceScores[n];
        }

        if (totalRecurrance != 0) {
            sentenceScore = totalWordScore / totalRecurrance;

            // OUTPUT
            System.out.println("\nhe average score of words in " + fileName + " is " + sentenceScore);

            if (sentenceScore > 2.2) {
                System.out.println("The overall sentiment is positive!");
            } else if (sentenceScore < 1.8) {
                System.out.println("The overall sentiment is negative!");
            } else {
                System.out.println("The overall sentiment is neutral.");
            }
        } else {
            System.out.println("\nThis file is empty!");
        }

    }

    public static void maxMinValues() throws FileNotFoundException {

        // VARIABLES
        double max, min, check;
        double[] wordValues;
        String maxWord, minWord, fileName, nextWord;
        ArrayList<String> morePositive = new ArrayList<>(), moreNegative = new ArrayList<>();

        // OBJECTS
        Scanner fileReader;
        File file;

        // INPUT
        System.out.println("\nInput a file name to find max and mins for: ");
        fileName = input.nextLine();

        file = new File(".//data//movie.review//" + fileName);
        fileReader = new Scanner(file);

        maxWord = fileReader.nextLine();
        while (wordReview(maxWord)[1] == 0) {
            maxWord = fileReader.nextLine();
        }

        if (!fileReader.hasNext()) {
            System.out.println("No valid data!");
        } else {
            minWord = maxWord;

            wordValues = wordReview(maxWord);
            max = wordValues[0] / wordValues[1];

            wordValues = wordReview(minWord);
            min = wordValues[0] / wordValues[1];

            while (fileReader.hasNext()) {
                nextWord = fileReader.nextLine();

                wordValues = wordReview(nextWord);
                check = wordValues[0] / wordValues[1];

                if (max < check) {
                    maxWord = nextWord;
                    max = check;
                }
                if (min > check) {
                    minWord = nextWord;
                    min = check;
                }
            }

            fileReader = new Scanner(file);

            while (fileReader.hasNext()) {
                nextWord = fileReader.nextLine();

                wordValues = wordReview(nextWord);

                if (wordValues[1] != 0) {
                    check = wordValues[0] / wordValues[1];

                    if (max == check && !maxWord.equals(nextWord)) {
                        morePositive.add(nextWord);
                    }
                    if (min == check && !minWord.equals(nextWord)) {
                        moreNegative.add(nextWord);
                    }
                }
            }

            // OUTPUT
            System.out.println("\nThe most positive word is " + maxWord + " with a score of " + max);
            System.out.println("Other words that are the most positive, with the same score as " + maxWord + " are ");
            System.out.println(morePositive);
            System.out.println("The most negative word is " + minWord + " with a score of " + min);
            System.out.println("Other words that are the most negative, with the same score as " + minWord + " are ");
            System.out.println(moreNegative);
        }

    }

    public static void scoreSort() throws FileNotFoundException {

        // VARIABLES
        double[] wordValues;

        // OBJECTS
        String fileName, currentWord;
        Scanner fileReader;
        File file;
        File fileOutputPos = new File(".//data//movie.review//positive.txt");
        File fileOutputNeg = new File(".//data//movie.review//negative.txt");

        PrintWriter outputPos = new PrintWriter(fileOutputPos);
        PrintWriter outputNeg = new PrintWriter(fileOutputNeg);

        // INPUT
        System.out.println("\nInput a file name to sort the words of: ");
        fileName = input.nextLine();

        file = new File(".//data//movie.review//" + fileName);
        fileReader = new Scanner(file);

        while (fileReader.hasNext()) {

            currentWord = fileReader.nextLine();
            wordValues = wordReview(currentWord);
            if (wordValues[1] != 0) {

                if (wordValues[0] / wordValues[1] < 1.8) {
                    outputNeg.println(currentWord);
                } else if (wordValues[0] / wordValues[1] > 2.2) {
                    outputPos.println(currentWord);
                }
            }
        }
        outputPos.close();
        outputNeg.close();
    }

}
