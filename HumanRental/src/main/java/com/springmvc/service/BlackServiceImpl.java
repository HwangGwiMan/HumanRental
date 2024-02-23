package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.domain.Black;
import com.springmvc.repository.BlackRepository;

public class BlackServiceImpl implements BlackService {
	
	@Autowired
	BlackRepository blackRepository;
	
	@Override
	public void registBlack(Black black) {
		blackRepository.registBlack(black);
	}
}
