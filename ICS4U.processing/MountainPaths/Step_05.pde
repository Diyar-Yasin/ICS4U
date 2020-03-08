/**
 * Find the minimum elevation-change route from West-to-East in the given
 * grid, from the given starting row, and draw it using the given graphics
 * context
 *
 * @param data - the 2D array of elevation values
 * @param row - the starting row for traversing to find the min path
 * @return total elevation of the route
 */

public int drawLowestElevPath( int[][] data, int row ) {
  
  int opt1, opt2, opt3, minOpt, elevChange = 0;
//For some reason, these lines are very jagged compared to other peoples', find out why

  stroke(0, 255, 0);
  rect(0, row, 1, 1);
  
  for(int col = 0; col != data[row].length - 1; col++){ //What if we check the boxes above or below and they do not exist because we are at corner of map?
    
    opt1 = data[row+1][col+1];
    opt2 = data[row][col+1];
    opt3 = data[row-1][col+1];
    
    minOpt = min(opt1, opt2, opt3);
    
    if (minOpt == opt1){
      elevChange = elevChange + Math.abs(data[row][col] - opt1);
      row = row + 1;
      rect(col+1, row, 1, 1);
    }
    else if (minOpt == opt2){
      elevChange = elevChange + Math.abs(data[row][col] - opt2);
      rect(col+1, row, 1, 1);
    }
    else{
      elevChange = elevChange + Math.abs(data[row][col] - opt3);
      row = row - 1;
      rect(col+1, row, 1, 1);
      
    }
    
  }
  
  return elevChange;
  
}
