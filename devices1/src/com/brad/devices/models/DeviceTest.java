package com.brad.devices.models;

public class DeviceTest {

	public static void main(String[] args) {
		
		Phone phone = new Phone();
		System.out.println(phone.makeCall());
		System.out.println(phone.makeCall());
		System.out.println(phone.makeCall());
		System.out.println(phone.makeCall()); // Ninja Bonus
		
		System.out.println(phone.playGame());
		System.out.println(phone.playGame());
		System.out.println(phone.playGame()); // Ninja Bonus
		System.out.println(phone.playGame()); // Ninja Bonus
		
		System.out.println(phone.chargePhone());	
	}
}
