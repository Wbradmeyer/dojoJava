package com.brad.devices.models;

public class Phone extends Device {
	public String makeCall() {
		battery -=5;
		if(battery < 10) {
			System.out.println("Battery critical");
		}
		return String.format("You make a call.\nBattery Remaining: %d", displayBatteryLife());
	}
	
	public String playGame() {
		if(battery < 25) {
			return "Not enough battery life.";
		}
		battery -=20;
		System.out.println("You play a game.");
		if(battery < 10) {
			System.out.println("Battery critical");
		}
		return String.format("Battery Remaining: %d", displayBatteryLife());
	}
	
	public String chargePhone() {
		battery +=50;
		if(battery < 10) {
			System.out.println("Battery critical");
		}
		return String.format("You charge the phone.\nBattery Remaining: %d", displayBatteryLife());
	}
}
