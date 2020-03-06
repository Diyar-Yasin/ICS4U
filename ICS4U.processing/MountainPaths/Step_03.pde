/**
 * Given a 2D array of elevation data create a image of size rows x cols,
 * drawing a 1x1 rectangle (or point) for each value in the array whose color is set to
 * a scaled gray value (0-255). Note: to scale the values in the array to
 * 0-255 you must find the min and max values in the original data first.
 *
 * @param g a Graphics context to use
 * @param grid a 2D array of the data
 */
 public static void drawMap( int[][] data ) {
   
   int min = data[0][0], max = data[0][0], c;
   color g;

  for (int i = 0; i < data.length; i++){
   for (int j = 0; j < data[0].length; j++){
    if (data[i][j] < min){
     min = data[i][j]; 
    }
    if (data[i][j] > max){
     max = data[i][j]; 
    }
   }
  }
  
  for (int i = 0; i < data.length; i++){
   for (int j = 0; j < data[0].length; j++){
     
      c = Math.round((data[i][j] - min)/(max - min) * 255);     
      g.setColor(new Color(c, c, c));
      g.fillRect(j,i,1,1);

      fill( c );
   }
  }

  
  
 }
