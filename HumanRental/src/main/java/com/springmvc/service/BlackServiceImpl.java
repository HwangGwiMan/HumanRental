package com.springmvc.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Black;
import com.springmvc.repository.BlackRepository;

@Service
public class BlackServiceImpl implements BlackService {
	
	@Autowired
	BlackRepository blackRepository;
	
	@Override
	public void registBlack(Black black) throws DataIntegrityViolationException {
		blackRepository.registBlack(black);
	}

	@Override
	public List<Black> getBlackList() {
		return blackRepository.getBlackList();
	}
	
	
}
