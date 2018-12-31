package Engine;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Constants {
    public static String TITLE = "OHMASTIUMIUM ENGINE";
    private static Dimension SCREEN_SIZE;

    public static void init() {
        SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static Dimension getScreenSize() { return SCREEN_SIZE; }

}
