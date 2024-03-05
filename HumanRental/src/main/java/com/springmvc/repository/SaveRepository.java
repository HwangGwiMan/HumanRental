package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Save;
import com.springmvc.domain.Selling;

public interface SaveRepository {

	public void insertSavelist (Buying buying ,String memberId);
	public void insertSavelist (Selling selling ,String memberId);
	public List<Save> getsaveinformation(String memberId);
	public void deletesavelist(String savelistid);
	public  boolean checksaveinformation(String memberId ,String savelistId);
}
