package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.protocol.Resultset;
import com.springmvc.domain.Buying;
import com.springmvc.domain.Mentee;
import com.springmvc.domain.Save;
import com.springmvc.domain.Selling;
import com.springmvc.util.Utility;

@Repository
public class SaveRepositoryImpl implements SaveRepository{

	
	
	// JDBC
	private JdbcTemplate template;
				Resultset resultset;
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public void insertSavelist (Buying buying ,String memberId) {
		
		System.out.println("buying insert 넣는 sql 구문이 있는곳이다 와줘");
		Save save = new Save();
		save.setSaveListId(buying.getBuyingId());
		save.setMemberId(memberId);
		save.setCategory(buying.getCategory());
		save.setNickname(buying.getNickname());
		save.setTitle(buying.getTitle());
		save.setPrice(buying.getPrice());
		save.setContent(buying.getContent());
		
		String SQL ;
		
		SQL = "INSERT INTO save (saveListId, memberId, category, nickname, title, price, content) VALUES (?, ?, ?, ?, ?, ?, ?)";
		template.update(SQL, save.getSaveListId(), save.getMemberId(), save.getCategory(), save.getNickname(), save.getTitle(), save.getPrice(), save.getContent());
		System.out.println("SQL구문을 뛰어넘고 여기로 와줭");
	}
	@Override
	public void insertSavelist(Selling selling, String memberId) {
		
		System.out.println("여긴 들어오니?");
		Save save = new Save();
		save.setSaveListId(selling.getSellingId());
		save.setMemberId(memberId);
		save.setCategory(selling.getCategory());
		save.setNickname(selling.getNickname());
		save.setTitle(selling.getTitle());
		save.setPrice(selling.getPrice());
		save.setContent(selling.getContent());
		
		String SQL ;
		
		SQL = "INSERT INTO save (saveListId, memberId, category, nickname, title, price, content) VALUES (?, ?, ?, ?, ?, ?, ?)";
		template.update(SQL, save.getSaveListId(), save.getMemberId(), save.getCategory(), save.getNickname(), save.getTitle(), save.getPrice(), save.getContent());
		System.out.println("SQL구문을 뛰어넘고 여기로 와줭");
	}
	
	

	@Override
	public List<Save> getsaveinformation(String memberId) {
	    System.out.println("이거 save sql 셀렉 구문인데  구문인데 여기 까진 오고 있니?");
	    
	    String SQL = "select * from save where memberId = ?";
	    List<Save> savelist = template.query(SQL, new Object[]{memberId}, new SaveRowMapper());
	    
	    return savelist;
	}

	
	@Override
	public boolean checksaveinformation(String memberId ,String savelistId) {
	    String SQL = "select count(*) from save where memberId = ? and saveListId=?";
	    boolean result = false;
	    try {
	        result = template.queryForObject(SQL, new Object[]{memberId, savelistId}, Integer.class) > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println("result="+result);
	    return result;
	}

	@Override
	public void deletesavelist(String savelistid) {
//		String SQL = "delete from MenteeProfile where memberId=?";  
//		template.update(SQL,memberId);
		String SQL ="delete  from save where saveListId=?";
		template.update(SQL,savelistid);
	}
	@Override
	public boolean ajaxchecksavelist(String savelistId) {
	    String SQL = "SELECT COUNT(*) FROM save WHERE saveListId = ?";
	    int rowCount = 0;
	    try {
	        rowCount = template.queryForObject(SQL, new Object[]{savelistId}, Integer.class);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println("여긴 오니?");
	    return rowCount > 0; // '찜' 목록에 하나 이상 존재하면 true 반환
	};
	
	
}
