package World;

import Camera.DrawInterface;

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

    public void render(DrawInterface g) {
        g.setColor(Color.WHITE);
        g.drawSquare(new Vector(pos.x, pos.y), blockSize);
    }

}

