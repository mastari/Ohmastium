package WorldState.Blocks;

import org.lwjgl.util.vector.Vector3f;

public interface Block {

    float BLOCK_SIZE = 0.5f;
    float BLOCK_DIST = -20f;

    void render(Vector3f pos);

}
