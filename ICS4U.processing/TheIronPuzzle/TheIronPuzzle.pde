PImage img;

void setup() {
  
  size( 375, 500);
 
  img = loadImage("iron-puzzle.png");
  image(img, 0, 0);
  
  loadPixels();
  
  color c = pixels[0];
  
  float r, g, b;
  for (int i = 0; i < pixels.length; i++) {
    c = pixels[i];
    r = red(c);
    g = green(c);
    b = blue(c);
    
    //r = (int)(Math.random()*256);
    //g = (int)(Math.random()*256);
    //b = (int)(Math.random()*256);
    
    c = color(r*10, 0, 0);
    pixels[i] = c;
  }
  updatePixels();
}
