
class Ball {
    float x, y, xSpeed, ySpeed;
    float radius;
    float gravity;
    float friction;
  
    Ball(float x, float y, float xSpeed, float ySpeed, float radius, float gravity, float friction) {
      this.x = x;
      this.y = y;
      this.xSpeed = xSpeed;
      this.ySpeed = ySpeed;
      this.radius = radius;
      this.gravity = gravity;
      this.friction = friction;
    }
  
    void move () {
      ySpeed += gravity;
      xSpeed += xSpeed > 0 ? -friction/20 : friction/20;
  
      x += xSpeed;
      y += ySpeed;
  
      // lateral derecho
      if (x + radius > width) {
        x = width - radius;
        xSpeed = -xSpeed * friction;
        if (abs(xSpeed) > 1) points++;
  
      // lateral izquierdo
      } else if (x - radius < 0) {
        x = radius;
        xSpeed = -xSpeed * friction;
        if (abs(xSpeed) > 1) points++;
  
      }
  
      // parte inferior
      if (y + radius > height) {
        y = height - radius;
        ySpeed = -ySpeed * friction;
        if (abs(ySpeed) > 1) points++;
  
      // parte superior
      } else if (y - radius < 0) {
        y = radius;
        ySpeed = -ySpeed * friction;
  
        if (abs(ySpeed) > 1) points++;
      }
    }
  
    void collide(Ball[] balls) {
      for (Ball other : balls) {
        if (other != this) {
          float dx = other.x - x;
          float dy = other.y - y;
          float distance = sqrt(dx * dx + dy * dy);
  
          if (distance < radius + other.radius) {
            float nx = dx / distance;
            float ny = dy / distance;
  
            float p1 = xSpeed * nx + ySpeed * ny;
            float p2 = other.xSpeed * nx + other.ySpeed * ny;
  
            float m1 = radius / 2, m2 = other.radius / 2;
            float newP1 = ((p1 * (m1 - m2)) + (2 * m2 * p2)) / (m1 + m2);
            float newP2 = ((p2 * (m2 - m1)) + (2 * m1 * p1)) / (m1 + m2);
  
            xSpeed += (newP1 - p1) * nx;
            ySpeed += (newP1 - p1) * ny;
            other.xSpeed += (newP2 - p2) * nx;
            other.ySpeed += (newP2 - p2) * ny;
  
            float overlap = (radius + other.radius - distance) / 2;
            x -= nx * overlap;
            y -= ny * overlap;
            other.x += nx * overlap;
            other.y += ny * overlap;
          }
        }
      }
    }
  
    void show() {
      ellipse(x, y, radius * 2, radius * 2);
    }
  }