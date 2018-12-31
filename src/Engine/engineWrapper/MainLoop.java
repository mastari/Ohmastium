package Engine.engineWrapper;

import Engine.Constants;
import Game.Main;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import Engine.renderEngine.DisplayManager;
import Engine.renderEngine.Loader;
import Engine.renderEngine.MasterRenderer;

public class MainLoop {
    public static void main(String[] args) {


        DisplayManager.createDisplay(Constants.TITLE);

        Main.init();

        while(!Display.isCloseRequested()) {

            Main.run(); //Run Game

            DisplayManager.updateDisplay(); //Update Window

            if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
                System.out.println("Closed Window.");
                break;
            }

        }

        //Kill window protocol
        MasterRenderer.masterRenderer.cleanUp();
        Loader.masterLoader.cleanUp();
        DisplayManager.closeDisplay();

    }
}
