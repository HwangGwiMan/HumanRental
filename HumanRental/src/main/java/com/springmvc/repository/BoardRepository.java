package com.springmvc.repository;

import java.util.List;

import javax.servlet.ServletRequest;

import com.springmvc.domain.Board;

public interface BoardRepository {
	
	//보드1 (자유게시판)
	
	//board 테이블의 레코드 개수
	public int getListCount(String items, String text); 
	
	//board 테이블의 레코드 가져오기
	public List<Board> getBoardList(int page, int limit, String items, String text);
	
	//board 테이블에 새로운 글 삽입하기
	public void insertBoard(Board board);
	
	//선택된 글의 조회 수 증가시키기
	public void updateHit(int BoardId);
	
	//선택된 글 상세 내용 가져오기
	public Board getBoardByNum(int boardId, int page);
	
	//선택된 글 내용 수정하기
	public void updateBoard(Board board);
	
	//선택된 글 삭제하기
	public void deleteBoard(int boardId);
	
	
	
	//보드2 (공지사항)
	
	//board 테이블의 레코드 개수
	public int getListCount2(String items, String text); 
	
	//board 테이블의 레코드 가져오기
	public List<Board> getBoardList2(int page, int limit, String items, String text);
	
	//board 테이블에 새로운 글 삽입하기
	public void insertBoard2(Board board);
	
	//선택된 글의 조회 수 증가시키기
	public void updateHit2(int BoardId);
	
	//선택된 글 상세 내용 가져오기
	public Board getBoardByNum2(int boardId, int page);
	
	//선택된 글 내용 수정하기
	public void updateBoard2(Board board);
	
	//선택된 글 삭제하기
	public void deleteBoard2(int boardId);

	public String getMemberIdByBoardId(int boardId);
}
