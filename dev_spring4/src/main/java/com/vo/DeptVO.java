package com.vo;
// VO패턴은 로우를 담는게 아니라 컬럼을 담는다 -> 라고 생각하자 - 1건만 담을 수 있다.
// DeptV[] - 객체 배열이면 n개의 로우를 담을 수 있따.
// 그러나 크기를 조정불가
// List<VO>

public class DeptVO {
	private int deptno=5;
	private String dname;
	private String loc;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
