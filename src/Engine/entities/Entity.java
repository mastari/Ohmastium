package Engine.entities;

import Engine.models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;
import Engine.renderEngine.MasterRenderer;

public class Entity {

    public TexturedModel model;
    public Vector3f position;
    public float rotX, rotY, rotZ;
    public float scale;

    public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
        super();
        this.model = model;
        this.position = position;
        this.rotX = 0;
        this.rotY = 0;
        this.rotZ = 0;
        this.scale = scale;
    }

    public Entity() {
        rotX = 0;
        rotY = 0;
        rotZ = 0;
        scale = 0.5f;
    }

    public void increasePosition(float dx, float dy, float dz) {
        this.position.x += dx;
        this.position.y += dy;
        this.position.z += dz;
    }

    public void increaseRotation(float dx, float dy, float dz) {
        this.rotX += dx;
        this.rotY += dy;
        this.rotZ += dz;
    }

    public void render() {
        MasterRenderer.masterRenderer.processEntity(this);
    }

    public TexturedModel getModel() {
        return model;
    }

    public void setModel(TexturedModel model) {
        this.model = model;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public float getRotX() {
        return rotX;
    }

    public void setRotX(float rotX) {
        this.rotX = rotX;
    }

    public float getRotY() {
        return rotY;
    }

    public void setRotY(float rotY) {
        this.rotY = rotY;
    }

    public float getRotZ() {
        return rotZ;
    }

    public void setRotZ(float rotZ) {
        this.rotZ = rotZ;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
