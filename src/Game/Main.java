package Game;

import Engine.States.StateManager;
import WorldState.WorldState;

public class Main {

    public static void init() {
        StateManager.setBeginState(new WorldState());
        StateManager.init();
    }

    public static void run() {

        StateManager.update();
        StateManager.render();

    }
}
