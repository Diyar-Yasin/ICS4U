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
            //As long as the user does not press 5, the while loop will keep asking the below 
            System.out.println("\nWhat would you like to do?");
            System.out.println("1: Get the score of a word");
            System.out.println("2: Get the average score of words in a file (one word per line)");
            System.out.println("3: Find the highest or lowest scoring words in a file");
            System.out.println("4: Sort words from a file into positive.txt and negative.txt");
            System.out.println("5: Exit the program");

            choice = input.nextInt();
            //Sets your choice as an integer for the switch statement below
            input.nextLine();
            //Moves pointer to avoid error when I use input.nextLine() in case 1:

            switch (choice) {
                case 1:
                    //Part 1: word review
                    System.out.println("\nWhat is the word you are searching for?");
                    currentWord = input.nextLine().toLowerCase();
                    //Sets the currentWord we are searching for in MovieReviews.txt to the next input (ignoring case)

                    wordValues = wordReview(currentWord);
                    //Calls wordReview

                    if (wordValues[1] == 0) {
                        //If the denominator is 0, that means it recurrs 0 times and does not exist
                        System.out.println("The word " + currentWord + " doesn't exist!");
                    } else {
                        //It occurs otherwise and so we calculate the average and tell the user in how many sentences it shows up in
                        System.out.println("The word " + currentWord + " appears " + wordValues[1] + " times.");
                        System.out.println("The average word score is " + wordValues[0] / wordValues[1]);
                    }
                    break;

                case 2:
                    //Part 2: sentence review
                    sentenceReview();
                    //Calls sentenceReview
                    break;

                case 3:
                    //Part 3: Multiple word score
                    maxMinValues();
                    //Calls maxMinValues
                    break;

                case 4:
                    //Part 4: Multiple word score sort
                    scoreSort();
                    //Calls scoreSort
                    break;

                case 5:
                    //Ends program
                    loop = false;
                    //Ends while loop by setting loop to false
                    break;

            }
        }
    }

    public static double[] wordReview(String currentWord) throws FileNotFoundException {
        //Method that takes a word and finds out how many times it shows up in MovieReviews.txt. It then adds up all of the scores
        //from those sentences and returns a double array with the total word score and total number of recurrances 

        // VARIABLES
        double scoreCount = 0, score = 0, wordRecurrance = 0, counter = 0;
        String currentLine;
        double[] wordValues = new double[2];

        // OBJECTS
        Scanner fileReader = new Scanner(reviewFile);
        StringTokenizer st;

        // INPUT
        while (fileReader.hasNext()) {
            //As long as there are more lines in MovieReviews.txt do the following
            currentLine = fileReader.nextLine();
            //Set the current line we are analyzing to the next line in the file
            st = new StringTokenizer(currentLine, "-, ");
            //Tokenize the line at the hyphen, comma, and space because those are where words start and end in the file
            counter = 0;
            score = 0;
            //Resets both counter and score for each successive line in MovieReviews.txt

            score = score + Integer.parseInt(st.nextToken());
            //Set the score to the first token since it will always be at the start, score will be used depending on if
            //the currentWord shows up in the currentLine we are analyzing so score is just a placeholder for the value

            while (st.hasMoreTokens()) {
                //As long as there are more words from currentLine do the following

                if ((st.nextToken().toLowerCase()).equals(currentWord.toLowerCase())) {
                    //If the next token is the same as the currentWord (ignoring case) we add one to the counter
                    //to tell us that the word is in this sentence
                    counter++;
                }
            }

            if (counter != 0) {
                //If counter is not 0 that means the word was found in the just analyzed sentence so add one to the wordRecurrance
                //and add the score value to the more permanent scoreCount for the word
                wordRecurrance++;
                scoreCount = scoreCount + score;
            }
        }

        wordValues[0] = scoreCount;
        wordValues[1] = wordRecurrance;
        //Once all the lines in the MovieReviews.txt file have been analyzed, set indice 0 of the double array wordValues
        //to the total score count and indice 1 to the number of sentences the word showed up in

        return wordValues;
        //Return this double array
    }

    public static void sentenceReview() throws Exception {
        //This method takes a file with one word per line and gets the average score of the sentence by evaluating the score of
        //each word and weighting it base on how many times we see it in the file

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
        //Gets a fileName from the user

        file = new File(".//data//movie.review//" + fileName);
        //Accesses the file through this directory

        fileReader = new Scanner(file);
        //Sets a scanner to that file

        for (int n = 0; fileReader.hasNext(); n++) {
            sentence.add(fileReader.nextLine());
            //This for loop adds every word in the file as its own element in an array list, the array list does not need to have its
            //size predefined it will adjust as needed and it is thus useful for us because I can never know the size of the file the
            //user will pass to the program
        }

        wordScores = new double[sentence.size()];
        recurranceScores = new double[sentence.size()];
        //Create two new double arrays one for the score of each word and one for the recurrances of each word (in MovieReviews.txt,
        //not the file the user passed)

        for (int n = 0; n < sentence.size(); n++) {
            //As long as there are more words in the files sentence do the following

            currentWord = sentence.get(n);
            wordValues = wordReview(currentWord);
            //Set the current word to the word at 0, 1, 2, ... and then pass the current word to wordReview and put the returned
            //double array into another double array called wordValues

            wordScores[n] = wordValues[0];
            recurranceScores[n] = wordValues[1];
            //Seperate the data in wordValues into scores and recurrances. At indice 0 for wordScores/recurranceScores you will find
            //values for the first word in the file and at indice 1 you will find the values for the second word in the file and so on.
        }

        for (int n = 0; n < sentence.size(); n++) {
            //As long as there are more words in the file do the following

            totalWordScore = totalWordScore + wordScores[n];
            totalRecurrance = totalRecurrance + recurranceScores[n];
            //Calculate the overall word score and recurrance of all the words in the file by adding them up into totalWordScore and
            //totalRecurrance
        }

        if (totalRecurrance != 0) {
            //As long as there were words that were evaluated (showed up in MovieReviews.txt) do the following

            sentenceScore = totalWordScore / totalRecurrance;
            //Caluclate the sentence score

            // OUTPUT
            System.out.println("\nhe average score of words in " + fileName + " is " + sentenceScore);

            if (sentenceScore > 2.2) {
                System.out.println("The overall sentiment is positive!");
            } else if (sentenceScore < 1.8) {
                System.out.println("The overall sentiment is negative!");
            } else {
                System.out.println("The overall sentiment is neutral.");
            }
            //This if, else if, else block asks is the score of the sentence greater than 2.2? It is overall a positive sentence
            //Is it less than 1.8? It is overall a negative sentence. Is it in between? It is overall neutral

        } else {
            //If there were no recurrances total that means nothing was in the file or the words were not found in MovieReviews.txt
            System.out.println("\nThis file is either empty or has words that are invalid!");
            //This then returns to the menu
        }

    }

    public static void maxMinValues() throws FileNotFoundException {
        //This method finds the maximum and minimum scores of words in a file (one word per line)
        //and then returns them to the user. If multiple words share the same maximum or minimum score they 
        //are all given back to the user

        // VARIABLES
        double max, min, check;
        boolean valid = true;
        double[] wordValues;
        String maxWord, minWord, fileName, nextWord;
        ArrayList<String> morePositive = new ArrayList<>(), moreNegative = new ArrayList<>();

        // OBJECTS
        Scanner fileReader;
        File file;

        // INPUT
        System.out.println("\nInput a file name to find max and mins for: ");
        fileName = input.nextLine();
        //Gets the file that the user wants to analyzed

        file = new File(".//data//movie.review//" + fileName);
        //Creates a new file based on the directory above
        fileReader = new Scanner(file);
        //Creates a scanner for the file

        maxWord = fileReader.nextLine();
        //Sets the maximum scored word to the next line 

        while (wordReview(maxWord)[1] == 0) {
            //As long as the recurrance of the current maxWord is 0 (meaning it does not exist in MovieReviews.txt and thus has no
            //score, set maxWord to the next line in the file
            if (fileReader.hasNext()) {
                //If there are more unchecked lines set the maxWord to the next one and loop
                maxWord = fileReader.nextLine();
            } else {
                //If we run out of lines and they all can't be found in MovieReviews.txt, then there is no valid data to analyze
                System.out.println("No valid data!");
                valid = false;
                //This brings you back to the menu because all of the work below will not be run by the if statement which checks for this
            }

        }

        if (valid) {
            minWord = maxWord;
            //Set both the minimum word and maximum word to this valid word

            wordValues = wordReview(maxWord);
            max = wordValues[0] / wordValues[1];
            //Call wordReview and set the score of the maxWord 

            wordValues = wordReview(minWord);
            min = wordValues[0] / wordValues[1];
            //Call wordReview and set the score of the minWord

            while (fileReader.hasNext()) {
                //As long as more lines in the file exist do the following
                
                nextWord = fileReader.nextLine();
                //Set the next word to the next line in the file

                wordValues = wordReview(nextWord);
                check = wordValues[0] / wordValues[1];
                //Sets the score of the next word after calling wordReview

                if (max < check) {
                    //If our current max is less than the next word we set the new max to the nextWord
                    maxWord = nextWord;
                    max = check;
                }
                if (min > check) {
                    //If our current min is greater than the next word we set the new min to the nextWord
                    minWord = nextWord;
                    min = check;
                }
            }

            fileReader = new Scanner(file);
            //Create a new scanner (effecitvely reset the pointer back to the start of the file to read again)

            while (fileReader.hasNext()) {
                //As long as more lines in the file exist do the following
                
                nextWord = fileReader.nextLine();
                wordValues = wordReview(nextWord);
                //Set the next word to the next line and wordReview it (store the double array in wordValues)

                if (wordValues[1] != 0) {
                    //If it does not equal 0 that means the next word shows up in MovieReviews.txt
                    
                    check = wordValues[0] / wordValues[1];
                    //Set the score of the next word

                    if (max == check && !maxWord.equals(nextWord)) {
                        //If the score of the max value is the same as the next word and they are not the same word that
                        //means there is more than one max positive word so add it to an array list of max positive words
                        morePositive.add(nextWord);
                    }
                    if (min == check && !minWord.equals(nextWord)) {
                        //If the score of the min value is the same as the next word and they are not hte same word that
                        //means there is more than one min word so add it to an array list of negative words
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
            //Prints out the maximum words and their score and the minimum words and their score
        }

    }

    public static void scoreSort() throws FileNotFoundException {
        //This method takes words from user given file (one word per line) that are > 2.2 and puts them into a positive.txt file
        //and takes the words that are < 1.8 score and puts them into a negative.txt file, in between words are not put anywhere

        // VARIABLES
        double[] wordValues;

        // OBJECTS
        String fileName, currentWord;
        Scanner fileReader;
        File file;
        File fileOutputPos = new File(".//data//movie.review//positive.txt");
        File fileOutputNeg = new File(".//data//movie.review//negative.txt");
        //Creates two different files with their directories to positive.txt and negative.txt

        PrintWriter outputPos = new PrintWriter(fileOutputPos);
        PrintWriter outputNeg = new PrintWriter(fileOutputNeg);
        //Creates two printwriters (one for positve words, one for negative words)

        // INPUT
        System.out.println("\nInput a file name to sort the words of: ");
        fileName = input.nextLine();
        //Takes the file the user wants to sort 

        file = new File(".//data//movie.review//" + fileName);
        //Creates a new file based on the directory above
        fileReader = new Scanner(file);
        //Creates a scanner for the file

        while (fileReader.hasNext()) {
            //As long as more lines exist in the users inputted file do the following

            currentWord = fileReader.nextLine();
            wordValues = wordReview(currentWord);
            //Asign the next line as the current word and use wordReview to get the values of the word
            
            if (wordValues[1] != 0) {
                //If the words recurr in MovieReviews.txt, then they are valid and can be analyzed. If not do nothing and return to menu
                if (wordValues[0] / wordValues[1] < 1.8) {
                    //If the score of the current word is below 1.8 write onto negative.txt
                    outputNeg.println(currentWord);
                } else if (wordValues[0] / wordValues[1] > 2.2) {
                    //If the score of the current word is above 2.2 write onto positive.txt
                    outputPos.println(currentWord);
                }
            }
        }
        outputPos.close();
        outputNeg.close();
        //Close both printwriters and return to the menu
    }

}
