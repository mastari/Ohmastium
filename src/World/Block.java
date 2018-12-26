package World;

import java.awt.*;

public class Block {

    public final static int blockSize = 50;

    public Vector pos;
    public BlockType type;

    public Block(Vector pos, BlockType type) {
        this.pos = pos;
        this.type = type;
    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawRect((int) (WorldState.cam.pos.x + (pos.x * blockSize)), (int) (WorldState.cam.pos.y + (pos.y * blockSize)), blockSize, blockSize);
    }

}

enum BlockType {
    AIR
}