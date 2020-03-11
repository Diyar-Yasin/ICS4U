/**
 * MINIMUM VALUE
 *
 * @param data a 2D array from which you want to find the minimum value
 * @return the minimum value in the given 2D Array
 */
public static int findMin( int[][] data ) {

  int min = data[0][0];                                            //Set the min to  the first value in our array
                                                                   
  for (int i = 0; i < data.length; i++){
   for (int j = 0; j < data[0].length; j++){
    //For every value in the array, check if that value is smaller than our current min, if it is then set the min to the value
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

  int max = data[0][0];                                            //Set the max to  the first value in our array
  
  for (int i = 0; i < data.length; i++){
   for (int j = 0; j < data[0].length; j++){
     //For every value in the array, check if that value is larger than our current max, if it is then set the max to the value
    if (data[i][j] > max){
     max = data[i][j]; 
    }
   }
  }
  return max;
}
