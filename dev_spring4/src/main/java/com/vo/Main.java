package com.vo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
// 나는 순수한 자바입니다.
// 어떤 추상클래스나 어떤 인터페이스도 상속, implements하지 않은 클래스
// 어떤 메소드도 오버라이드 하지 않아도 된다!
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		DeptVO dVO = ctx.getBean("getDeptVO", DeptVO.class);
		int deptno = dVO.getDeptno();
		String dname = dVO.getDname();
		String loc = dVO.getLoc();
		System.out.println(deptno+", "+dname+", "+loc);
		ctx.close();

	}

}
