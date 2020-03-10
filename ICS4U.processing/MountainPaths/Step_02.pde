/**
 * MINIMUM VALUE
 *
 * @param data a 2D array from which you want to find the minimum value
 * @return the minimum value in the given 2D Array
 */
public static int findMin( int[][] data ) {

  int min = data[0][0];
  //Set the min to  the first value in our array
  
  for (int i = 0; i < data.length; i++){
   for (int j = 0; j < data[0].length; j++){
    if (data[i][j] < min){
     min = data[i][j]; 
    }
   }
  }
  
  return min;
  
}

/**
 * MAXIMUM VALUE
 *
 * @param data a 2D array from which you want to find the minimum value
 * @return the minimum value in the given 2D Array
 */
public static int findMax( int[][] data ) {

    int max = data[0][0];
  
  for (int i = 0; i < data.length; i++){
   for (int j = 0; j < data[0].length; j++){
    if (data[i][j] > max){
     max = data[i][j]; 
    }
   }
  }
  return max;
  
}
