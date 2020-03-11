/**
 * This method reads a 2D data set from the specified file. The Graphics'
 * industry standard is width by height (width x height), while programmers
 * use rows x cols / (height x width).
 *
 * @param fileName the name of the file
 * @return a 2D array (rows x cols) of the data from the file read
 */
 import java.util.Scanner;
 import java.util.StringTokenizer;
 
public static int[][] readData( String fileName) {

  int[][] data;                                                    //Create the array that will hold the file's data
  int rows = 0, cols;                                              //Initialize the rows and cols, cols cannot be given an initial value because we have not yet tokenized 
                                                                   //  the first line in the file
  File file = new File(fileName);                                  //Create a new file that is located in the following directory
  
  try {
    //This try catch ensures that an error in finding/using the file does not crash the program

    Scanner fileReader = new Scanner(file);                        //Create a scanner to read from the file
    StringTokenizer st;                                            //Create a tokenizer to break each line into numbers that can be put as integers in our data array
  
    while (fileReader.hasNext()){
      //Loop through the entire file and add one to rows (rows acts as a counter for the number of rows)
      fileReader.nextLine();
      rows++;
    }
    
    fileReader.close(); 
    fileReader = new Scanner(file);                                //Close and then reopen the scanner to reset its cursor at the start of the file
    st = new StringTokenizer(fileReader.nextLine());
    cols = st.countTokens();                                       //Tokenize the first line (since each line has the same length it does not matter which one we use) 
                                                                   //  and then count the number of values in the line, that is our column length
    data = new int[rows][cols];                                    //Initialize the integer array with the lengths we just found
    
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        //Go through the entire line, setting the value in the file to a location in the data array
       data[i][j] = Integer.parseInt(st.nextToken()); 
      }
      if (i != rows - 1){                                          //As long as we are not at the last line in the file we want to tokenize the next line, if we did not have this 
                                                                   //  the program would attempt to tokenize a non-existant line after the final line in the file
        st = new StringTokenizer(fileReader.nextLine());
      } 
    }
    fileReader.close();                                            //Close the scanner
  } 
  catch (Exception e ) {
    //In case something goes wrong our code will not crash because we have this catch that lets the method return null
    println( "STEP 01 - Exception" );
    e.printStackTrace();
    data = null;
  }
  return data;
}
