/**
 * Given a 2D array of elevation data create a image of size rows x cols,
 * drawing a 1x1 rectangle (or point) for each value in the array whose color is set to
 * a scaled gray value (0-255). Note: to scale the values in the array to
 * 0-255 you must find the min and max values in the original data first.
 *
 * @param g a Graphics context to use
 * @param grid a 2D array of the data
 */
 
public void drawMap( int[][] data ) { 
   
   double min, max;
   int c;                                                          //An integer which holds the grayscaled color value
                                                                   
  min = findMin(data);
  max = findMax(data);                                             //Get the max and min value using the methods created in Step_02

  for (int i = 0; i < data.length; i++){
   for (int j = 0; j < data[0].length; j++){
     //For every data point do the below
     
      c = (int) (255.0 * (data[i][j] - min)/(max - min));           //This scaling will scale the max and min elevations as well as everything in between to values between 0 and 255, 
                                                                    //  the color range in processing. If data[i][j] is the max we get (max-min)/(max-min), which is 1, multiplied by 255 
                                                                    //  (the max value we can give it). If data[i][j] is the min we get (min-min)/(max-min), which is 0/(max-min), which is 0, 
                                                                    //  multiplied by 255 (giving us 0, the min value we can give
      noStroke();                                                   //Do not outline the rectangle (as the rectange will be 1x1 and you will not be able to see the color of the center of 
                                                                    //  the rectangle)
      fill(c, c, c);                                                //Fill the rectangle with the grayscaled color, making sure its the same for the red, green, and blue amount to ensure 
                                                                    //  it is white/black/gray color
      rect(j, i, 1, 1);                                             //Draw a rectangle at each coordinate in the array that is 1 x 1, it will be the color we filled above

   }
  }
 }
