package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import entities.Camera;
import entities.Entity;
import entities.Light;
import models.RawModel;
import models.TextureModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.ObjLoader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		
		RawModel model = ObjLoader.loadObjModel("dragon", loader);
		
		TextureModel staticModel = new TextureModel(model, new ModelTexture(loader.loadTexture("white")));
		ModelTexture texture = staticModel.getTexture();
		texture.setShineDamper(10);
		texture.setReflectivity(0.1f);
		
		Entity entity = new Entity(staticModel, new Vector3f(0,-3,-25),0,0,0,1);
		Light light = new Light(new Vector3f(0,0,-20), new Vector3f(1,1,1));
		
		Camera camera = new Camera();
		
		MasterRenderer renderer = new MasterRenderer();
		while(!Display.isCloseRequested()) {
			camera.move();
			
			renderer.processEntity(entity);
			
			renderer.render(light, camera);
			DisplayManager.updateDisplay();
		}
		
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
		
	}

}
