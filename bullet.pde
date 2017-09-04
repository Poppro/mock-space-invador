class bullet {
  int x, y;
  PImage img;
  public bullet(int x, int y) {
    this.x = x;
    this.y = y;
    
    int t = (int) random(3);
    if(t == 0) {
      img = loadImage("FAIAP.png");
    } else if(t == 1) {
      img = loadImage("AG.png");
    } else if(t == 2) {
      img = loadImage("salient.png");
    } else if(t == 3) {
      img = loadImage("gavin.png"); 
    } else if(t == 4) {
      img = loadImage("doggy.png");
    } else if(t == 5) {
      img = loadImage("kitty.png");
    }
  }
  void update() {
    y -= 3;
    image(img,x+50,y);
  }
}