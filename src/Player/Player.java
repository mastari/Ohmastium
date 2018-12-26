package Player;

import Camera.Camera;
import Game.GameStateManager;
import Input.KeyboardManager;
import World.Vector;
import World.World;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public Vector pos;
    public World world;
    public Camera cam;
    public GameStateManager gsm;

    public Vector size;

    public Player(GameStateManager gsm, World world, Camera cam) {
        this.gsm = gsm;
        this.world = world;
        this.cam = cam;
    }

    public void init() {
        pos = new Vector(0, 0);
        size = new Vector(50, 50);
    }

    public void tick(double deltaTime) {
        if (KeyboardManager.isKeyDown(KeyEvent.VK_W)) {
            this.pos.y --;
        }
        if (KeyboardManager.isKeyDown(KeyEvent.VK_S)) {
            this.pos.y ++;
        }
        if (KeyboardManager.isKeyDown(KeyEvent.VK_A)) {
            this.pos.x --;
        }
        if (KeyboardManager.isKeyDown(KeyEvent.VK_D)) {
            this.pos.x ++;
        }
    }

    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect((int) (pos.x + cam.pos.x), (int) (pos.y + cam.pos.y), (int) size.x, (int) size.y);
    }

}
