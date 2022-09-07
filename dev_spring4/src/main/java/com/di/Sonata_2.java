package com.di;

public class Sonata_2 {
	String carColor = null;
	int speed = 0;
	int wheelNum = 0;
	public Sonata_2() {
		
	}
	public Sonata_2(String carColor, int speed) {
		this.carColor = carColor;
		this.speed = speed;
	}
	public Sonata_2(String carColor, int speed, int wheelNum) {
		this.carColor = carColor;
		this.speed = speed;
		this.wheelNum = wheelNum;
	}
	/*
	public String toString() {
		return "그녀의 자동차는 "+this.carColor
			  +"이고, 현재 속도는 "+this.speed
			  +" 바퀴수는 "+this.wheelNum;
	}
	*/
}
