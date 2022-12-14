package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// ApplicationContext vs BeanFactory -> 컨테이너의 종류

public class SonataSimulation2 {
	
	// 게으른 인스턴스화 - 시점에 대한 문제
	// 언제 초기화가 되나?
//	Sonata myCar = null;
	
	// 이른 인스턴스화
//	Sonata herCar = new Sonata();
	
	void methodA() {
		//System.out.println(herCar.speed);
		
		// 게으른 인스턴스화! -> 이것을 스프링이 해준다는 것
//		myCar = new Sonata();
//		System.out.println(myCar.speed);
	}
	
	public static void main(String[] args) {
		SonataSimulation2 ss = new SonataSimulation2();
//		ss.methodA();
		// 스프링에서는 xml문서에 선언된 클래스 정보를 얻어와서 자바코드에 쓸 수 잇또록
		// 제공하는 클래스가 있음
		ApplicationContext context 
		= new ClassPathXmlApplicationContext("com\\spring4\\mvc\\sonataBean.xml");
		Sonata myCar = (Sonata)context.getBean("myCar");
		Sonata herCar = (Sonata)context.getBean("herCar"); // 인스턴스화 대신임!!
		// 어, 그런데 생성자가 여러개 잖아??
		// 이런 경우 그 중에 누가 호출되나요?
		System.out.println(herCar.speed); // 0
//		System.err.println(herCar.carName); // null
		System.err.println(herCar.carColor); // null
		
		System.out.println(myCar);
		System.out.println(myCar.speed);
//		System.out.println(myCar.carName);
		System.out.println("객체관리 책임이 개발자에게 있는 경우");
		System.out.println("-----------------------------------------------");
		
		myCar = new Sonata();
		System.out.println(myCar);
		System.out.println(myCar.speed);
//		System.out.println(myCar.carName);
		System.out.println("-----------------------------------------------");
		
		// Candidate 상태에 빠짐 - 34번에서 생성된 객체는 쓰레기값으로 인식되어 자원을 회수 당함
		myCar = null;
		myCar = new Sonata();
		System.out.println("null초기화 후에 비교 " + myCar);
		System.out.println(myCar.speed);
//		System.out.println(myCar.carName);
	
	}

}
