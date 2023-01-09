///////////////////////////////////////////////////////
//

// Title: WalkingSim
// Course: CS300 Fall 2022
//
// Author: Zhuoyu Jiang
// Email: zjiang299@wisc.edu
// Lecturer: Mouna
//
//////////////////////////////////////////////////////////
// None Pair Programming and Outside Help
////////////////////////////////////////////////////////////

import java.util.Random;
import java.io.File;
import processing.core.PImage;

public class WalkingSim {
  //add four private static fields at the top of the class
  private static Random randGen;
  private static int bgColor;
  private static PImage[] frames;
  private static Walker[] walkers;//4.2.1

  public static void main (String[] args) {

    Utility.runApplication();//start application

  }

  //// setup
  public static void setup() {
    System.out.println("setup");

    randGen = new Random();
    bgColor = randGen.nextInt();

    walkers = new Walker[Walker.NUM_FRAMES];
    frames = new PImage[Walker.NUM_FRAMES];
    for (int i = 0; i < Walker.NUM_FRAMES; i++) {
      frames[i] = Utility.loadImage("images" + File.separator + "walk-" + i + ".png");
    }
    int w = (int) (Math.random() * 8) + 1; 
    for (int j = 0; j < w; j++) {
      Random random = new Random();
      //a number between 0-50
      
        int x = random.nextInt(Utility.width()-frames[0].width-10) + frames[0].width; 
      int y = random.nextInt(Utility.height() - frames[0].height *2); //4.3.1?
      walkers[j] = new Walker(x, y);
    }


    }
    private static Walker[] Walker() {
    // TODO Auto-generated method stub
    return null;
  }
    public static void draw() {
      Utility.background(bgColor);
      for (int i = 0; i < walkers.length; i++) {
        if (walkers[i] != null) {//4.3.1
          //if (isMouseOver(walkers[i])) {
          //  walkers[i].setWalking(true);
            if (walkers[i].isWalking()) {
              walkers[i].setPositionX(walkers[i].getPositionX()+3);
              if (walkers[i].getPositionX() > Utility.width()) {
                walkers[i].setPositionX(0);
              }
              walkers[i].update();
            }
          //}
          Utility.image(frames[walkers[i].getCurrentFrame()], 
              walkers[i].getPositionX(), walkers[i].getPositionY());
        }
      }

    }
    public static boolean isMouseOver(Walker walker) {
      //if (Utility.mouseX() == walker.getPositionX() && Utility.mouseY() == walker.getPositionY()) {
        if (Utility.mouseX() >= walker.getPositionX() - 30 && Utility.mouseX() <= 
            walker.getPositionX() + 30 && Utility.mouseY() >= walker.getPositionY() - 
            70 && Utility.mouseY() <= walker.getPositionY() + 70) {
        return true;
      }
      return false;
      }

    public static void mousePressed() {
      for (int i = 0; i < walkers.length; i++) {
        if (walkers[i] != null) {
          if (isMouseOver(walkers[i])) {
            walkers[i].setWalking(true);
          }
          //if (isMouseOver(walkers[i])) {
          //  walkers[i].setWalking(true);
          //  if (walkers[i].isWalking()) {
          //    walkers[i].setPositionX(walkers[i].getPositionX()+3);
          //  }
          //  walkers[i].update();
          //}
        }
      }
      //draw();
    }

  public static void keyPressed(char c) {
    if (c == 'a'|| c == 'A') {
      System.out.println("A");
        for (int j = 0; j < walkers.length; j++) {
          if (walkers[j] == null) {
            Random random = new Random();
            int x = random.nextInt(Utility.width()-frames[0].width-10) + frames[0].width;
            int y = random.nextInt(Utility.height() - frames[0].height *2);
            walkers[j] = new Walker(x, y);
          }

      }


    }
    if (c == 's'|| c == 'S') {
        System.out.println("S");
      for (int i = 0; i < walkers.length; i++) {
        if (walkers[i] != null) {
            walkers[i].setWalking(false);
        }
      }
    }
  }

}


