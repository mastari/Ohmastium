package Player;

import Camera.Camera;
import World.Vector;
import World.World;

import java.awt.*;

public class Player {

    public Vector pos;
    public World world;
    public Camera cam;

    public Vector size;

    public Player(Vector pos, World world, Camera cam) {
        this.pos = pos;
        this.world = world;
        this.cam = cam;
    }

    public void init() {
        size = new Vector(50, 50);
    }

    public void tick(double deltaTime) {
        pos.x+=.1;
        pos.y+=.1;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect((int) (pos.x + cam.pos.x), (int) (pos.y + cam.pos.y), (int) size.x, (int) size.y);
    }

}
