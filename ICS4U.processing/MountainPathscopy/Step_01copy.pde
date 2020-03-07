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

  int[][] data;
  int rows = 0, cols;
  File file = new File("/Users/Diyar/Desktop/Diyar/School/Current/ICS4U-Diyar/ICS4U.processing/MountainPaths/data/" + fileName);

  try {

    // YOUR CODE
    Scanner fileReader = new Scanner(file);
    StringTokenizer st;
  
    while (fileReader.hasNext()){
      fileReader.nextLine();
      rows++;
    }
    
    fileReader.close(); 
    fileReader = new Scanner(file);
    st = new StringTokenizer(fileReader.nextLine());
    cols = st.countTokens();
    
    data = new int[rows][cols];
    
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
       data[i][j] = Integer.parseInt(st.nextToken()); 
      }
      if (i != rows - 1){
        st = new StringTokenizer(fileReader.nextLine());
      } 
    }
    fileReader.close();
  } 
  catch (Exception e ) {
    println( "STEP 01 - Exception" );
    e.printStackTrace();
    data = null;
  }
  return data;
}
