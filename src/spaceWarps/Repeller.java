package spaceWarps;

import particleSystem.Particle;
import processing.core.PVector;
import tools.Tools;

public class Repeller extends SpaceWarp{

	float attractRadius;
	float strengthMin;
	float strengthMax;


	public Repeller() {
		super();
		setStrengthMin(0f);
		setStrengthMax(0.02f);
	}

	public void update() {
		super.update();
		
		//TEMP
		setPosition(p5.mouseX - (p5.width * 0.5f), p5.mouseY - (p5.height * 0.5f),0);

	}

	public void warp(Particle particle) {
		//super.warp(particlePos);

		float distanceToattractor = Tools.distanceBetween(particle.position, center);
		if (distanceToattractor < attractRadius) {
			//float keepZ = particle.position.z;
			PVector toAttractorVector = PVector.sub(particle.position, center);
			float strength = p5.map(distanceToattractor, 0, attractRadius, strengthMax, strengthMin);
			toAttractorVector.mult(strength * multiplier);
			particle.acceleration.add(toAttractorVector);
			//particle.position.z = keepZ;
		}
	}

	public void setStrengthMax(float s) {
		strengthMax = s;
	}

	public void setStrengthMin(float s) {
		strengthMin = s;
	}
	
	public void setAttractionRadius(float r){
		attractRadius = r;
	}
	
	public void drawGizmo(){
		super.drawGizmo();
		
		// ATTRACT RADIUS
		p5.pushMatrix();
		Tools.translate(center);	
		p5.stroke(0,255,255);

		p5.ellipse(0,0,attractRadius * 2, attractRadius * 2);
		p5.rotateY(p5.HALF_PI);
		p5.ellipse(0,0,attractRadius * 2, attractRadius * 2);
		p5.rotateX(p5.HALF_PI);
		p5.ellipse(0,0,attractRadius * 2, attractRadius * 2);
		
		p5.popMatrix();
		
		//p5.println("-|| ATTRACTOR");
	}
	
}
