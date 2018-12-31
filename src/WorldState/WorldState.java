package WorldState;

import Engine.States.State;
import Engine.States.StateManager;
import Engine.entities.Camera;
import Engine.entities.Light;
import org.lwjgl.util.vector.Vector3f;

public class WorldState extends State {

    Player player = new Player(Player.model, new Vector3f(0,1,-20));
    World world = new World();

    @Override
    public void init() {
        camera = new Camera();
        sun = new Light(new Vector3f(0,100,0), new Vector3f(1f,1f,1f));
        world.init();
    }

    @Override
    public void update() {
        player.move();
        camera.setPosition(new Vector3f(player.getPosition().x, player.getPosition().y, -1f));
    }

    @Override
    public void render() {
        player.render();
        world.render();
    }

}
