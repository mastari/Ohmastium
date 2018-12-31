package WorldState;

import WorldState.Blocks.Block;
import WorldState.Blocks.Types.AIR_BLOCK;
import WorldState.Blocks.Types.DIRT_BLOCK;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class World {
    private Map<Vector2f, Block> tileMap = new HashMap<Vector2f, Block>();

    public void init() {
        for(int x = -10; x < 10; x++) {
            for(int y = -1; y > -100; y--) {
                tileMap.put(new Vector2f(x,y), new DIRT_BLOCK());
            }
        }

        for(int x = -1; x < 15; x++) {
            for(int y = 6; y > 1; y--) {
                tileMap.put(new Vector2f(x,y), new DIRT_BLOCK());
            }
        }
    }

    public void render() {
        Set<Vector2f> keySet = tileMap.keySet();
        Iterator<Vector2f> keySetIterator = keySet.iterator();
        while(keySetIterator.hasNext()) {
            Vector2f key = keySetIterator.next();
            if(!(tileMap.get(key) instanceof AIR_BLOCK))
                tileMap.get(key).render(new Vector3f(key.x,key.y, Block.BLOCK_DIST));
        }
    }
}
