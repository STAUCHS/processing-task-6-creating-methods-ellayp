import processing.core.PApplet;

public class Sketch extends PApplet {

	/**
   * The program Sketch.java takes a program from a previous processing task and creates a method 
   * with parameters to draw a composite object 
   * (consisting of various shapes at various locations specified by the method parameters).
   * Then, takes another method with parameters to draw a composite object at various locations 
   * specified by the method parameters.
   * The method also includes additional parameters to modify the object(s) drawn in the method.
   * Finally, the program uses a demonstration of methods with parameters and a return value. 
   */

  /**
   * Called once at the beginning of execution
   * Size call in this method
   */
  public void settings() {
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution. 
   * Initial set up values here 
   * i.e background, stroke weight.
   */
  public void setup() {
    background(214, 245, 255);
    strokeWeight(4);
  }

  /**
   * Called repeatedly, everything drawn to the screen
   */
  public void draw() {
    // The x and y coordinates of the happy face (location).
    drawHappyFace (200, 200);
    drawHappyFace (85, 60);
    drawHappyFace (315, 60);
    drawHappyFace (85, 340);
    drawHappyFace (315, 340);

    // The x and y coordinates of the four flowers (locations) and the colours of the four flowers.
    drawFlower(200, 110, 231, 221, 255);
    drawFlower(200, 350, 248, 192, 106);
    drawFlower(85, 225, 0, 128, 0);
    drawFlower(315, 225, 250, 240, 162);
  }

  /**
   * Calculates the colour, shape, and size of the eyes, mouth, and head of the happy face.
   * @param floatX the X value
   * @param floatY the Y value
   * @author: E. Yap
   */
  private void drawHappyFace (float floatX, float floatY) {
    if (floatX > 200 && floatY > 200) {
      fill (231, 221, 255);
    }
    else if (floatX < 200 && floatY < 200) {
      fill (248, 192, 106);
    }
    else if (floatX < 200 && floatY > 200) {
      fill (250, 240, 162);
    }
    else if (floatX > 200 && floatY < 200) {
      fill (0, 128, 0);
    }
    else {
      fill (240, 210, 209);
    }

    // Calculates the dimensions and colour of the happy face.
    ellipse (floatX, floatY, 70, 70); // Circular head
    ellipse (floatX - 10, floatY - 10, 10, 10); // Left eye
    ellipse (floatX + 10, floatY - 10, 10, 10); // Right eye
    
    fill (170);
    arc (floatX, floatY + 5, 40, 30, 0, PI);
    line (floatX - 20, floatY + 5, floatX + 20, floatY + 5);
  }

  /**
   * Calculates the dimensions of the flower.
   * @param floatX the X value
   * @param floatY the Y value
   * @param intRed the amount of red colour
   * @param intGreen the amount of green colour
   * @param intBlue the amount of blue colour
   * @author: E. Yap
   */
  private void drawFlower (float floatX, float floatY, int intRed, int intGreen, int intBlue) {
    // Calculating the dimensions of the rectangular flower stem and using parameters to decide the outputted colour.
    rect (floatX - 5, floatY - 50, 10, 85); // Flower stem
    fill (intRed, intGreen, intBlue);

    // Four flower petals
    ellipse (floatX, floatY - 35, 40, 40); // Bottom flower petal
    ellipse (floatX, floatY - 85, 40, 40); // Top flower petal
    ellipse (floatX - 25, floatY - 60, 40, 40); // Left flower petal
    ellipse (floatX + 25, floatY - 60, 40, 40); // Right flower petal

    // Center of flower
    ellipse(floatX, floatY - 60, 40, 40);
  }

  /**
   * Captures the x and y coordinates of the mouse click,
   * passes these values to the boolean method,
   * and if true is returned, two ears are drawn on the center happy face.
   */
  public void mouseClicked() {
    // Declare variables
    int intX = mouseX; 
    int intY = mouseY;
    boolean blnCenter = center (intX, intY);

    // Draws ears on center happy face if true
    if (blnCenter == true) {
      fill (240, 210, 209);
      ellipse (180, 170, 20, 20); // Left ear
      ellipse (220, 170, 20, 20); // Right ear
    }
  }

  /**
   * Calculates if the mouse was clicked in the center face.
   * @param intX the X value of the mouse click
   * @param intY the Y value of the mouse click
   * @return boolean blnValue
   * @author: E. Yap
   */
  private boolean center (int intX, int intY) {
    boolean blnValue = false;
      if (intX > 170 && intX < 230 && intY > 170 && intY < 230) {
        blnValue = true;
      }
      return blnValue;
  }
}