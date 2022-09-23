package com.example.demo;


class Param {
	int ival;
}
public class TestParam {
	
	void effectParam(Param p) {
		p = new Param();
		p.ival = 500;
		System.out.println("sub ival ==>"+p.ival); // 500
	}
	
	public static void main(String[] args) {
		Param p = new Param();
//		Param p = null;
		p.ival = 100;
		TestParam tp = new TestParam();
		tp.effectParam(p); // 주소번지 넘김
		System.out.println("main ival ==>"+p.ival); // 100
	}
}
