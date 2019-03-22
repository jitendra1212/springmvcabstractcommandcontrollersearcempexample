package com.nt.service;

import java.util.List;

import com.nt.dto.EmpSearchDTO;
import com.nt.dto.EmpSearchResultDTO;

public interface EmpSearchService {
	public List<EmpSearchResultDTO> process(EmpSearchDTO sdto);
		


}
