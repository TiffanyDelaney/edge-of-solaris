/* autogenerated by Processing revision 1277 on 2022-12-29 */
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

public class edge_of_solaris extends PApplet {

bullet[] blts;
enemy[] basicE;
starsBG[] stars;

 public void setup() {
  /* size commented out by preprocessor */;
  blts = new bullet[playerBulletCount];
  basicE = new enemy[basicECount];
  stars = new starsBG[starCount];
  initObjects();
}

 public void draw() {
  background(0);
  processInput();
  drawFrame();
  drawUI();
  if (screenIndex == 0) {
    basicE[0] = new enemy(500, 200, 0, 0, 0, 25, 25);
    basicE[1] = new enemy(400, 300, 0, 0, 0, 25, 25);
  }
  if (timing < 255) timing++;
}

 public void drawFrame() {
  if (screenIndex == 0) {
    for (starsBG stars : stars) {
      stars.update();
      stars.display();
    }
    for (enemy basicE : basicE) {
      basicE.collision();
      basicE.update();
      basicE.display();
    }
    for (bullet blts : blts) {
      blts.update();
      blts.display();
    }
    
    //draw player
    setRect(1);
    rect(playerX, playerY, 60, 20);
  } else if (screenIndex == 1) {
    resetObjects();
    
  }
}

 public void drawUI() {
  if (screenIndex == 0) {
  } else if (screenIndex == 1) {
    fill(200, 200, 255, 120);
    textSize(136);
    text("Edge Of Solaris", 200, 120);
    fill(200, 200, 255, 255);
    textSize(128);
    text("Edge Of Solaris", 200, 120);
  }
}

 public void setRect(int colorIndex) {
  if (colorIndex == 0) {
    strokeWeight(1);
    noStroke();
    fill(0);
  } else if (colorIndex == 1) {
    strokeWeight(1);
    noStroke();
    fill(255);
  }
}

 public void initObjects() {
  for (int i = 0; i < playerBulletCount; i++) {
    blts[i] = new bullet(-20, -20, 0, 0, 0, 0, 0);
  }
  for (int i = 0; i < basicECount; i++) {
    basicE[i] = new enemy(-200, -200, 0, 0, 0, 0, 0);
  }
  for (int i = 0; i < starCount; i++) {
    stars[i] = new starsBG(PApplet.parseInt(random(1300)), PApplet.parseInt(random(720)), PApplet.parseInt(-1 * (random(10) + 1)), 0);
  }
}

 public void resetObjects() {
    for (starsBG stars : stars) {
      stars.reset();
    }
    for (enemy basicE : basicE) {
      basicE.reset();
    }
    for (bullet blts : blts) {
      blts.reset();
    }
}
class bullet {
  int bulletX;
  int bulletY;
  int bulletSpeedX;
  int bulletSpeedY;
  int bulletType;
  int bulletHitX;
  int bulletHitY;

bullet(int bulletXtemp, int bulletYtemp, int bulletSpeedXtemp, int bulletSpeedYtemp, int bulletTypetemp, int bulletHitXtemp, int bulletHitYtemp) {
  bulletX = bulletXtemp;
  bulletY = bulletYtemp;
  bulletSpeedX = bulletSpeedXtemp;
  bulletSpeedY = bulletSpeedYtemp;
  bulletType = bulletTypetemp;
  bulletHitX = bulletHitXtemp;
  bulletHitY = bulletHitYtemp;
}

 public void update() {
  bulletX = bulletX + bulletSpeedX;
  bulletY = bulletY + bulletSpeedY;
}

 public void reset() {
  bulletX = -20;
  bulletY = -20;
  bulletSpeedX = 0;
  bulletSpeedY = 0;
  bulletType = 0;
  bulletHitX = 0;
  bulletHitY = 0;
}

 public void explode() {
}

 public void display() {
  if (bulletType == 0) {
    stroke(20, 20, 200, 120);
    strokeWeight(2);
    fill(20, 20, 200);
    ellipse(bulletX, bulletY, bulletHitX, bulletHitY);
  }
  if (bulletType == 4) {
    stroke(255, 120);
    strokeWeight(10);
    fill(255);
    ellipse(bulletX, bulletY, bulletHitX, bulletHitY);
  }
}
}
class enemy {
  int enemyX;
  int enemyY;
  int enemySpeedX;
  int enemySpeedY;
  int enemyType;
  int enemyHitX;
  int enemyHitY;

enemy(int enemyXtemp, int enemyYtemp, int enemySpeedXtemp, int enemySpeedYtemp, int enemyTypetemp, int enemyHitXtemp, int enemyHitYtemp) {
  enemyX = enemyXtemp;
  enemyY = enemyYtemp;
  enemySpeedX = enemySpeedXtemp;
  enemySpeedY = enemySpeedYtemp;
  enemyType = enemyTypetemp;
  enemyHitX = enemyHitXtemp;
  enemyHitY = enemyHitYtemp;
}

 public void update() {
  enemyX = enemyX + enemySpeedX;
  enemyY = enemyY + enemySpeedY;
}

