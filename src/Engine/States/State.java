package Engine.States;

import Engine.entities.Camera;
import Engine.entities.Light;

public abstract class State {

    public Camera camera;
    public Light sun;

    public abstract void init();
    public abstract void update();
    public abstract void render();

}
