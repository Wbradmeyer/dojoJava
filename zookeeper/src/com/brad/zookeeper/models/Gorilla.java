package com.brad.zookeeper.models;

public class Gorilla extends Mammal {
	
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		this.energy -= 5;
		System.out.println("Gorilla threw something.");
	}
	
	public void eatBananas() {
		this.energy += 10;
		System.out.println("Gorilla ate a banana and is happy.");
	}
	
	public void climb() {
		this.energy -= 10;
		System.out.println("Gorilla climbed a tree.");
	}
}
