void processInput() {
  if (screenIndex == 0 && paused == false) {
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
      if (keyInput[7] == true) { //q, next weapon
        playerWeapon = 1;
      }
      if (keyInput[8] == true) { //p, pause game
        paused = true;
        keyInput[8] = false;
      }
  } else if (screenIndex == 0 && paused == true) { //if game is paused
        if (keyInput[8] == true) { //p, unpause game
          paused = false;
          keyInput[8] = false;
        }
  } else if (screenIndex == 1) {
    if (keyInput[4] == true) screenIndex = 2;
  } else if (screenIndex == 2) {
    if (keyInput[0] == true) {
      screenIndex = 0;
      initObjects();
    }  
  } else if (screenIndex == 3) {
    if (keyInput[4] == true) {
      textIndex++;
      if (scanVNCommands() == 0) {//load level
          levelStart(); //load a level
      }
      /*
      if (textIndex == 10) { //when to switch to level 0
        levelIndex = 0;
        screenIndex = 0;
        initObjects();
        enemiesPlaced = false;
      } else if (textIndex == 15) { //when to switch to level 1
        levelIndex = 1;
        screenIndex = 0;
        initObjects();
        enemiesPlaced = false;
      }
      */
      keyInput[4] = false;
    }
  }
}

void keyPressed() {
  if (key == 'w' || key == 'W')  keyInput[0] = true;
  if (key == 's' || key == 'S')  keyInput[1] = true;
  if (key == 'd' || key == 'D')  keyInput[2] = true;
  if (key == 'a' || key == 'A')  keyInput[3] = true;
  if (key == ' ') keyInput[4] = true;
  if (key == 'q' || key == 'Q')  keyInput[5] = true;
  if (key == 'e' || key == 'E')  keyInput[6] = true;
  if (key == 'r' || key == 'R')  keyInput[7] = true;
  if (key == 'p' || key == 'P')  keyInput[8] = true;
}

void keyReleased() {
  if (key == 'w' || key == 'W')  keyInput[0] = false;
  if (key == 's' || key == 'S')  keyInput[1] = false;
  if (key == 'd' || key == 'D')  keyInput[2] = false;
  if (key == 'a' || key == 'A')  keyInput[3] = false;
  if (key == ' ') keyInput[4] = false;
  if (key == 'q' || key == 'Q')  keyInput[5] = false;
  if (key == 'e' || key == 'E')  keyInput[6] = false;
  if (key == 'r' || key == 'R')  keyInput[7] = false;
  if (key == 'p' || key == 'P')  keyInput[8] = false;
}

void playerShoot() {
  if (playerWeapon == 0) { //machine gun
    if (timing > playerWeaponCooldown0) {
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY, 10, 0, playerWeapon, 10, 10, playerWeaponPower0);
      timing = 0;
    }
  } else if (playerWeapon == 1) { //spread shot
    if (timing > playerWeaponCooldown1) {
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY, 10, 0, playerWeapon, 10, 10, playerWeaponPower1);
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY, 10, 1, playerWeapon, 10, 10, playerWeaponPower1);
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY, 10, 2, playerWeapon, 10, 10, playerWeaponPower1);
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY, 10, -2, playerWeapon, 10, 10, playerWeaponPower1);
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY, 10, -1, playerWeapon, 10, 10, playerWeaponPower1);
      timing = 0;
    }
  } else if (playerWeapon == 2) { //dual beam cannon
      if (timing > playerWeaponCooldown2) {
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY + 7, 20, 0, playerWeapon, 80, 10, playerWeaponPower2);
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY - 7, 20, 0, playerWeapon, 80, 10, playerWeaponPower2);
      timing = 0;
    }
  } else if (playerWeapon == 4) { //sniper shot
      if (timing > playerWeaponCooldown4) {
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY, 25, 0, playerWeapon, 100, 5, playerWeaponPower4);
      timing = 0;
    }
  }
  if (playerSecondWeapon == 0) { //basic secondary missile
    if (secondTiming > playerWeaponCooldown100) {
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY, -10, +10, playerSecondWeapon + 100, 20, 10, playerWeaponPower100);
      blts[findBullet()] = new bullet(playerX + playerBulletOffsetX, playerY + playerBulletOffsetY, -10, -10, playerSecondWeapon + 100, 20, 10, playerWeaponPower100);
      secondTiming = 0;
    }
  }
}
