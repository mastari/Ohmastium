package Engine.renderEngine;

import Engine.entities.Entity;
import Engine.models.RawModel;
import Engine.models.TexturedModel;
import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.Matrix4f;
import Engine.shaders.StaticShader;
import Engine.textures.ModelTexture;
import Engine.toolbox.Maths;

import java.util.List;
import java.util.Map;

public class Renderer {

    private static final float FOV = 100;
    private static final float NEAR_PLANE = 0.001f;
    private static final float FAR_PLANE = 1000; //render distance

    private Matrix4f projectionMatrix;
    private StaticShader shader;

    public Renderer(StaticShader shader) {
        this.shader = shader;
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glCullFace(GL11.GL_BACK);
        createProjectionMatrix();
        shader.start();
        shader.loadProjectionMatrix(projectionMatrix);
        shader.stop();
    }

    public void prepare() {
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(1,0,0,1);
    }

    public void render(Map<TexturedModel, List<Entity>> entities) {
        for(TexturedModel model:entities.keySet()) {
            prepareTexturedModel(model);
            List<Entity> batch = entities.get(model);
            for(Entity entity:batch) {
                prepareInstance(entity);
                GL11.glDrawElements(GL11.GL_TRIANGLES, model.getRawModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
            }
            unbindTexturedModel();
        }
    }

    private void prepareTexturedModel(TexturedModel model) {
        RawModel rawModel = model.getRawModel();
        GL30.glBindVertexArray(rawModel.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);
        ModelTexture texture = model.getTexture();
        shader.loadShineVariables(texture.getShineDamper(), texture.getReflectivity());
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getID());
    }

    public void unbindTexturedModel() {
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);
        GL30.glBindVertexArray(0);
    }
    public void prepareInstance(Entity entity) {
        Matrix4f transformationMatrix = Maths.createTransformationMatrix(entity.getPosition(), entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale());
        shader.loadTransformationMatrix(transformationMatrix);
    }

    private void createProjectionMatrix() {
        float aspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
        float y_scale = (float) ((1f / Math.tan(Math.toRadians(FOV / 2f))) * aspectRatio);
        float x_scale = y_scale / aspectRatio;
        float right = Display.getWidth();
        float left = 0;
        float top = 0;
        float bottom = Display.getHeight();
        float frustum_length = FAR_PLANE - NEAR_PLANE;

        projectionMatrix = new Matrix4f();
        projectionMatrix.m00 = x_scale;
        projectionMatrix.m11 = y_scale;
        projectionMatrix.m22 = -((FAR_PLANE + NEAR_PLANE) / frustum_length);
        projectionMatrix.m23 = -1;
        projectionMatrix.m32 = -((2 * NEAR_PLANE * FAR_PLANE) / frustum_length);
        projectionMatrix.m33 = 0;

//        float top = (float)(NEAR_PLANE * (Math.tan((Math.PI/180)*FOV/2)));
//        float bottom = 0;
//        float right = top*aspectRatio;
//        float left = -right;
//
//        projectionMatrix.m00 = 2.0f / (right - left);
//        projectionMatrix.m01 = 0;
//        projectionMatrix.m02 = 0;
//        projectionMatrix.m03 = 0;
//
//        projectionMatrix.m10 = 0;
//        projectionMatrix.m11 = 2.0f / (top - bottom);
//        projectionMatrix.m12 = 0;
//        projectionMatrix.m13 = 0;
//
//        projectionMatrix.m20 = 0;
//        projectionMatrix.m21 = 0;
//        projectionMatrix.m22 = -(2.0f / (FAR_PLANE - NEAR_PLANE));
//        projectionMatrix.m23 = 0;
//        projectionMatrix.m30 = -((right+left)/(right-left));
//        projectionMatrix.m31 = -((top+bottom)/(top-bottom));
//        projectionMatrix.m32 = -((FAR_PLANE+NEAR_PLANE)/(FAR_PLANE-NEAR_PLANE));
//        projectionMatrix.m33 = 1.0f;


//        projectionMatrix.m00 = 2.0f / (x_scale);
//        projectionMatrix.m01 = 0.0f;
//        projectionMatrix.m02 = 0.0f;
//        projectionMatrix.m03 = 0.0f;
//
//        projectionMatrix.m10 = 0.0f;
//        projectionMatrix.m11 = 2.0f / (y_scale);
//        projectionMatrix.m12 = 0.0f;
//        projectionMatrix.m13 = 0.0f;
//
//        projectionMatrix.m20 = 0.0f;
//        projectionMatrix.m21 = 0.0f;
//        projectionMatrix.m22 = -2.0f / (FAR_PLANE - NEAR_PLANE);
//        projectionMatrix.m23 = 0.0f;
//
//        projectionMatrix.m30 = -(x_scale + left) / (x_scale - left);
//        projectionMatrix.m31 = -(top + y_scale) / (y_scale);
//        projectionMatrix.m32 = -(FAR_PLANE + NEAR_PLANE) / (FAR_PLANE - NEAR_PLANE);
//        projectionMatrix.m33 = 1.0f;
    }
}
