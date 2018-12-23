package World;

import Game.WorldState;

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
        g.setColor(Color.WHITE);
        g.drawRect((int) (WorldState.cam.pos.x + (pos.x * 50)), (int) (WorldState.cam.pos.y + (pos.y * 50)), 50, 50);
    }

}

enum BlockType {
    AIR
}