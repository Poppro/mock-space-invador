class wBullet {
  int x, y, sy, sx;
  int movey, movex;
  PImage img;
  public wBullet(int x, int y, int sx, int sy) {
    this.x = x+50;
    this.y = y+152;
    this.sy = sy;
    this.sx = sx;
    
    movex = (int)((x - sx )* .01);
    movey = (int)((y - sy) * .01);
    
    int t = (int) random(3);
  }
  void update() {
    y -= movey;
    x -= movex;
    fill((int) random(256),(int) random(256),(int) random(256));
    rect(x,y,10,10);
    fill(255);
  }
}