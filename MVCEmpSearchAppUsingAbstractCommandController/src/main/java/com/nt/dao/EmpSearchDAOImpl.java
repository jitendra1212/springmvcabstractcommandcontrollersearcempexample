package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.EmpSearchBO;
import com.nt.bo.EmpSearchResultBO;

public class EmpSearchDAOImpl implements EmpSearchDAO {
	private static final 
	String EMP_SEARCH_QUERY="select empno,ename,job,sal,mgr,deptno from emp"+" where (empno is not null and empno=?)"
	
			+ " or (ename is not null and ename like ?)"
			+" or (job is not null and job like ?)"
			+" or (sal is not null and sal=?)";
	
	private JdbcTemplate jt;

	

	public EmpSearchDAOImpl(JdbcTemplate jt) {
	
		this.jt = jt;
	}
	@Override
	public List<EmpSearchResultBO> search(EmpSearchBO ebo) {
		// TODO Auto-generated method stub
		List<EmpSearchResultBO> listRBO =jt.query(EMP_SEARCH_QUERY,new EmpRowMapper(),ebo.getNo(),ebo.getName(),ebo.getDesg(),ebo.getSalary());
		
		return listRBO;
	}
	private static final class EmpRowMapper implements RowMapper<EmpSearchResultBO>{

		@Override
		public EmpSearchResultBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			//copy resultset record into search result bo obj
			EmpSearchResultBO rbo=new EmpSearchResultBO();
			rbo.setNo(rs.getInt(1));
			rbo.setName(rs.getString(2));
			rbo.setDesg(rs.getString(3));
			
			rbo.setSalary(rs.getInt(4));
			rbo.setMgrno(rs.getInt(5));
			rbo.setDeptno(rs.getInt(6));
			return rbo;
		}
		
	}

}
