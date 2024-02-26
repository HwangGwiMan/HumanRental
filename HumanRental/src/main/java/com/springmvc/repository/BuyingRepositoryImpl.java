package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.springmvc.domain.Board;
import com.springmvc.domain.Buying;

@Repository
public class BuyingRepositoryImpl implements BuyingRepository{
	
	// JDBC
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Buying> BuyingList(String category) {

		ArrayList<Buying> list = new ArrayList<Buying>();
		String sql;
		
		if(category==null)
			sql = "select * from buying ORDER BY buyingId DESC";
		else
			sql = "select * from buying where category like '%"+category+"%' ORDER BY buyingId DESC";
			
		try {
            list = (ArrayList<Buying>)template.query(sql, new BuyingRowMapper());
            return list;
        } 
        catch (Exception ex) {
            System.out.println("getBoardList() : " + ex);
            return null;
        }
	}
	
	@Override
	public void BuyingCreate(Buying buying) {
		String sql = "insert into buying values(?,?,?,?,?,?,?,?,?,?,?)";
		template.update(sql, buying.getBuyingId(), buying.getMemberId(), buying.getNickname(), buying.getIntroduction(), 
				buying.getStarRate(), buying.getTitle(), buying.getContent(), buying.getRegist_day(), buying.getCategory(), 
				buying.getPrice(), buying.getLocation());
	}

	@Override
	public Buying BuyingDetailbyId(String buyingId) {
		String sql = "select * from buying where buyingId = ? ";
		Buying buying = template.queryForObject(sql, new BuyingRowMapper(), buyingId);
		return buying;
	}

	@Override
	public void BuyingDelete(String buyingId) {
		String sql = "delete from buying where buyingId=?";
		template.update(sql, buyingId);
	}

	@Override
	public void BuyingUpdate(Buying buying) {
		String sql = "update buying set `title` = ?, `content` = ?, `price` = ?, `location` = ?, `category` = ? where buyingId=?";
		template.update(sql, buying.getTitle(), buying.getContent(), buying.getPrice(), 
				buying.getLocation(), buying.getCategory(), buying.getBuyingId());
	}

	@Override
	public List<Buying> getBuyingListById(String memberId) {
		
		ArrayList<Buying> list = new ArrayList<Buying>();
		String sql = "select * from buying where memberId = ?";
		
        list = (ArrayList<Buying>)template.query(sql, new BuyingRowMapper(), memberId);
        return list;
	}
	
}