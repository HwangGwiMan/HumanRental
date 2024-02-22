package com.springmvc.service;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springmvc.domain.Board;

public interface BoardService {
	//보드1 (자유게시판)
	public void BoardList(Model model, HttpServletRequest request, int pageNum);
	
	//board 테이블에 새로운 글 삽입하기
	public void insertBoard(Board board, String memberId);
	
	//선택된 글의 조회 수 증가시키기
	public void updateHit(int boardId);
	
	//선택된 글 상세 내용 가져오기
	public Board getBoardByNum(int boardId, int page);
	
	//선택된 글 내용 수정하기
	public void updateBoard(Board board);
	
	//선택된 글 삭제하기
	public void deleteBoard(int boardId);
	

	//보드2 (공지사항)
	public void BoardList2(Model model, HttpServletRequest request, int pageNum);
	
	//board 테이블에 새로운 글 삽입하기
	public void insertBoard2(Board board, String memberId);
	
	//선택된 글의 조회 수 증가시키기
	public void updateHit2(int boardId);
	
	//선택된 글 상세 내용 가져오기
	public Board getBoardByNum2(int boardId, int page);
	
	//선택된 글 내용 수정하기
	public void updateBoard2(Board board);
	
	//선택된 글 삭제하기
	public void deleteBoard2(int boardId);
	
	//선택된 글 멤버 ID 가져오기
	public String getMemberIdByBoardId(int boardId);
}
