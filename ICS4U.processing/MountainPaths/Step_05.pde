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

  noStroke();
  fill(255, 0, 0);
  rect(0, row, 1, 1);
  
  for(int col = 0; col != data[row].length - 1; col++){ //What if we check the boxes above or below and they do not exist because we are at corner of map?
    
    if (row == 0){
      opt1 = Math.abs(data[row+1][col+1] - data[row][col]);
      opt2 = Math.abs(data[row][col+1] - data[row][col]);
      
      
      minOpt = min(opt2, opt1);
      opt3 = minOpt + 1;
    }
    else if(row == data.length){
      opt3 = Math.abs(data[row-1][col+1] - data[row][col]);
      opt2 = Math.abs(data[row][col+1] - data[row][col]);
      
      minOpt = min(opt3, opt2);
      opt1 = minOpt + 1;
    }
    else{
      opt1 = Math.abs(data[row+1][col+1] - data[row][col]);
      opt2 = Math.abs(data[row][col+1] - data[row][col]);
      opt3 = Math.abs(data[row-1][col+1] - data[row][col]);
      
      minOpt = min(opt1, opt2, opt3);
    } 
    
    if (minOpt == opt2){
      elevChange = elevChange + opt2;
      rect(col+1, row, 1, 1);
    }
    else if (minOpt == opt1){ //No ramdomizer for last two opts!
      elevChange = elevChange + opt1;
      row++;
      rect(col+1, row, 1, 1);
    }
    else{
      elevChange = elevChange + opt3;
      row--;
      rect(col+1, row, 1, 1);
      
    }
    
  }
  
  return elevChange;
  
}
