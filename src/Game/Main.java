package Game;

import Engine.GameLoop;
import Engine.GameWindow;

import java.awt.*;

public class Main {

    public static GameWindow frame;

    public static void main(String[] args) {
        Constants.init();
        GameLoop gameLoop = new GameLoop((int) Constants.getScreenSize().x, (int) Constants.getScreenSize().y);
        frame = new GameWindow("Ohmastium", (int) Constants.getScreenSize().x, (int) Constants.getScreenSize().y);
        frame.setFullscreen(1);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(""), new Point(0, 0), "Cursor");
        frame.setCursor(cursor);
        frame.add(gameLoop);
        frame.setVisible(true);
    }

}
