package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int FPS_CAP = 60;
	private static final String TITLE = "Main display";
	
	public static void createDisplay() {
		
		//OpenGL version 3.2 
		ContextAttribs attribs = new ContextAttribs(3,2)
			.withForwardCompatible(true)
			.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat(), attribs);
			String version = GL11.glGetString(GL11.GL_VERSION);
			String openGLver = "OpenGL version : "+version;
			Display.setTitle(TITLE);
			System.out.println(openGLver);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);//set whole display to render
	}
	
	public static void updateDisplay() {
		Display.sync(FPS_CAP);
		Display.update();
	}

	public static void closeDisplay() {
		Display.destroy();
		System.exit(0);
	}
	
}
