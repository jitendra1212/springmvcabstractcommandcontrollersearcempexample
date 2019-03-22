package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.EmpSearchCommand;
import com.nt.dto.EmpSearchDTO;
import com.nt.dto.EmpSearchResultDTO;
import com.nt.service.EmpSearchService;

public class EmpSearchController extends AbstractCommandController{
	private EmpSearchService service;
	



	public EmpSearchController(EmpSearchService service) {
	
		this.service = service;
	}




	@Override
	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object cmd,
			BindException errors) throws Exception {
		// TODO Auto-generated method stub
		//get command obj
		EmpSearchCommand command = (EmpSearchCommand)cmd;
		//convert command obj into DTO obj
		EmpSearchDTO dto = new EmpSearchDTO();
		dto.setNo(command.getNo());
		dto.setName(command.getName());
		dto.setDesg(command.getDesg());
		dto.setSalary(dto.getSalary());
		List<EmpSearchResultDTO> listRDTO=service.process(dto);
		
		return new ModelAndView("listEmps","searchResults", listRDTO);
	}

}
