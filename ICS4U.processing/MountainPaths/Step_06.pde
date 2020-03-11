/**
 * Generate all west-to-east paths, find the one with the lowest total
 * elevation change, and return the index of the row that path starts on.
 *
 * @param grid - the 2D array of elevation values
 * @return the index of the row where the lowest elevation-change path
 * starts.
 */
public  int indexOfLowestElevPath( int[][] data ) {
  
  int bestElevChange = drawLowestElevPath(data, 0, false), bestRow = 0, nextElevChange;     //Set the best elevation change to the first rows paths elevation change, 
                                                                                            //  set the bestRow to this first row                                           
  noStroke();                                                                               //Do not outline the rectangle (as the rectange will be 1x1 and you will not be 
                                                                                            //  able to see the color of the center of the rectangle)
  fill(255, 0, 0);                                                                          //Fill the rectangle with red
  
    for (int row = 1; row < data.length ; row++){
      //for all of the row values do the following
      
      nextElevChange = drawLowestElevPath(data, row, false);                                //Set the next elevation change to the next rows elevation change
      
      if (bestElevChange > nextElevChange){                                                 //If the next elevation change is less than the best elevation change, set a new 
                                                                                            //  bestElevChange and set the best row to the current row
       bestElevChange = nextElevChange; 
       bestRow = row;
      }
    }
  
  return bestRow;                                                                           //Return the best row (to be drawn in Task 7, in the main)
  
}
