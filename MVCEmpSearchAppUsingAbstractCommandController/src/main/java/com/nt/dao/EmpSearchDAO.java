package com.nt.dao;

import java.util.List;

import com.nt.bo.EmpSearchBO;
import com.nt.bo.EmpSearchResultBO;

public interface EmpSearchDAO {
	public List<EmpSearchResultBO> search(EmpSearchBO ebo);
	

}
