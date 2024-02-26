package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Buying;
import com.springmvc.domain.Selling;

@Repository
public class SellingRepositoryImpl implements SellingRepository{
	
	// JDBC
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Selling> SellingList(String category) {

		ArrayList<Selling> list = new ArrayList<Selling>();
		String sql;
		
		if(category==null)
			sql = "select * from selling ORDER BY sellingId DESC";
		else
			sql = "select * from selling where category like '%"+category+"%' ORDER BY sellingId DESC";
			
		try {
            list = (ArrayList<Selling>)template.query(sql, new SellingRowMapper());
            return list;
        } 
        catch (Exception ex) {
            System.out.println("getBoardList() : " + ex);
            return null;
        }
	}
	
	@Override
	public void SellingCreate(Selling selling) {
		String sql = "insert into selling values(?,?,?,?,?,?,?,?,?,?,?)";
		template.update(sql, selling.getSellingId(), selling.getMemberId(), selling.getNickname(), selling.getIntroduction(), 
				selling.getStarRate(), selling.getTitle(), selling.getContent(), selling.getRegist_day(), selling.getCategory(), 
				selling.getPrice(), selling.getLocation());
	}

	@Override
	public Selling SellingDetailbyId(String sellingId) {
		String sql = "select * from selling where sellingId = ? ";
		Selling selling = template.queryForObject(sql, new SellingRowMapper(), sellingId);
		return selling;
	}

	@Override
	public void SellingDelete(String sellingId) {
		String sql = "delete from selling where sellingId=?";
		template.update(sql, sellingId);
	}

	@Override
	public void SellingUpdate(Selling selling) {
		String sql = "update selling set `title` = ?, `content` = ?, `price` = ?, `location` = ?, `category` = ? where sellingId=?";
		template.update(sql, selling.getTitle(), selling.getContent(), selling.getPrice(), 
				selling.getLocation(), selling.getCategory(), selling.getSellingId());
	}
	
	@Override
	public List<Selling> getSellingListById(String memberId) {
		
		ArrayList<Selling> list = new ArrayList<Selling>();
		String sql = "select * from selling where memberId = ?";
		
        list = (ArrayList<Selling>)template.query(sql, new SellingRowMapper(), memberId);
        return list;
	}
	
	
}