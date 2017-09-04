class Waldron {
  PImage img;
  int x = width/2 - 50;
  int y = 0;
  int xvel = 0;
  int yvel = 0;
  int health = 300;
  int time2 = millis();
  
  public Waldron() {
    img = loadImage("waldron.png");
  }
  
  void update() {
    int t = (int) random(4);
    int s = (int) random(4);
    if(t == 0 && x < width+100) {
      xvel += s;
    }
    if(t == 1 && x > 100) {
      xvel -= s;
    }
    if(t == 2 && y < 10) {
      y += 1;
    }
    if(t == 3 && y > 0) {
      y-= 1;
    }
    if(xvel > 7) {
      xvel = 7;
    }
    x += xvel;
        
    //bullets
    if(time2 != 0) {
      if(millis() - time2 >= 1000) {
        bw.add(new wBullet(x,y,j.x,j.y));
        time2 = millis();
      }
    }
   
    image(img, x, y);
    
    if(health < 0) {
      health = 0;
    }
    fill(255,0,0);
    rect(50,10,300,20);
    fill(0,255,0);
    rect(50,10,health,20);
    fill(255);
    
  }
}