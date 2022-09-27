package com.example.demo.vo;

import lombok.Data;

@Data
public class MemberVO {
	
	private int mem_no			= 0;
	private String mem_id		= null;
	private String mem_pw		= null;
	private String mem_name		= null;
	private String mem_zipcode	= null;
	private String mem_address	= null;
	
	// member테이블에는 없는 컬럼이지만 업무처리를 위해 필요한 변수선언 - 기능적으로 필요..
	private int count = 0;

}
