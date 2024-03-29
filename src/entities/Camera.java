package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	private Vector3f position = new Vector3f(0,0,0);
	private float pitch;//high or low the camera is
	private float yaw;//left or right the camera is
	private float roll;//how much the camera is it tilted 
	
	public Camera() {}
	
	//to move the camera around
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			position.z -= 0.2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.z += 0.2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.x += 0.2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			position.x -= 0.2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			position.y += 0.2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			position.y -= 0.2f;
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public void setRoll(float roll) {
		this.roll = roll;
	}
	
	
	
}
