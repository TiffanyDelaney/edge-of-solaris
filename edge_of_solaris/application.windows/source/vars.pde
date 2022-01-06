//game vars
int screenIndex = 0; //0 = game, 1 = title, 2 = level select, 3 = visual novel story stuff
int levelIndex = 0; //what level the player is playing, 0 is test level
boolean enemiesPlaced = false; //used to only place enemies once per level load
int bulletCount = 500;
int basicECount = 20;
int starCount = 300;
int timing = 0;
int screenX = 1280;
int screenY = 720;

//player vars
float playerX = 200;
float playerY = 250;
int playerHitX = 30;
int playerHitY = 7;
int playerMoveX = 3;
int playerMoveY = 3;
int playerWeapon = 0;
int playerState = 0; //0 = normal, 1 = hurt
int bulletIndex = 0;
float playerShield = 20;
float playerShieldMax = 100;
float playerShieldRegen = 0.5;
float playerHP = 50;
float playerHPMax = 100;

//input vars
boolean keyInput[] = new boolean [15];

//visual novel vars
int eventIndex = 0; //index value for events
int textIndex = 0; //index value for which line of dialogue should be displayed
int bgIndex = 0; //background index
int textTiming = 0; //used for rendering each letter individually, ie it looks like its being typed out
String[] textLines = new String[99]; //used for each line of dialogue

//animation timing vars
int playerEngineTimer = 0;
