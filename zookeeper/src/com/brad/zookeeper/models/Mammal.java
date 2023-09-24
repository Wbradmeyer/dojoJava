package com.brad.zookeeper.models;

public class Mammal {
	protected int energy = 100;
	
	public Mammal() {
	}
	
	public Mammal(int energy) {
		this.energy = energy;
	}
	
	public int displayEnergy() {
		System.out.println("Energy: " + energy);
		return energy;
	}
}
