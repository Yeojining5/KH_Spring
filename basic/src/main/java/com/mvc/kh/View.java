package com.mvc.kh;

public class View {
	Service service = null;
	
	public View () {
		
	}
	
	public View(Service service) {
		this.service = service;
	}
	
	public void methodA() {
		System.out.println(service);
		// 생성자 선택의 문제
		// 호출 위치의 문제
		// 500번 문제를 피할 수 있도록 관리를 받자 - spring framework
		// DI를 통해 문제를 관리받을 수 있음
		service.methodB(); // 생성자의 선택에 따라 NullpointerException이 발생할 수 있다.
	}
}
