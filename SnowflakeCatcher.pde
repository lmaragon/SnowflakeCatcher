SnowFlake [] storm;

void setup()
{
  size (400,400);
  background (0);
  storm = new SnowFlake[150];
  for (int i=0; i<storm.length; i++)
  {
    storm[i] = new SnowFlake();
  }
}
void draw()
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
void mouseDragged()
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
  void show()
  {
    noStroke();
    fill(255);
    ellipse(myX, myY, 10,10);
  }
  void lookDown()
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
  void erase()
  {
    noStroke();
    fill(0);
    ellipse(myX, myY, 12,12);
  }
  void move()
  {
    if (isMoving == true)
    {
      myX = myX + (int)(Math.random()*3)-1;
      myY = myY + 1;
    }
  }
  void wrap()
  {
    if (myY >410)
    {
      myY = -10;
      myX = (int)(random(400));
    }
  }
}


