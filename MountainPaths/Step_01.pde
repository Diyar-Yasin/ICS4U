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
 
public static int[][] readData( String fileName ) {

  int[][] data;
  int rows = 0, cols;
  Scanner fileReader = new Scanner(fileName);
  StringTokenizer st;
  
  try {

    // YOUR CODE
    while (fileReader.hasNextLine()){
      fileReader.nextLine();
      rows++;
    }
    
    fileReader = new Scanner(fileName);
    st = new StringTokenizer(fileReader.nextLine());
    cols = st.countTokens();
    
    System.out.println(rows + " " + cols);
    //Giving me 1 1 why? 
    data = new int[rows][cols];
    
    
  } 
  catch (Exception e ) {
    println( "STEP 01 - Exception" );
    e.printStackTrace();
    data = null;
  }

  return data;
}
