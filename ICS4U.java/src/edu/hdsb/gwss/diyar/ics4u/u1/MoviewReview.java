/*
 * Rotten Tomatoes
 * ICS4U.2020.S2
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 *Name: Diyar Yasin
 *Date: Feb. 18, 2020
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
            //As long as the user does not input 5, after each 1-4 input this menu will repeat
            System.out.println("\nWhat would you like to do?");
            System.out.println("1: Get the score of a word");
            System.out.println("2: Get the average score of words in a file (one word per line)");
            System.out.println("3: Find the highest or lowest scoring words in a file");
            System.out.println("4: Sort words from a file into positive.txt and negative.txt");
            System.out.println("5: Exit the program");

            choice = input.nextInt();
            input.nextLine();
            //Takes their choice input to be used in a switch statement, the added input.nextLine() is to fix an uncommon issue
            //where input.nextLine() in case 1 is skipped (and wordReview runs with no data in currentWord

            switch (choice) {
                //If a value that is not 1-5 is entered it will simply loop back to the above code
                case 1:
                    //Part 1: Word review
                    System.out.println("\nWhat is the word you are searching for?");
                    currentWord = input.nextLine().toLowerCase();
                    //This gets the searchWord and makes sure it does not differentiate between caps/no caps: horrIBLE --> horrible

                    wordValues = wordReview(currentWord);
                    //Assigns the double array output from wordReview to another double array in the main method which has all of the
                    //added scores for the currentWord at indice 0 and the number of sentences it shows up in at indice 1

                    System.out.println("The word " + currentWord + " appears " + wordValues[1] + " times.");
                    System.out.println("The average word score is " + wordValues[0] / wordValues[1]);
                    break;

                case 2:
                    //Part 2: Sentence review
                    sentenceReview(choice);
                    //All of the parts from part 2-4 rely on the base method of sentenceReview, by passing the value of the choice
                    //to the sentenceReview method, I have an if statement that will gate the end output for parts 2, 3, and 4
                    break;

                case 3:
                    //Part 3: Multiple word score
                    sentenceReview(choice);
                    break;

                case 4:
                    //Part 4: Multiple word score sort
                    sentenceReview(choice);
                    break;

                case 5:
                    //End the program
                    loop = false;
                    //Ends the while loop so the program can terminate
                    break;
            }
        }
    }

    public static double[] wordReview(String currentWord) throws FileNotFoundException {
        //This method finds the score and how many sentences a word given by the user in the main method (or given by the sentenceReview
        // method) shows up in and returns the two in a double array.

        // VARIABLES
        double scoreCount = 0, score = 0, wordRecurrance = 0, counter = 0;
        double[] wordValues = new double[2];

        // OBJECTS
        String currentLine;
        Scanner fileReader = new Scanner(reviewFile);
        //Creates a scanner for the MovieReviews.txt file
        StringTokenizer st;

        // INPUT
        while (fileReader.hasNext()) {
            //As long as more lines in MovieReviews.txt have not been checked for having the currentWord execute the following

            currentLine = fileReader.nextLine();
            //The current line we are checking is the next unanalyzed line in MovieReviews.txt
            st = new StringTokenizer(currentLine, "-, ");
            //Create tokens at spaces between words, commas , and hyphens (they are not part of the word)
            counter = 0;
            score = 0;
            //Resets the counter and score variables after each line in MovieReviews.txt is analyzed

            score = Integer.parseInt(st.nextToken());
            //The first token will always be the score, it must be saved in a temporary variable in case the line contains our
            //currentWord as we will be looping through all of the tokens (and we would not be able to access the score by then)

            while (st.hasMoreTokens()) {
                //As long as more words exist in the line execute the following

                if ((st.nextToken().toLowerCase()).equals(currentWord)) {
                    //If the word in the sentence is equal to the currentWord (ignoring capitals), we add one to the counter
                    counter++;
                }
            }

            if (counter != 0) {
                //If the counter is 0, that means the currentWord exists in the line. This means it occurs in at least one sentence
                //so add one to the wordRecurrance and save the score value we got earlier in a more permanent variable scoreCount
                wordRecurrance++;
                scoreCount = scoreCount + score;
            }
        }

        wordValues[0] = scoreCount;
        wordValues[1] = wordRecurrance;
        //Putting these two values into a double array allows me to return multiple values to sentenceReview so that the averages
        //and sorting algorithms can work properly

        System.out.println(scoreCount/wordRecurrance);
        
        return wordValues;
        //Returns the double array 
    }

    public static void sentenceReview(int choice) throws Exception {
        //This takes a file (one word per line) inputted by the user and finds the scores of each word in the file and then
        //finds the total score of the sentence and whether it is an overall positive, negative, or neutral sentence. It also
        //connects to next two methods depending on the users initial choice in the main method.

        // VARIABLES
        double sentenceScore = 0, totalWordScore = 0, totalRecurrance = 0;
        double[] wordValues, wordScores, recurranceScores;

        // OBJECTS
        List<String> sentence = new ArrayList<>();
        //This arraylist does not need to have a defined size as it creates more space when it needs it, this is convenient
        //because I will not know what the length of the inputted file will be
        String fileName, currentWord;
        Scanner fileReader;

        // INPUT
        System.out.println("\nInput a file name to review: ");
        fileName = input.nextLine();
        //Receives a file name and stores it in fileName

        File file = new File(".//data//movie.review//" + fileName);
        //Creates a new file for the file the user wants read in the location .//data//movie.review//fileName

        fileReader = new Scanner(file);
        //Creates a scanner for the file

        for (int n = 0; fileReader.hasNext(); n++) {
            //As long as another line in the file has not been read, add the line to the arraylist. The file is always one word per line.
            //This means I do not need to tokenize the file and instead can just add each word (ignoring case) into the arraylist,
            //one line at a time.
            sentence.add(fileReader.nextLine().toLowerCase());
        }

        wordScores = new double[sentence.size()];
        recurranceScores = new double[sentence.size()];
        //Creates two double arrays the size of the arraylist to put the total score and number of recurrances in seperate arrays

        for (int n = 0; n < sentence.size(); n++) {
            //Repeats the following for every word in the arraylist

            currentWord = sentence.get(n);
            //Sets the currentWord to the first (then second, third, ..., n) word in the arraylist

            wordValues = wordReview(currentWord);
            //Gets the total score and recurrance of the word into a double array and then assigns them to the two seperate
            //double arrays wordScores and recurranceScores

            wordScores[n] = wordValues[0];
            recurranceScores[n] = wordValues[1];
            //After completely analyzing every word in the arraylist, wordScores will have the total score of word 1 at indice 0,
            //total score of word 2 at indice 1, and so on. The same idea for recurranceScores.
        }

        // OUTPUT
        switch (choice) {
            case 2:
                for (int n = 0; n < sentence.size(); n++) {
                    //Repeats for all of the words in the arraylist

                    totalWordScore = totalWordScore + wordScores[n];
                    totalRecurrance = totalRecurrance + recurranceScores[n];
                    //Adds all of wordScores and recurranceScores up into doubles, this is to find the total sentence score
                    //but it is only necessary if the user enters choice 2, so it is all under case 2
                }

                sentenceScore = totalWordScore / totalRecurrance;
                //Calculates the total sentence score

                System.out.println("The average score of words in " + fileName + " is " + sentenceScore);

                if (sentenceScore > 2.2) {
                    //If the score of the sentence in the file is greater than 2.2, the message was mostly positive
                    System.out.println("The overall sentiment is positive!");
                } else if (sentenceScore < 1.8) {
                    //If the score of the sentence in the file is less than 1.8, the message was mostly negative
                    System.out.println("The overall sentiment is negative!");
                } else {
                    //If the score is in between 2.2 and 1.8 (inclusive), the message was mostly neutral
                    System.out.println("The overall sentiment is neutral.");
                }
                break;
            case 3:
                maxMinValues(wordScores, recurranceScores, sentence);
                //If the user wants the max and min scored words we need to pass the wordScores and recurranceScores seperately
                //The arraylist (sentence) is used in the output so that the user knows which words had the max and min scores
                break;
            case 4:
                scoreSort(wordScores, recurranceScores, sentence);
                //Similarly to case 3, we need to pass wordScores and recurranceScores seperately. The arraylist (sentence) is needed
                //so that the words can be put into their proper files based on their scores
                break;
        }
    }

    public static void maxMinValues(double[] wordScores, double[] recurranceScores, List<String> sentence) {
        //This method uses the wordScores, recurranceScores, and sentence to find the largest and smallest word scores
        //and then outputs them to the user

        // VARIABLES
        double max, min;
        //We set the max and min to the first word's score and then check it against every other word in the arraylist

        // OBJECTS
        List<Double> totalScores = new ArrayList<>();
        String maxWord = sentence.get(0), minWord = sentence.get(0);
        //Setting the maximum and minimum words to the first word in the arraylist and it will change if the upcoming words
        //in the array list are larger than the max or smaller than the min

        // INPUT
        for (int n = 0; n < sentence.size(); n++) {
            if (Double.isNaN(wordScores[n] / recurranceScores[n])) {
                sentence.remove(n);
            } else {
                totalScores.add(wordScores[n] / recurranceScores[n]);
            }
        }

        //System.out.println(sentence.size());
        //System.out.println(totalScores.size());

        max = totalScores.get(0);
        min = totalScores.get(0);

        for (int n = 1; n < totalScores.size(); n++) {

            //System.out.println(totalScores.get(n));
            //System.out.println(sentence.get(n));
            if (max < totalScores.get(n)) {
                max = totalScores.get(n);
                maxWord = sentence.get(n);
            }

            if (min > totalScores.get(n)) {
                min = totalScores.get(n);
                minWord = sentence.get(n);
            }
        }

//        for (int n = 1; n < wordScores.length; n++) {
//            //As long as more words exist check if the next word is a greater max or if the next word is a lower min
//            //(because wordScores, recurranceScores, and sentence will all be the same length it does not matter which 
//            //one we use for the argument above)
//
//            if (max < (wordScores[n] / recurranceScores[n])) {
//                //If the current maximum word's score is less than the one at 1 (2, 3, .., n) , change the max to word at n and
//                //the maxWord to word n
//                max = wordScores[n] / recurranceScores[n];
//                maxWord = sentence.get(n);
//            }
//
//            if (min > (wordScores[n] / recurranceScores[n])) {
//                //If the current minimum word's score is greater than the one at 1 (2, 3, .., n) , change the min to word at n and
//                //the minWord to word n
//                min = wordScores[n] / recurranceScores[n];
//                minWord = sentence.get(n);
//            }
//        }
        // OUTPUT
        System.out.println(
                "The most positive word is " + maxWord + " with a score of " + max);
        System.out.println(
                "The most negative word is " + minWord + " with a score of " + min);

    }

    public static void scoreSort(double[] wordScores, double[] recurranceScores, List<String> sentence) throws FileNotFoundException {
        //This method takes the wordScores, recurranceScores, and sentence from sentenceReview and prints each word from the file
        //given by the user into two seperate files called positive.txt (if the word has a score > 2.2) and negative.txt
        //(if the word has a score < 1.8). Words in between 2.2 and 1.8 (inclusive) are not written into files.

        // OBJECTS
        File fileOutputPos = new File(".//data//movie.review//positive.txt");
        File fileOutputNeg = new File(".//data//movie.review//negative.txt");
        //Creates two new files for positive.txt and negative.txt

        PrintWriter outputPos = new PrintWriter(fileOutputPos);
        PrintWriter outputNeg = new PrintWriter(fileOutputNeg);
        //Creates two seperate print writers. outputPos writes to positive.txt and outputNeg to negative.txt.

        // INPUT
        for (int n = 0; n < wordScores.length; n++) {
            //Analyzes every word in the users inputted file (because wordScores, recurranceScores, 
            //and sentence will all be the same length it does not matter which one we use for the argument above)

            if (recurranceScores[n] == 0) {
                //This is an error checker that makes sure we do not divide by 0, if the word does not recurr we should
                //not consider it as a max or min value 
                n++;
            }

            if ((wordScores[n] / recurranceScores[n]) < 1.8) {
                //If the word at n's score is less than 1.8 it is a negative word and so is written into negative.txt
                outputNeg.println(sentence.get(n));
            } else if ((wordScores[n] / recurranceScores[n]) > 2.2) {
                //If the word at n's score is greater than 2.2 it is a positve word and so is written into positive.txt
                outputPos.println(sentence.get(n));
            }
        }

        outputPos.close();
        outputNeg.close();
        //Closes both printwriters after use
    }
}
