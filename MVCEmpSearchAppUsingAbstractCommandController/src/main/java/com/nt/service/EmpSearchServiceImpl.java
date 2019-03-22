package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.EmpSearchBO;
import com.nt.bo.EmpSearchResultBO;
import com.nt.dao.EmpSearchDAO;
import com.nt.dto.EmpSearchDTO;
import com.nt.dto.EmpSearchResultDTO;

public class EmpSearchServiceImpl implements EmpSearchService {
	private EmpSearchDAO dao;
	


	
	

	public EmpSearchServiceImpl(EmpSearchDAO dao) {
		
		this.dao = dao;
	}






	@Override
	public List<EmpSearchResultDTO> process(EmpSearchDTO sdto) {
		// TODO Auto-generated method stub
		//convert searchDTO obj to searchbo obj
		EmpSearchBO sbo = new EmpSearchBO();
		sbo.setNo(sdto.getNo());
		sbo.setName(sdto.getName());
		sbo.setDesg(sdto.getDesg());
		sbo.setSalary(sdto.getSalary());
		//use DAO
		List<EmpSearchResultBO> listBO=dao.search(sbo);
		//convert listBo tp List DTO
		List<EmpSearchResultDTO> listDTO=new ArrayList<EmpSearchResultDTO>();
		for(EmpSearchResultDTO rbo:listDTO) {
			EmpSearchResultDTO rdto=new EmpSearchResultDTO();
			rdto.setNo(rbo.getNo());
			rdto.setName(rbo.getName());
			rdto.setDeptno(rbo.getDeptno());
			rdto.setDesg(rbo.getDesg());
			rdto.setSalary(rbo.getSalary());
			rdto.setMgrno(rbo.getMgrno());
			listDTO.add(rdto);
		}
		return listDTO;
	}

}
