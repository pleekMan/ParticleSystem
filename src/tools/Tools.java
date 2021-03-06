package tools;

import processing.core.PVector;
import globals.Main;
import globals.ProcessingSingleton;

public class Tools {
	static Main p5 = ProcessingSingleton.getInstance().getProcessingSingleton();
	
	public Tools(){
	}

	static public float distanceBetween(PVector pos1, PVector pos2) {
		return p5.dist(pos1.x, pos1.y, pos1.z, pos2.x, pos2.y, pos2.z);
	}

	static public void drawAxisGizmo(){
		drawGizmo(0f,0f,0f,50f);
	}

	static public void drawAxisGizmo(float size){
		drawGizmo(0f,0f,0f,size);
	}
	static public void drawGizmo(float xPos, float yPos, float zPos, float gizmoSize) {

		p5.pushMatrix();
		p5.translate(xPos, yPos, zPos);

		p5.noFill();
		p5.box(gizmoSize * 0.05f);

		// X
		p5.fill(255, 0, 0);
		p5.stroke(255, 0, 0);
		p5.line(0, 0, 0, gizmoSize, 0, 0);
		// box(100);

		// Y
		p5.fill(0, 255, 0);
		p5.stroke(0, 255, 0);
		p5.line(0, 0, 0, 0, gizmoSize, 0);

		// Z
		p5.fill(0, 0, 255);
		p5.stroke(0, 0, 255);
		p5.line(0, 0, 0, 0, 0, gizmoSize);

		p5.popMatrix();
	}

	static public void drawMouseCoordinates() {
		// MOUSE POSITION
		p5.fill(255, 0, 0);
		p5.text("FR: " + p5.frameRate, 20, 20);
		p5.text("X: " + p5.mouseX + " / Y: " + p5.mouseY, p5.mouseX, p5.mouseY);
	}
	
	public static void translate(PVector p){
		p5.translate(p.x, p.y, p.z);
	}



}
