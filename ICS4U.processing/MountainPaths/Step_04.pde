/**
 * Search a single column of a 2D array and return the index of the row that
 * contains the smallest value
 *
 * @param grid a 2D array
 * @col the column in the 2D array to process
 * @return the index of smallest value from grid at the given col
 */
public static int indexOfMinInCol(int[][] data, int col) {
  
  int min = data[0][0], minIndex = 0;
  
  for (int i = 0; i < data.length; i++){
    if (data[i][col] < min){
     min = data[i][col];
     minIndex = i; 
   }
  }

  return minIndex;
}
