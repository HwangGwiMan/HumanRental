package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;
import com.springmvc.domain.Buying;
import com.springmvc.domain.Mentee;
import com.springmvc.domain.Save;
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
		
		System.out.println("여긴 들어오니?");
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
	public List<Save> getsaveinformation(String memberId) {
	    System.out.println("이거 save sql 셀렉 구문인데  구문인데 여기 까진 오고 있니?");
	    
	    String SQL = "select * from save where memberId = ?";
	    List<Save> savelist = template.query(SQL, new Object[]{memberId}, new SaveRowMapper());
	    
	    return savelist;
	};
	
	
}
