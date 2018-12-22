package Game;

import Camera.Camera;
import Player.Player;
import World.*;

import java.awt.*;

public class WorldState extends GameState {

    public World world;
    public Player player;
    public static Camera cam;

    public WorldState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        cam = new Camera(new Vector(0, 0));
        cam.init();

        world = new World(20, 20);
        world.init();

        player = new Player(new Vector(0, 0), world, cam);
        player.init();
    }

    @Override
    public void tick(double deltaTime) {
        cam.tick(deltaTime);
        cam.follow(player);
        world.tick(deltaTime);
        player.tick(deltaTime);
    }

    @Override
    public void render(Graphics2D g) {
        cam.render(g);
        world.render(g);
        player.render(g);
    }

}
