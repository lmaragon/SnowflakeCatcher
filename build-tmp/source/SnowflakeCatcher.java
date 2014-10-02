import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] storm;

public void setup()
{
  size (400,400);
  background (0);
  storm = new SnowFlake[150];
  for (int i=0; i<storm.length; i++)
  {
    storm[i] = new SnowFlake();
  }
}
public void draw()
{
  //background(0);
  for (int i=0; i<storm.length; i++)
  {
    storm[i].erase();
    storm[i].lookDown();
    storm[i].move();
    storm[i].wrap();
    storm[i].show();
  }
}
public void mouseDragged()
{
  if (mouseButton == LEFT)
  {
  noStroke();
  fill(255,0,0);
  ellipse(mouseX,mouseY,10,10);
  }
  if (mouseButton == RIGHT)
  {
    noStroke();
    fill(0);
    ellipse(mouseX,mouseY,20,20);
  }
}

class SnowFlake
{
  int myX, myY;
  boolean isMoving;//class member variable declarations
  SnowFlake()
  {
    myX = (int)(random(400));
    myY = (int)(Math.random()*401)-400;
    isMoving = true;
  }
  public void show()
  {
    noStroke();
    fill(255);
    ellipse(myX, myY, 10,10);
  }
  public void lookDown()
  {
    if (myX>6 && myX<396 && myY>=0 && myY<394 && get(myX,myY+6) != color(0))
    {
      isMoving = false;
    }
    else 
    {
    isMoving = true;  
    }
  }
  public void erase()
  {
    noStroke();
    fill(0);
    ellipse(myX, myY, 12,12);
  }
  public void move()
  {
    if (isMoving == true)
    {
      myX = myX + (int)(Math.random()*3)-1;
      myY = myY + 1;
    }
    else if (isMoving == false)
    {
      if (get(myX+1,myY+80) == color(0))
      {
        myX++;
      }
      else if (get(myX-1,myY+80) == color(0))
      {
        myX--;
      }
    }
  }
  public void wrap()
  {
    if (myY >410)
    {
      myY = -10;
      myX = (int)(random(400));
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
