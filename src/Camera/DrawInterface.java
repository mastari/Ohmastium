package Camera;

import World.Vector;

import java.awt.*;

public class DrawInterface {
    private Camera c;
    public DrawInterface(Camera camera) {
        this.c = camera;
    }

    public void drawSquare(Vector pos, int size) {
        c.graphics2D.drawRect((int)(c.pos.x + (pos.x * size)),(int)(c.pos.y + (pos.y * size)), size, size);
    }
    public void drawRect(Vector pos, Vector size) {
        c.graphics2D.fillRect((int)(c.pos.x + (pos.x * size.x)),(int)(c.pos.y + (pos.y * size.y)), (int)size.x, (int)size.y);
    }

    public void setColor(Color color) {
        c.graphics2D.setColor(color);
    }
}
