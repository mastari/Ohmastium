package World;

import java.awt.*;

public class Block {

    public Vector pos;
    public BlockType type;

    public Block(Vector pos, BlockType type) {
        this.pos = pos;
        this.type = type;
    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {
        g.drawRect((int) pos.x * 50, (int) pos.y * 50, 50, 50);
    }

}

enum BlockType {
    AIR
}