package spaceWarps;

import globals.Main;
import globals.ProcessingSingleton;
import particleSystem.Particle;
import processing.core.PVector;
import tools.Tools;

public class SpaceWarp {
	Main p5;
	
	PVector center;
	PVector boxSize;
	float multiplier = 1;
	String name;
	boolean[] affectAxis = {true,true,true}; 

	public SpaceWarp() {

		p5 = ProcessingSingleton.getInstance().getProcessingSingleton();

		center = new PVector();
		boxSize = new PVector (100, 100, 100);
	}

	public void update() {
	}

	public void warp(Particle particle) {
	}
	
	public void setPosition(PVector pos){
		center.set(pos);
	}
	
	public void setPosition(float _x, float _y, float _z){
		center.set(_x, _y, _z);
	}

	public void drawGizmo(){
		p5.noFill();
		
		// CENTER
		p5.pushMatrix();
		Tools.translate(center);	
		p5.stroke(0,255,0);

		p5.ellipse(0,0,10,10);
		p5.rotateY(p5.HALF_PI);
		p5.ellipse(0,0,10,10);
		p5.rotateX(p5.HALF_PI);
		p5.ellipse(0,0,10,10);
		
		p5.popMatrix();
		
		//p5.println("-|| SPACEWARP");
		
	}
	public void affectAxis(boolean x, boolean y, boolean z){
		affectAxis[0]=x;
		affectAxis[1]=y;
		affectAxis[3]=z;
	}
}
