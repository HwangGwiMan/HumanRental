package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Save;
import com.springmvc.domain.Selling;

public interface SaveService {
	
	public  void insertSavelist(Buying buying ,String memberId);
	public  void insertSavelist(Selling buying ,String memberId);
	public List<Save> getsaveinformation(String memberId);
	public void deletesavelist(String savelistid);
	public  boolean checksaveinformation(String memberId,String savelistId);
	public boolean	ajaxchecksavelist(String savelistId);
}
