package com.nt.dto;

import java.io.Serializable;


public class EmpSearchResultDTO extends EmpSearchDTO implements Serializable {
	private int deptno;
	private int mgrno;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getMgrno() {
		return mgrno;
	}
	public void setMgrno(int mgrno) {
		this.mgrno = mgrno;
	}
	

}
