package Engine.renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.DisplayMode;

import java.awt.*;

public class DisplayManager {

    private static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width + 16*30;
    private static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height + 9*30;
    private static final int FPS_CAP = 120;

    public static void createDisplay(String title) {

        ContextAttribs attribs = new ContextAttribs(3,2)
        .withForwardCompatible(true)
        .withProfileCore(true);

        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat().withSamples(16), attribs); //antialiasing
            Display.setTitle(title);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glViewport(0,0, WIDTH, HEIGHT);
    }

    public static void updateDisplay() {
        Display.sync(FPS_CAP);
        Display.update();
    }

    public static void closeDisplay() {
        Display.destroy();
    }

    public static int getFPS() { return FPS_CAP; }
}
