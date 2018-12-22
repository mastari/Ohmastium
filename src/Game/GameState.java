package Game;

import java.awt.*;

public abstract class GameState {

    public GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void init();
    public abstract void tick(double deltaTime);
    public abstract void render(Graphics2D g);

}
