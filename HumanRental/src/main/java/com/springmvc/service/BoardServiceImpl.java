package com.springmvc.service;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springmvc.domain.Board;
import com.springmvc.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{
	
	static final int LISTCOUNT = 10; 

	@Autowired
	BoardRepository boardRepository;
	
	public void BoardList(Model model, HttpServletRequest request,int pageNum){
		
		int limit=LISTCOUNT;

		String items = request.getParameter("items");
		String text = request.getParameter("text");
		
		int total_record=boardRepository.getListCount(items, text);
		List<Board> boardlist = boardRepository.getBoardList(pageNum, limit, items, text); 
		
		int total_page;
		
		if (total_record % limit == 0) {     
	        total_page = total_record / limit;
	    } else {
	        total_page = total_record / limit;
	        total_page = total_page + 1; 
	    }   
		
		model.addAttribute("pageNum", pageNum);		  
		model.addAttribute("total_page", total_page);   
		model.addAttribute("total_record",total_record); 
		model.addAttribute("boardlist", boardlist);
		
		System.out.println("pageNum="+pageNum);
		System.out.println("total_page="+total_page);
		System.out.println("total_record="+total_record);
		System.out.println("boardlist="+boardlist);
	}

	@Override
	public void insertBoard(Board board, String MemberId) {
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
		String regist_day = formatter.format(new java.util.Date()); 
		
		board.setMemberId(MemberId);
		board.setHit(0);
		board.setRegist_day(regist_day);
		boardRepository.insertBoard(board);
		
	}

	@Override
	public int getListCount(String items, String text) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board> getBoardList(int pageNum, int limit, String items, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoginNameById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHit(int BoardId) {
		boardRepository.updateHit(BoardId);
		
	}

	@Override
	public Board getBoardByNum(int BoardId, int page) {
		Board board = boardRepository.getBoardByNum(BoardId, page);
		return board;
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		
	}
	
	
}
