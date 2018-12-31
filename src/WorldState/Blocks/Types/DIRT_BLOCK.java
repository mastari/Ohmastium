package WorldState.Blocks.Types;

import Engine.entities.Entity;
import Engine.models.Primitive;
import Engine.models.TexturedModel;
import WorldState.Blocks.Block;
import org.lwjgl.util.vector.Vector3f;

public class DIRT_BLOCK extends Entity implements Block {

    public static TexturedModel model = Primitive.Square("dirt");

    public void render(Vector3f pos) {
        this.position = pos;
        this.scale = Block.BLOCK_SIZE;
        this.setModel(model);
        this.render();
    }
}
