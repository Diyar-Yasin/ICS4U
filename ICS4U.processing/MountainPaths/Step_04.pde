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
  //Set the minimum value to the first value in the array and initialize the minIndex giving it the row value
  
  for (int i = 0; i < data.length; i++){
    //For every row, if the first value on the row is lower than the current min, set the first value as the new min and set the minIndex to the value's row
    //We need to get the value of min so that we can compare it for the next loop
    if (data[i][col] < min){
     min = data[i][col];
     minIndex = i; 
   }
  }

  return minIndex;
  //Return just the row of the minimum value
}
