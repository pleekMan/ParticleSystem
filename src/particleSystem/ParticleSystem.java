package particleSystem;

import globals.Main;
import globals.ProcessingSingleton;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;
import spaceWarps.*;

public class ParticleSystem {
	
	Main p5;

	private ArrayList<Particle> particles;
	private ArrayList<SpaceWarp> spaceWarps;
	private ArrayList<Emitter> emitters;

	int countLimit = 5000;

	private boolean drawParticles = true;

	public ParticleSystem(Main _p){
		p5 = _p;
		particles = new ArrayList<Particle>();
		spaceWarps = new ArrayList<SpaceWarp>();
		emitters = new ArrayList<Emitter>();
		

		
		SpaceWarp sp = new Repeller();
		sp.setPosition(new PVector());
		((Repeller)sp).setAttractionRadius(100f);
		spaceWarps.add(sp);
		
		/*
		Particle a = new Particle();
		a.setPosition(new PVector());
		a.setAcceleration(new PVector(0,-0.2f,0));
		a.bindTo(sp);
		addParticle(a);
		*/
		
		//random1000();
		
		Emitter em = new Emitter(particles);
		em.setSpawnFrequency(4);
		em.setSpaceWarpBindings(spaceWarps);
		emitters.add(em);
	}
	
	public void run(){
		
		for (Emitter em : emitters) {
			em.update();
			em.drawGizmo();
		}
		
		for (SpaceWarp sp : spaceWarps) {
			sp.update();
			sp.drawGizmo();
		}
		
		for (Particle p : particles) {
			p.update();
			p.applyWarps();
			
			
			if(drawParticles)p.render();
		}
	}
	
	public void applyWarps(Particle p){
		
		for (SpaceWarp sp : p.getSpaceWarps()) {
			
		}
	}
	
	public void setDrawParticles(boolean state){
		drawParticles = state;
	}
	
	public void drawSpaceWarps(){
		
	}

	public void addParticle(Particle p){
		if(particles.size() < countLimit){
			particles.add(p);
		}
	}

	public void addSpaceWarp(SpaceWarp sp){
		spaceWarps.add(sp);
	}

	public void keyPressed(char key) {
		if (key == 'r') {
			particles.get(0).setPosition(new PVector());
		}
	}
	
	public void random1000(){
		for (int i = 0; i < 1000; i++) {
			Particle newParticle = new Particle();
			newParticle.setPosition(new PVector(p5.random(-200,200),p5.random(-200,200),p5.random(-200,200)));
			newParticle.bindTo(spaceWarps.get(0));
			addParticle(newParticle);
		}
	}

	public int getParticleCount() {
		return particles.size();
	}

}