 public void collision() {
  for (int i = 0; i < playerBulletCount; i++) {
    if (enemyX - (enemyHitX / 2) <= blts[i].bulletX - (blts[i].bulletHitX / 2)) {
      //println(( enemyX + (enemyHitX / 2)) + " + " + (blts[i].bulletX +  (blts[i].bulletHitX / 2)));
      if ((enemyX + (enemyHitX / 2)) >= (blts[i].bulletX - (blts[i].bulletHitX / 2))) {
        if (enemyY - (enemyHitY / 2) <= blts[i].bulletY - (blts[i].bulletHitY / 2)) {
          if ((enemyY + (enemyHitY / 2)) >= (blts[i].bulletY - (blts[i].bulletHitY / 2))) {
            enemyType = 4;
            if (blts[i].bulletType == 0) blts[i].reset();
          }
        }
      }
    }
  }
}

 public void reset() {
  enemyX = -250;
  enemyY = -250;
  enemySpeedX = 0;
  enemySpeedY = 0;
  enemyType = 0;
  enemyHitX = 0;
  enemyHitY = 0;
}

 public void display() {
  strokeWeight(1);
  noStroke();
  fill(255, 0, 0);
  if (enemyType == 4) fill(0, 255, 0);
  ellipse(enemyX, enemyY, 25, 25);
}
}
 public void processInput() {
  if (screenIndex == 0) {
      if (keyInput[0] == true) { //w
        playerY = playerY - playerMoveY;
      }
      if (keyInput[1] == true) { //s
        playerY = playerY + playerMoveY;
      }
      if (keyInput[2] == true) { //d
        playerX = playerX + playerMoveX;
      }
      if (keyInput[3] == true) { //a
        playerX = playerX - playerMoveX;
      }
      if (keyInput[4] == true) { //space
        playerShoot();
      }
      if (keyInput[5] == true) { //q, prev weapon
        playerWeapon = 0;
      }
      if (keyInput[6] == true) { //q, next weapon
        playerWeapon = 4;
      }
  }
}

 public void keyPressed() {
  if (key == 'w' || key == 'W')  keyInput[0] = true;
  if (key == 's' || key == 'S')  keyInput[1] = true;
  if (key == 'd' || key == 'D')  keyInput[2] = true;
  if (key == 'a' || key == 'A')  keyInput[3] = true;
  if (key == ' ') keyInput[4] = true;
  if (key == 'q' || key == 'Q')  keyInput[5] = true;
  if (key == 'e' || key == 'E')  keyInput[6] = true;
}

 public void keyReleased() {
  if (key == 'w' || key == 'W')  keyInput[0] = false;
  if (key == 's' || key == 'S')  keyInput[1] = false;
  if (key == 'd' || key == 'D')  keyInput[2] = false;
  if (key == 'a' || key == 'A')  keyInput[3] = false;
  if (key == ' ') keyInput[4] = false;
  if (key == 'q' || key == 'Q')  keyInput[5] = false;
  if (key == 'e' || key == 'E')  keyInput[6] = false;
}

 public void playerShoot() {
  if (playerWeapon == 0) { //machine gun
    if (timing > 5) {
    blts[playerBulletIndex] = new bullet(playerX + 55, playerY + 18, 5, 0, playerWeapon, 5, 5);
    playerBulletIndex++;
    if (playerBulletIndex == playerBulletCount) playerBulletIndex = 0;
    timing = 0;
    }
  }
  if (playerWeapon == 4) { //sniper shot
    if (timing > 30) {
    blts[playerBulletIndex] = new bullet(playerX + 55, playerY + 18, 25, 0, playerWeapon, 50, 5);
    playerBulletIndex++;
    if (playerBulletIndex == playerBulletCount) playerBulletIndex = 0;
    timing = 0;
    }
  }
}
class starsBG {
  int starX;
  int starY;
  int starSpeedX;
  int starSpeedY;

starsBG(int starXtemp, int starYtemp, int starSpeedXtemp, int starSpeedYtemp) {
  starX = starXtemp;
  starY = starYtemp;
  starSpeedX = starSpeedXtemp;
  starSpeedY = starSpeedYtemp;
}

 public void update() {
  starX = starX + starSpeedX;
  starY = starY + starSpeedY;
  if (starX < 0) {
    starY = PApplet.parseInt(random(720));
    starX = 1300;
    starSpeedX = PApplet.parseInt(-1 * (random(10) + 1));
  }
}

 public void reset() {
  starX = -200;
  starY = -200;
  starSpeedX = 0;
  starSpeedY = 0;
}

 public void display() {
  fill(255);
  ellipse(starX, starY, 5, 5);
}
}
//game vars
int screenIndex = 0;
int playerBulletCount = 200;
int basicECount = 2;
int starCount = 300;
int timing = 0;

//player vars
int playerX = 200;
int playerY = 250;
int playerMoveX = 2;
int playerMoveY = 2;
int playerWeapon = 0;
int playerBulletIndex = 0;

//input vars
boolean keyInput[] = new boolean [15];


  public void settings() { size(1280, 720); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "edge_of_solaris" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
