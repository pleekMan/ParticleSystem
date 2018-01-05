package particleSystem;

import java.util.ArrayList;

import globals.Main;
import globals.ProcessingSingleton;
import processing.core.PVector;
import spaceWarps.SpaceWarp;
import tools.Tools;

public class Particle {

	Main p5;

	public PVector position, velocity;
	public PVector acceleration;
	float damp;

	ArrayList<SpaceWarp> spaceWarps;


	public Particle() {
		p5 = ProcessingSingleton.getInstance().getProcessingSingleton();

		position = new PVector();
		velocity = new PVector();
		acceleration = new PVector();
		damp = 0f;
		
		spaceWarps = new ArrayList<SpaceWarp>();
	}

	public void update() {
		velocity.add(acceleration);
		position.add(velocity);
		position.mult(1 - damp);

		acceleration.set(0, 0, 0);
	}
	
	public void applyWarps(){
		for (SpaceWarp sp : spaceWarps) {
			sp.warp(this);
		}
	}

	public void render(){
		p5.fill(255,127,0);
		p5.noStroke();

		p5.pushMatrix();
		Tools.translate(position);
		
		p5.sphere(2);
		
		p5.popMatrix();
	}

	public void setPosition(PVector pos){
		position.set(pos);
	}

	public void setVelocity(PVector vel) {
		velocity.set(vel);
	}

	public void setAcceleration(PVector accel) {
		acceleration.set(accel);
	}
	
	public void bindTo(SpaceWarp sp){
		spaceWarps.add(sp);
	}
	
	public ArrayList<SpaceWarp> getSpaceWarps(){
		return spaceWarps;
	}
}
