package com.brad.zookeeper.models;

public class Bat extends Mammal{

	public Bat() {
		super(300);
	}
	
	public void fly() {
		this.energy -= 50;
		System.out.println("Bat is airborne.");
	}
	
	public void eatHumans() {
		this.energy += 25;
		System.out.println("Bat ate a delicious human. Bat is happy!");
	}
	
	public void attackTown() {
		this.energy -=100;
		System.out.println("Bat attacked from above, slashing and maming!");
	}
}
