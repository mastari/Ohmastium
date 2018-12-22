package Game;

import Engine.GameLoop;
import Engine.GameWindow;

import java.awt.*;

public class Main {

    public static GameWindow frame;

    public static void main(String[] args) {
        GameLoop gameLoop = new GameLoop(500, 500);
        frame = new GameWindow("Ohmastium", 500, 500);
        frame.setFullscreen(1);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(""), new Point(0, 0), "Cursor");
        frame.setCursor(cursor);
        frame.add(gameLoop);
        frame.setVisible(true);
    }

}
