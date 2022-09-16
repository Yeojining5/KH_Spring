package com.mvc.kh;

public class DiTest {
	
	Service service = new Service();
	
	//View view = new View(); // 이렇게만 하면 디폴트 생성자를 탐->NullPointerException
	
	View view = new View(service);
	
	public void testRun() {
		view.methodA();
	}
	
	public static void main(String[] args) {
		DiTest dt = new DiTest();
		dt.testRun();
	}

}
