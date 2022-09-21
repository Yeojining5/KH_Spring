package com.example.demo.vo;

import lombok.Data;

// Getters and Setters 필요없이 lombok으로 간단하게!
@Data
public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;

}
