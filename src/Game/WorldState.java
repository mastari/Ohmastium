package Game;

import World.World;

import java.awt.*;

public class WorldState extends GameState {

    public World world;

    public WorldState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        world = new World(20, 20);
        world.init();
    }

    @Override
    public void tick(double deltaTime) {
        world.tick(deltaTime);
    }

    @Override
    public void render(Graphics2D g) {
        world.render(g);
    }

}
