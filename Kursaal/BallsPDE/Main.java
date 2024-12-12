ArrayList<Ball> balls = new ArrayList<>();
int initialBalls = 10;
int points = 0;
int[] milestones = {50, 100};

void setup() {
  size(800, 500);
  frameRate(60);

  fill(255);
  textSize(50);
  textAlign(CENTER);

  for (int i = 0; i < initialBalls; i++) {
    addBall();
  }
}

Ball actualBall = null;
boolean gameEnded = false;
int nextMilestone = 0;

void draw() {
  background(0);

  text(points, width/2, height/10);
  handleBallMove();

  for (Ball ball : balls) {
    ball.move();
    ball.collide(balls.toArray(new Ball[0]));
    ball.show();
  }

  if (!gameEnded && milestones[nextMilestone] == points) {
    addBall();
    nextMilestone++;

    if (milestones.length == nextMilestone) {
      fill(#FFDE21);
      gameEnded = true;
    }
  }

}

void handleBallMove() {
  if (mousePressed) {
    if (actualBall == null) {
      for (Ball b : balls) {
        boolean clickedX = pmouseX > b.x - b.radius && pmouseX < b.x + b.radius;
        boolean clickedY = pmouseY > b.y - b.radius && pmouseY < b.y + b.radius;

        if (clickedX && clickedY) actualBall = b;
      }
    }

    if (actualBall != null) {
      actualBall.x = mouseX;
      actualBall.y = mouseY;

      actualBall.xSpeed = 0;
      actualBall.ySpeed = 0;
    }

  } else if (actualBall != null) {
    actualBall.xSpeed = mouseX - pmouseX;
    actualBall.ySpeed = mouseY - pmouseY;

    actualBall = null;
  }
}

void addBall() {
    float x = random(25, width - 25);
    float y = random(25, height - 25);
    float radius = random(20, 50);
    float xSpeed = random(-10, 10);
    float ySpeed = random(-5, 5);
    float gravity = random(0.3, 1.3);
    float friction = random(0.8, 0.9);

    balls.add(new Ball(x, y, xSpeed, ySpeed, radius, gravity, friction));
}
