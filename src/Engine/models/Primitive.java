package Engine.models;

import Engine.renderEngine.Loader;
import Engine.renderEngine.OBJLoader;
import Engine.textures.ModelTexture;

public class Primitive {
    public static TexturedModel Square(String texture) {
        return new TexturedModel(OBJLoader.loadObjectModel("defaultPlane", Loader.masterLoader), new ModelTexture(Loader.masterLoader.loadTexture(texture)));
    }

    private Primitive(){};

}
