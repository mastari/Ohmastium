package Game;

import World.WorldState;

import java.awt.*;
import java.util.Stack;

public class GameStateManager {

    public Stack<GameState> gameStates;

    public GameState pendingState;

    public GameStateManager() {
        gameStates = new Stack<>();
        gameStates.push(new WorldState(this));
        pendingState = null;
    }

    public void init() {
        gameStates.peek().init();
    }

    public void tick(double deltaTime) {
        gameStates.peek().tick(deltaTime);
    }

    public void render(Graphics2D g) {
        gameStates.peek().render(g);
    }

    public void pushState(GameState state) {
        this.gameStates.push(state);
        init();
        this.pendingState = null;
        System.out.println("Pending state was pushed.");
    }

}
