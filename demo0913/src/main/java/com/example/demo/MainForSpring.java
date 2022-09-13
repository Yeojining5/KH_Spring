package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.controller.TestController;

import config.ControllerConfig;
import config.ControllerConfig2;

public class MainForSpring {

	public static void main(String[] args) {
		// 이른 인스턴스화
		// 하나를 가지고 2개의 ConrollerConfig를 열거형으로 파라미터로 추가하면 됨
		ApplicationContext ctx 
			= new AnnotationConfigApplicationContext(ControllerConfig.class, ControllerConfig2.class);
	
		TestController testController 
			= ctx.getBean("testController", TestController.class);
	
		testController.testList();
		
	}

}
