package com.springmvc.repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.springmvc.domain.Black;

public interface BlackRepository {
	public void registBlack(Black black) throws DataIntegrityViolationException;
	public List<Black> getBlackList(String sort, String sortTarget);
	void removeBlack(String blackId);
}
