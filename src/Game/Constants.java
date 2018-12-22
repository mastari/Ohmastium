package Game;

import World.Vector;

import java.awt.*;

public class Constants {

    private static Vector SCREEN_SIZE;

    public static void init() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_SIZE = new Vector(screenSize.width, screenSize.height);
    }

    public static Vector getScreenSize() {
        return SCREEN_SIZE;
    }

}
