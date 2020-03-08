/**
 * Find the minimum elevation-change route from West-to-East in the given
 * grid, from the given starting row, and draw it using the given graphics
 * context
 *
 * @param data - the 2D array of elevation values
 * @param row - the starting row for traversing to find the min path
 * @return total elevation of the route
 */

public static int drawLowestElevPath( int[][] data, int row ) {
  
  int col = 0, opt1, opt2, opt3, minOpt, elevChange;
//I need to draw the line while these calculations happen

  //while (col != data[row].length){ //What if we check the boxes above or below and they do not exist because we are at corner of map?
    
  //  col++;
    
  //  opt1 = data[row+1][col];
  //  opt2 = data[row][col];
  //  opt3 = data[row-1][col];
    
  //  minOpt = min(opt1, opt2, opt3);
    
  //  if (minOpt == opt1){
  //    elevChange = Math.abs(data[row][col-1] - opt1);
  //    row = row + 1;
  //  }
  //  else if (minOpt == opt2){
  //    elevChange = Math.abs(data[row][col-1] - opt2);
  //  }
  //  else{
  //    elevChange = Math.abs(data[row][col-1] - opt3);
  //    row = row - 1;
  //  }
    
  //}
  
  return -5;
  
}
