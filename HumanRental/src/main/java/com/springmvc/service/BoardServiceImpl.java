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
//		System.out.println("items="+items);
//		System.out.println("text="+text);
		
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
	}
	
	



	@Override
	public void insertBoard(Board board, String memberId) {
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
		String regist_day = formatter.format(new java.util.Date()); 
		
		board.setMemberId(memberId);
		board.setHit(0);
		board.setRegist_day(regist_day);
		boardRepository.insertBoard(board);
	}

	@Override
	public void updateHit(int boardId) {
		boardRepository.updateHit(boardId);
	}

	@Override
	public Board getBoardByNum(int boardId, int page) {
		Board board = boardRepository.getBoardByNum(boardId, page);
		return board;
	}

	@Override
	public void updateBoard(Board board) {
		boardRepository.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardId) {
		boardRepository.deleteBoard(boardId);
	}

	@Override
	public void BoardList2(Model model, HttpServletRequest request, int pageNum) {
		
		int limit=LISTCOUNT;

		String items = request.getParameter("items");
		String text = request.getParameter("text");
		
		int total_record=boardRepository.getListCount2(items, text);
		List<Board> boardlist = boardRepository.getBoardList2(pageNum, limit, items, text); 
		
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
	}

	@Override
	public void insertBoard2(Board board, String memberId) {
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
		String regist_day = formatter.format(new java.util.Date()); 
		
		board.setMemberId(memberId);
		board.setHit(0);
		board.setRegist_day(regist_day);
		boardRepository.insertBoard2(board);
	}

	@Override
	public void updateHit2(int boardId) {
		boardRepository.updateHit2(boardId);
	}

	@Override
	public Board getBoardByNum2(int boardId, int page) {
		Board board = boardRepository.getBoardByNum2(boardId, page);
		return board;
	}

	@Override
	public void updateBoard2(Board board) {
		boardRepository.updateBoard2(board);
	}

	@Override
	public void deleteBoard2(int boardId) {
		boardRepository.deleteBoard2(boardId);
	}

	@Override
	public String getMemberIdByBoardId(int boardId) {
		return boardRepository.getMemberIdByBoardId(boardId);
	}

}
