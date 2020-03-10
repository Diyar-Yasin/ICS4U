/**
 * Given a 2D array of elevation data create a image of size rows x cols,
 * drawing a 1x1 rectangle (or point) for each value in the array whose color is set to
 * a scaled gray value (0-255). Note: to scale the values in the array to
 * 0-255 you must find the min and max values in the original data first.
 *
 * @param g a Graphics context to use
 * @param grid a 2D array of the data
 */
 
public void drawMap( int[][] data ) { //Fix this, just remove static! no need to add void draw
   
   double min = data[0][0], max = data[0][0], b;
   int c;

  min = findMin(data);
  max = findMax(data);

  for (int i = 0; i < data.length; i++){
   for (int j = 0; j < data[0].length; j++){
     
      b = (data[i][j] - min)/(max - min);
      c =  (int) (b * 255.0); 
      
      noStroke();
      fill(c, c, c);
      rect(j, i, 1, 1);

   }
  }
 }
