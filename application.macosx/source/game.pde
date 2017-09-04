Jayce j;
Waldron w;
ArrayList<bullet> b = new ArrayList();
ArrayList<wBullet> bw = new ArrayList();
int i = 0;
boolean shoot = true;
int time = millis();

PImage img;
void setup() {
  j = new Jayce();
  w = new Waldron();
  size(400,600);
  img = loadImage("back.png");
  
}
void draw() {
  if(j.jhealth != 0) {
  background(img);
  j.update();
  w.update();
  if(time != 0) {
      if(millis() - time >= 1000) {
        shoot = true;
        time = millis();
      }
    }
  for(int n = 0; n < b.size(); n++) {
    if(b.get(n) != null) {
      b.get(n).update();
      if((b.get(n).x > w.x && b.get(n).x < w.x +120) && (b.get(n).y > w.y && b.get(n).y < w.y+152)) {
        w.health -= 10;
        b.remove(n);
      }
    }
  }
  for(int n = 0; n < bw.size(); n++) {
    if(bw.get(n) != null) {
      bw.get(n).update();
      if((bw.get(n).x > j.x+30 && bw.get(n).x < j.x +90) && (bw.get(n).y > j.y && bw.get(n).y < j.y+120)) {
        j.jhealth -= 25;
        bw.remove(n);
    }
  }
  }
    if(w.health == 0) {
      background(250,90,3);
    text("YOU WIN",width/2-150,height/2);
    }
  } else {
    
    text("GAME OVER",width/2-10,height/2);
  }
  
}

  void keyPressed() {
    if(key == 'd') {
      j.change = 3;
    } else if(key == 'a') {
      j.change = -3;
    }
    
    if(key == ' ' && shoot == true) {
      b.add(new bullet(j.x,j.y));
      i++;
      shoot = false;
    }
      
  }