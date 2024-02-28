package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Save;

public interface SaveRepository {

	public void insertSavelist (Buying buying ,String memberId);
	public List<Save> getsaveinformation(String memberId);
	
}
