class Jayce {
  PImage img;
  int x = width/2-40;
  int y = height/2+125;
  int change = 0;
  int i = 0;
  int jhealth = 100;
  public Jayce() {
    img = loadImage("jayce.png");
  }
  public void update() {
    if(x < 0-10 && change < 0) {
      change = 0;
    }
    if(x > width-100 && change > 0) {
      change = 0;
    }
    x += change;
    image(img,x,y);
    fill(255,0,0);
    rect(170,550,100,20);
    fill(0,255,0);
    rect(170,550,jhealth,20);
    fill(255);
  }
}