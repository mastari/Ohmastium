package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyboardManager implements KeyListener {

    public static Map<Integer, Boolean> keys;

    public KeyboardManager () {
        keys = new HashMap<>();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.put(e.getKeyCode(), false);
    }

    public static boolean isKeyDown(int key) {
        if (!keys.containsKey(key)) return false;
        return keys.get(key);
    }
}
