package WorldState;

import Engine.entities.Entity;
import Engine.models.Primitive;
import Engine.models.TexturedModel;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Player extends Entity {

    public static TexturedModel model = Primitive.Square("default");
    public Player(TexturedModel model, Vector3f pos) {
        this.setPosition(new Vector3f(pos.x,pos.y,-19.9f));
        this.setModel(model);

    }

    public float speed = 0.08f;

    public void move() {
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            position.x+=speed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            position.x-=speed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            position.y+=speed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            position.y-=speed;
        }
    }


}
