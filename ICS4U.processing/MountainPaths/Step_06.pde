/**
 * Generate all west-to-east paths, find the one with the lowest total
 * elevation change, and return the index of the row that path starts on.
 *
 * @param grid - the 2D array of elevation values
 * @return the index of the row where the lowest elevation-change path
 * starts.
 */
public  int indexOfLowestElevPath( int[][] data ) {
  
  int bestRow = 0;
  noStroke();
  fill(255, 0, 0);
  
  for (int row = 0; row < data.length; row++){
    for (int col = 0; col < data[0].length; col++){
      drawLowestElevPath( data, row);
    }
  }
  
  return -6;
  
}
