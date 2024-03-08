package com.springmvc.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.springmvc.domain.Black;

public interface BlackService {
	public void registBlack(Black black) throws DataIntegrityViolationException;
	public List<Black> getBlackList(String sort, String sortTarget);
	void removeBlack(String blackId);
}
