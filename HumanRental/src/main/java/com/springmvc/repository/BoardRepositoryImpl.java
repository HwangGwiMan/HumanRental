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
	
	@Override
	public List<Board> BoardList(ServletRequest request) {
		return null;
	}

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
				sql = "select count(*) from board where " + items + " like '%" + text + "%'";
	        	x=template.queryForObject(sql, Integer.class);
			}
		} 
		catch (Exception ex) {
			System.out.println("getListCount() : " + ex);
		}
		System.out.println("x="+x);
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
            sql = "SELECT * FROM board where " + items + " like '%" + text + "%' ORDER BY num DESC LIMIT ?, ?";

        ArrayList<Board> list = new ArrayList<Board>();

        try {
        	System.out.println("total_record "+total_record);
        	System.out.println("page " + page);
        	System.out.println("start "+start);
        	System.out.println("limit "+limit);
    		System.out.println("items "+items);
    		System.out.println("text  "+text);

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
	public String getLoginNameById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHit(int BoardId) {
		System.out.println("updateHit 접근");
		String sql = "select hit from board where BoardId = ?";
		int hit = template.queryForObject(sql, Integer.class, BoardId);
		hit = hit+1;
		sql = "update board set hit=? where BoardId=?";
		template.update(sql, hit, BoardId);
	}

	@Override
	public Board getBoardByNum(int BoardId, int page) {
		System.out.println("getBoardByNum 접근");
		String sql = "select * from board where BoardId = ? ";
		Board board = template.queryForObject(sql, new BoardRowMapper(), BoardId);
		
		System.out.println("board 담음");
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
