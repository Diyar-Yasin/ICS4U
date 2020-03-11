/**
 * Find the minimum elevation-change route from West-to-East in the given
 * grid, from the given starting row, and draw it using the given graphics
 * context
 *
 * @param data - the 2D array of elevation values
 * @param row - the starting row for traversing to find the min path
 * @return total elevation of the route
 */

public int drawLowestElevPath( int[][] data, int row, boolean bestPath ) {
  
  int opt1, opt2, opt3, minOpt, elevChange = 0;
  //3 options, with at least one of them being a minimum and the elevation change of the path we take

  noStroke();
  //Do not outline the rectangle (as the rectange will be 1x1 and you will not be able to see the color of the center of the rectangle)
  
  if (bestPath){
    //If we pass true, which is only done in TASK 7 in the main method, then we are drawing the best path and it must be green so fill(0, max green color, 0)
    fill(0, 255, 0);
  }
  else{
    //Otherwise we are just drawing a normal line so it will be read, fill(max red, 0, 0)
      fill(255, 0, 0);
  }
  rect(0, row, 1, 1);
  //Draw the first rectangle at x = 0 and the row (y), 1x1 as usual
  
  for(int col = 0; col != data[row].length - 1; col++){ 
    //For x value, as long as that x value is not the last x value in the image perform the following
    
    if (row != 0 && row != data.length - 1){
      //If the row is between the first and last rows (meaning there is a value above and below our position) do the following
      
      opt1 = Math.abs(data[row+1][col+1] - data[row][col]);
      //Option 1 is the bottom right path
      opt2 = Math.abs(data[row][col+1] - data[row][col]);
      //Option 2 is the middle right path
      opt3 = Math.abs(data[row-1][col+1] - data[row][col]);
      //Option 3 is the top right path
      
      
      minOpt = min(opt1, opt2, opt3);      
      //Find the minimum elevation change from our current position to each of the 3 options and set it to our minOpt
    }
    else if (row == 0){
      //Otherwise, if we are at row 0, there is no row above us so option 3 (the top right path) should not be considered
      opt1 = Math.abs(data[row+1][col+1] - data[row][col]);
      opt2 = Math.abs(data[row][col+1] - data[row][col]);
      
      
      minOpt = min(opt2, opt1);
      //Find the minimum between the possible options
      opt3 = minOpt + 1;
      //Set the impossible option to the minimum value + 1, so that when we use if statements to check which opt is equal to the minOpt it will never be this
    }
    else {
      //If we aren't at the first row or any row in between the array, we must be at the last row, meaning the opt at the bottom right (opt1) should not be considered
      opt3 = Math.abs(data[row-1][col+1] - data[row][col]);
      opt2 = Math.abs(data[row][col+1] - data[row][col]);
      
      minOpt = min(opt3, opt2);
      //Find the minimum between the possible options
      opt1 = minOpt + 1;
      //Set the impossible option to the minimum value + 1, so that when we use if statements to check which opt is equal to the minOpt it will never be this
    }
    
    //Now that we have found the minimum possible elevation change route we can take and have accounted for our location in the array, we want to draw the line and add to our elevChange
    //elevation counter, but we do not know which option minOpt is. We need if statements to check
    if (minOpt == opt2){
      //If the middle option is the minimum, regardless of what the top and bottom paths are, we want to take the middle path
      
      elevChange = elevChange + opt2;
      //Add the elevation change of option 2 to elevChange
      rect(col+1, row, 1, 1);
      //Draw a rectangle at the same y value and the x value to the right of where we are
    }
    else if (opt1 == opt3){
      //If the middle path is not the minimum, options 1 or 3 must be the minimum, if they are the same then we must randomly choose either or
      
      if ((int) Math.round(Math.random()) == 1){
        //This generates a value of either 0 or 1, if its 1 we will take the bottom path otherwise take the top path
        
        elevChange = elevChange + opt1;
        //Add to our elevation
        row++;
        //Going down a row (by adding 1 to our row, ie y value)
        rect(col+1, row, 1, 1);
        //Draw a rectangle at that y value and the x value to the right of where we are
      }
      else {
        elevChange = elevChange + opt3;
        //Add to our elevation
        row--;
        //Going up a row (by subtracting 1 from our row, ie y value)
        rect(col+1, row, 1, 1);
        Draw a rectangle at that y value and the x value to the right of where we are
      }
    }
    else if (minOpt == opt1){
      //If the middle path is not the minimum and the top andd bottom path are not the same (so they are not both the minimum)
      //we ask if option 1 is the minimum
      
      elevChange = elevChange + opt1;
      //Add to our elevation
      row++;
      //Going down a row (by adding 1 to our row, ie y value)
      rect(col+1, row, 1, 1);
      //Draw a rectangle at that y value and the x value to the right of where we are
    }
    else{
      //Otherwise option 3 must be the minimum values
      
      elevChange = elevChange + opt3;
      //Add to our elevation
      row--;
      //Going up a row (by subtracting 1 from our row, ie y value)
      rect(col+1, row, 1, 1);
      //Draw a rectangle at that y value and the x value to the right of where we are
      
    }
    
  }
  
  return elevChange;
  //Return our elevation change after drawing the entire line
  
}
