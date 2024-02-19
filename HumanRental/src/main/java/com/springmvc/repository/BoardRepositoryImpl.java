package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Board;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

	// JDBC
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	
	// 보드1 (자유게시판)

	@Override
	public int getListCount(String items, String text) {
		
		int x = 0;

		String sql;
		
		try {
			if (items == null && text == null) {
				sql = "select count(*) from board";
	        	x=template.queryForObject(sql, Integer.class);
			}
			else {
				sql = "select count(*) from board where " + items + "like '%" + text + "%'";
	        	x=template.queryForObject(sql, Integer.class);
			}
		} 
		catch (Exception ex) {
			System.out.println("getListCount() : " + ex);
		}
		return x;
	}

	@Override
	public List<Board> getBoardList(int page, int limit, String items, String text) {
		
		int total_record = getListCount(items, text);
        int start = (page - 1) * limit;

        String sql;
        
        if (items == null && text == null)
            sql = "select * from board ORDER BY boardId DESC LIMIT ?, ?";
        else
            sql = "SELECT * FROM board where " + items + " like '%" + text + "%' ORDER BY boardId DESC LIMIT ?, ?";

        ArrayList<Board> list = new ArrayList<Board>();

        try {
            list = (ArrayList<Board>)template.query(sql, new BoardRowMapper(), start, limit);
            return list;
        } 
        catch (Exception ex) {
            System.out.println("getBoardList() : " + ex);
            return null;
        }
	}

	@Override
	public void insertBoard(Board board) {
		String sql = "insert into board values(?,?,?,?,?,?,?)";
		template.update(sql, board.getBoardId(), board.getMemberId(), board.getName(), board.getTitle(), board.getContent(), board.getRegist_day(), board.getHit());
	}

	@Override
	public void updateHit(int BoardId) {
		String sql = "select hit from board where BoardId = ?";
		int hit = template.queryForObject(sql, Integer.class, BoardId);
		hit = hit+1;
		sql = "update board set hit=? where BoardId=?";
		template.update(sql, hit, BoardId);
	}

	@Override
	public Board getBoardByNum(int boardId, int page) {
		String sql = "select * from board where boardId = ? ";
		Board board = template.queryForObject(sql, new BoardRowMapper(), boardId);
		
		return board;
	}

	@Override
	public void updateBoard(Board board) {
		String sql = "update Board set `title` = ?, `content` = ? where boardId=?";
		template.update(sql, board.getTitle(), board.getContent(), board.getBoardId());
	}

	@Override
	public void deleteBoard(int boardId) {
		String sql = "delete from board where boardId=?";
		template.update(sql, boardId);
		
	}


	//보드2 (공지사항)

	@Override
	public int getListCount2(String items, String text) {
		
		int x = 0;

		String sql;
		
		try {
			if (items == null && text == null) {
				sql = "select count(*) from board2";
	        	x=template.queryForObject(sql, Integer.class);
			}
			else {
				sql = "select count(*) from board2 where " + items + " like '%" + text + "%'";
	        	x=template.queryForObject(sql, Integer.class);
			}
		} 
		catch (Exception ex) {
			System.out.println("getListCount2() : " + ex);
		}
		return x;
	}


	@Override
	public List<Board> getBoardList2(int page, int limit, String items, String text) {
		
		int total_record = getListCount2(items, text);
        int start = (page - 1) * limit;

        String sql;

        if (items == null && text == null)
            sql = "select * from board2 ORDER BY boardId DESC LIMIT ?, ?";
        else
            sql = "SELECT * FROM board2 where " + items + " like '%" + text + "%' ORDER BY num DESC LIMIT ?, ?";

        ArrayList<Board> list = new ArrayList<Board>();

        try {
            list = (ArrayList<Board>)template.query(sql, new BoardRowMapper(), start, limit);
            return list;
        } 
        catch (Exception ex) {
            System.out.println("getBoardList2() : " + ex);
            return null;
        }
	}


	@Override
	public void insertBoard2(Board board) {
		String sql = "insert into board2 values(?,?,?,?,?,?,?)";
		template.update(sql, board.getBoardId(), board.getMemberId(), board.getName(), board.getTitle(), board.getContent(), board.getRegist_day(), board.getHit());	
	}


	@Override
	public void updateHit2(int BoardId) {
		String sql = "select hit from board2 where BoardId = ?";
		int hit = template.queryForObject(sql, Integer.class, BoardId);
		hit = hit+1;
		sql = "update board2 set hit=? where BoardId=?";
		template.update(sql, hit, BoardId);
	}


	@Override
	public Board getBoardByNum2(int boardId, int page) {
		String sql = "select * from board2 where boardId = ? ";
		Board board = template.queryForObject(sql, new BoardRowMapper(), boardId);
		
		return board;
	}


	@Override
	public void updateBoard2(Board board) {
		String sql = "update Board2 set `title` = ?, `content` = ? where boardId=?";
		template.update(sql, board.getTitle(), board.getContent(), board.getBoardId());
	}

	@Override
	public void deleteBoard2(int boardId) {
		String sql = "delete from board2 where boardId=?";
		template.update(sql, boardId);
	}
	
}
