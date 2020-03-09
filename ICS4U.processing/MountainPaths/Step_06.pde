/**
 * Generate all west-to-east paths, find the one with the lowest total
 * elevation change, and return the index of the row that path starts on.
 *
 * @param grid - the 2D array of elevation values
 * @return the index of the row where the lowest elevation-change path
 * starts.
 */
public  int indexOfLowestElevPath( int[][] data ) {
  
  int bestElevChange = drawLowestElevPath(data, 0, false), bestRow = 0, nextElevChange;
  
  noStroke();
  fill(255, 0, 0);
  
    for (int row = 1; row < data.length ; row++){
      nextElevChange = drawLowestElevPath(data, row, false);
      
      if (bestElevChange > nextElevChange){
       bestElevChange = nextElevChange; 
       bestRow = row;
      }
    }
  
  return bestRow;
  
}
