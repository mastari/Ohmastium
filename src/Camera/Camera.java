package Camera;

import Game.Constants;
import Player.Player;
import World.Vector;

import java.awt.*;

public class Camera {

    public Vector pos;
    public Graphics2D graphics2D;

    public Camera(Vector pos, Graphics2D g) {
        this.pos = pos;
        this.graphics2D = g;
    }

    public void init() {

    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {

    }

    public void followPlayer(Player p) {
        this.pos = new Vector((int) (Constants.getScreenSize().x /2 - p.size.x/2) - (p.pos.x), (int) (Constants.getScreenSize().y/2 - p.size.y/2) - (p.pos.y));
    }

}
