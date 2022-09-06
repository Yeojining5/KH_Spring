package com.di;

import org.apache.log4j.Logger;

public class Sonata2 {
	Logger logger = Logger.getLogger(Sonata2.class);
	int speed = 10;
	String carName = "23년형 소나타";
	String carColor = "흰색";
	
	public Sonata2() {
		logger.info("Sonata 디폴트 생성자 호출");
	}
	
	public Sonata2(int speed) {
		this.speed = speed;
	}
	
	public Sonata2(int speed, String carColor) {
		this.speed = speed;
		this.carColor = carColor;
	}
	
	public Sonata2(int speed, String carName, String carColor) {
		this.speed = speed;
		this.carName = carName;
		this.carColor = carColor;
	}
	
}