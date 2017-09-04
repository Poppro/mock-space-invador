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

public class game extends PApplet {

Jayce j;
Waldron w;
ArrayList<bullet> b = new ArrayList();
ArrayList<wBullet> bw = new ArrayList();
int i = 0;
boolean shoot = true;
int time = millis();

PImage img;
public void setup() {
  j = new Jayce();
  w = new Waldron();
  
  img = loadImage("back.png");
  
}
public void draw() {
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

  public void keyPressed() {
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
  
  public void update() {
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
  public void update() {
    y -= 3;
    image(img,x+50,y);
  }
}
class wBullet {
  int x, y, sy, sx;
  int movey, movex;
  PImage img;
  public wBullet(int x, int y, int sx, int sy) {
    this.x = x+50;
    this.y = y+152;
    this.sy = sy;
    this.sx = sx;
    
    movex = (int)((x - sx )* .01f);
    movey = (int)((y - sy) * .01f);
    
    int t = (int) random(3);
  }
  public void update() {
    y -= movey;
    x -= movex;
    fill((int) random(256),(int) random(256),(int) random(256));
    rect(x,y,10,10);
    fill(255);
  }
}
  public void settings() {  size(400,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "game" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
