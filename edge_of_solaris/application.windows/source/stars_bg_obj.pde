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

void update() {
  starX = starX + starSpeedX;
  starY = starY + starSpeedY;
  if (starX < 0) {
    starY = int(random(screenY));
    starX = screenX + 20;
    starSpeedX = int(-1 * (random(10) + 1));
  }
}

void reset() {
  starX = -200;
  starY = -200;
  starSpeedX = 0;
  starSpeedY = 0;
}

void display() {
  strokeWeight(10);
  stroke(255, 25);
  fill(255, (175 - (starSpeedX * 20)));
  ellipse(starX, starY, 5, 5);
}
}
