void setup(){
  
  // WINDOW SIZE
 size(600, 600);                                                                                    //Window size 600x600 pixels
 
 // SETUP
 noStroke();                                                                                        //Do not outline shapes
 rectMode( CENTER );                                                                                //Draw all boxes with x, y being their center
 
 // Start
 drawBox(width / 2, height / 2, width / 2, false);                                                  //Pass the box drawing method 3 dimensions and a false
                                                                                                    // which means no triangles are to be drawn yet
}

void drawBox(float x, float y, float sideLength, boolean triangle){
 
  // RANDOM COLOUR
  fill ( (int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256) );    //Choose a random colour from range 0-255 for all rgb values
  
  if (triangle){                                                                                     //If we are drawing a triangle pass it three vertices
  triangle(x, y, x + sideLength, y, x, y + sideLength);
  }                                
  else{                                                                                              //Otherwise draw a box
  rect(x, y, sideLength, sideLength);                  
  }
  
  if(sideLength / 2 > 10){                                                                           //As long as the the next smallest box/triangle we draw will not be smaller than
    // TOP LEFT - NEW TRIANGLE                                                                       // a sidelength of 10 we keep recurring
    drawBox( x - sideLength/2, y - sideLength/2, sideLength / 2, true);                              
    // TOP RIGHT - NEW TRIANGLE
    drawBox( x + sideLength/2, y - sideLength/2, sideLength / 2, true);                              //The top left and right are triangles (so we pass true) and the bottom left and right
    // BOTTOM LEFT - NEW BOX                                                                         // are boxes (so we pass false)
    drawBox( x - sideLength/2, y + sideLength/2, sideLength / 2, false);
    // BOTTOM RIGHT - NEW BOX
    drawBox( x + sideLength/2, y + sideLength/2, sideLength / 2, false);                             //For each new dimension we adjust by moving the y value down or up by sideLength/2
                                                                                                     // and adjust the x value left or right by adding/subtracting sideLength/2
                                                                                                     //The sideLength variable is also divided by 2 because it needs to be half the value
                                                                                                     // for the next recursion
  }
}
