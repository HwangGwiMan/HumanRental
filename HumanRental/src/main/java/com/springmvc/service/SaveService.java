package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Save;

public interface SaveService {
	
	public  void insertSavelist(Buying buying ,String memberId);
	public List<Save> getsaveinformation(String memberId);
	public void deletesavelist(String savelistid);
}
