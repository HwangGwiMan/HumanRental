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
	}
	@Override
	public void insertSavelist(Selling selling, String memberId) {
		
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
	}
	
	

	@Override
	public List<Save> getsaveinformation(String memberId) {
	    
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
		String SQL ="delete  from save where saveListId=?";
		template.update(SQL,savelistid);
	}

	
}
