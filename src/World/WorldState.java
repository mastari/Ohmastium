package World;

import Camera.*;
import Game.GameState;
import Game.GameStateManager;
import Player.Player;

import java.awt.*;

public class WorldState extends GameState {

    public World world;
    public Player player;
    public static Camera cam;
    public DrawInterface relativeDraw;

    public WorldState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        cam = new Camera(new Vector(0, 0), gsm.graphics2D);
        cam.init();

        world = new World(20, 20);
        world.init();

        player = new Player(gsm, world, cam);
        player.init();

        relativeDraw = new DrawInterface(this.cam);
    }

    @Override
    public void tick(double deltaTime) {
        cam.tick(deltaTime);
        cam.followPlayer(player);
        world.tick(deltaTime);
        player.tick(deltaTime);
    }

    @Override
    public void render(Graphics2D g) {
        world.render(this.relativeDraw);
        player.render(g);
    }

}
