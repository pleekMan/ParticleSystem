package globals;

import particleSystem.ParticleSystem;
import peasy.PeasyCam;
import processing.core.*;
import tools.Tools;


public class Main extends PApplet {
	PeasyCam cam;

	ParticleSystem pSystem;

	public void setup(){
		size(1000,1000, P3D);
		frameRate(30);
		setProcessingSingleton();
		sphereDetail(5);

		cam = new PeasyCam(this, 500);
		cam.setMinimumDistance(50);
		cam.setMaximumDistance(5000);

		pSystem = new ParticleSystem(this);
	}

	public void draw(){
		background(0);
		Tools.drawAxisGizmo();

		pSystem.run();


	}

	public void keyPressed() {

		pSystem.keyPressed(key);


	}

	public void mousePressed() {
	}

	public void mouseReleased() {
	}

	public void mouseClicked() {
	}

	public void mouseDragged() {
	}

	public void mouseMoved() {
	}

	public static void main(String args[]) {
		PApplet.main(new String[] { Main.class.getName() });
		// PApplet.main(new String[] { "--present", Main.class.getName() }); //
		// PRESENT MODE
	}

	private void setProcessingSingleton() {
		ProcessingSingleton.getInstance().setProcessingSingleton(this);
	}
}