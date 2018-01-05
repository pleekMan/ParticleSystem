package particleSystem;

import java.util.ArrayList;

import spaceWarps.SpaceWarp;
import tools.*;
import processing.core.PVector;
import globals.Main;
import globals.ProcessingSingleton;

public class Emitter {
	Main p5;

	PVector position;
	PVector orientation;
	float spawnVelocity;
	float spawnFrequency;
	Timer timer;

	ArrayList<Particle> particles;
	ArrayList<SpaceWarp> spaceWarpsBinding;

	public Emitter(ArrayList<Particle>  systemParticles){

		p5 = ProcessingSingleton.getInstance().getProcessingSingleton();

		particles = systemParticles;
		spaceWarpsBinding = new ArrayList<SpaceWarp>();

		position = new PVector();
		orientation = new PVector(0,-1,0);
		spawnVelocity = 1;
		spawnFrequency = (1.0f/4); // in Hz (Default 4 times a sec)

		timer = new Timer();
		timer.setDuration((int)(spawnFrequency * 1000));
		timer.start();
	}

	public void update(){

		if(timer.isFinished()){
			spawn();
			timer.start();
		}

	}

	public void spawn(){

		Particle newParticle = new Particle();

		PVector pos = position.get();
		PVector vel = orientation.get();
		vel.mult(spawnVelocity);

		newParticle.setPosition(pos);
		newParticle.setAcceleration(vel);
		
		bindToSpaceWarps(newParticle);

		particles.add(newParticle);

	}

	public void drawGizmo(){

		p5.noFill();

		// CENTER
		p5.pushMatrix();
		Tools.translate(position);
		
		p5.stroke(0,255,0);
		
		p5.pushMatrix();
		p5.rect(-5,-5,10,10);
		p5.rotateY(p5.HALF_PI);
		p5.rect(-5,-5,10,10);
		p5.rotateX(p5.HALF_PI);
		p5.rect(-5,-5,10,10);
		p5.popMatrix();
		
		PVector spawnVecCoords = new PVector();
		spawnVecCoords.add(orientation);
		spawnVecCoords.mult(spawnVelocity * 10);
		
		p5.line(0, 0, 0, spawnVecCoords.x,spawnVecCoords.y,spawnVecCoords.z);
		p5.popMatrix();

	}

	public void setSpawnFrequency(int hertz){
		spawnFrequency = 1.0f/hertz;
		timer.setDuration((int)(spawnFrequency * 1000));
		timer.start();
	}
	
	public void bindToSpaceWarps(Particle p){
		for (SpaceWarp sp : spaceWarpsBinding) {
			p.bindTo(sp);
		}
	}
	
	public void addSpaceWarpBinding(SpaceWarp sp){
		spaceWarpsBinding.add(sp);
	}
	
	public void setSpaceWarpBindings(ArrayList<SpaceWarp> sps){
		spaceWarpsBinding.clear();
		for (SpaceWarp spaceWarp : sps) {
			spaceWarpsBinding.add(spaceWarp);
		}
	}
	
	public void clearSpaceWarpBindings(){
		spaceWarpsBinding.clear();
	}


}
