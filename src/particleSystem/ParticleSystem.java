package particleSystem;

import globals.Main;
import globals.ProcessingSingleton;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;
import spaceWarps.Attractor;
import spaceWarps.SpaceWarp;

public class ParticleSystem {
	
	Main p5;

	private ArrayList<Particle> particles;
	private ArrayList<SpaceWarp> spaceWarps;

	private boolean drawParticles = true;

	public ParticleSystem(Main _p){
		p5 = _p;
		particles = new ArrayList<Particle>();
		spaceWarps = new ArrayList<SpaceWarp>();
		
		Particle a = new Particle();
		a.setPosition(new PVector());
		a.setAcceleration(new PVector(p5.random(-5, 0),p5.random(-5, 0),0));
		addParticle(a);
		
		SpaceWarp sp = new Attractor();
		sp.setPosition(new PVector());
		((Attractor)sp).setAttractionRadius(100f);
		spaceWarps.add(sp);
	}
	
	public void run(){
		
		for (SpaceWarp sp : spaceWarps) {
			sp.update();
			sp.drawGizmo();
		}
		
		for (Particle p : particles) {
			p.update();
			
			if(drawParticles)p.render();
		}
	}
	
	public void setDrawParticles(boolean state){
		drawParticles = state;
	}
	
	public void drawSpaceWarps(){
		
	}

	public void addParticle(Particle p){
		particles.add(p);
	}

	public void addSpaceWarp(SpaceWarp sp){
		spaceWarps.add(sp);
	}

}
