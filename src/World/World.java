package World;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class World {

    public int w, h;
    public Map<Vector, Block> blockMap;

    public World(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void init() {
        blockMap = new HashMap<Vector, Block>();

        for (int i = 0; i < this.w; i++) {
            for (int j = 0; j < this.h; j++) {
                Vector pos = new Vector(i, j);
                blockMap.put(pos, new Block(pos, BlockType.AIR));
            }
        }
    }

    public void tick(double deltaTime) {
        for (Block b : blockMap.values()) {
            b.tick(deltaTime);
        }
    }

    public void render(Graphics2D g) {
        for (Block b : blockMap.values()) {
            b.render(g);
        }
    }

}
