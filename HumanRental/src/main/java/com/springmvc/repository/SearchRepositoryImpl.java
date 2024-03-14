package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;
import com.springmvc.domain.Buying;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.Save;
import com.springmvc.domain.Selling;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

	
	// JDBC
	private JdbcTemplate template;
				Resultset resultset;
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	//전체 검색할때 쓰는 sql 구문 
	@Override
	public List<Selling> getAllSellingInformation(String search) {
	    String SQL = "SELECT * FROM selling WHERE introduction LIKE ? OR title LIKE ? OR content LIKE ? OR category LIKE ? OR location LIKE ? OR nickname LIKE ?";
	    List<Selling> sellingList = template.query(SQL, new Object[]{"%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%"}, new SellingRowMapper());
	    return sellingList;
	}

	@Override
	public List<Buying> getAllBuyingInformation(String search, int pageSize, int totalcount) {
		   List<Buying> buyingList = new ArrayList();
	    int pages = (totalcount + pageSize - 1) / pageSize; // 전체 페이지 수를 계산합니다.

	    for (int i = 0; i < pages; i++) {
	        int start = i * pageSize; // 시작 인덱스를 계산합니다.
	        int end = Math.min(pageSize, totalcount - start); // 끝 인덱스를 계산합니다.

	        String SQL = "SELECT * FROM buying WHERE introduction LIKE ? OR title LIKE ? OR content LIKE ? OR category LIKE ? OR location LIKE ? OR nickname LIKE ? ORDER BY regist_day DESC LIMIT ? OFFSET ?"; // 'num' 대신 'regist_day'를 사용합니다.

	       buyingList = template.query(SQL, new Object[]{"%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", end, start}, new BuyingRowMapper()); // 'end'와 'start'를 사용합니다.

	        // buyingList를 페이지에 따라 추가하거나 업데이트합니다.
	    }

	    return buyingList;
	}

	@Override
	public List<Map<String, Object>> getAllMentorProfileInformaiton(String search) {
	    String SQL = "SELECT member.nickname, mentorprofile.category, mentorprofile.introduction " +
                "FROM member " +
                "JOIN mentor ON member.memberId = mentor.memberId " +
                "JOIN mentorprofile ON mentor.mentorId = mentorprofile.mentorId " +
                "WHERE member.nickname LIKE ?";
   
   String searchPattern = "%" + search + "%";
   Object[] params = {searchPattern};
   
   List<Map<String, Object>> mentorProfileList = template.query(SQL, new RowMapper<Map<String, Object>>() {
       @Override
       public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
           Map<String, Object> map = new HashMap<>();
           map.put("nickname", rs.getString("nickname"));
           map.put("category", rs.getString("category"));
           map.put("introduction", rs.getString("introduction"));
           return map;
       }
   }, params);
   
   System.out.println("dddd");
   return mentorProfileList;
	}


	    
	


	public  int  CountGetAllBuyingInformation(String search){
		String SQL = "SELECT COUNT(*) FROM buying WHERE introduction LIKE ? OR title LIKE ? OR content LIKE ? OR category LIKE ? OR location LIKE ? OR nickname LIKE ?";
		// '?' 자리에 들어갈 값들을 배열로 생성
		Object[] params = new Object[] {"%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%"};
		int totalcount = template.queryForObject(SQL, params, Integer.class);

		return totalcount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	//제목 검색할때 쓰는 sql 구문 
	@Override
	public List<Buying> getTitleBuyingInformation(String search) {
		 String SQL = "SELECT * FROM buying WHERE title LIKE ?";
		 List<Buying> buyingList = template.query(SQL, new Object[]{"%" + search + "%"}, new BuyingRowMapper());
		 return buyingList;
	}
	
	@Override
	public List<Selling> getTitleSellingInformation(String search) {
	    String SQL = "SELECT * FROM selling WHERE title LIKE ?";
	    List<Selling> sellingList = template.query(SQL, new Object[]{"%" + search + "%"}, new SellingRowMapper());
	    return sellingList;
	
	}

	//내용 검색할때 쓰는 sql 구문 
	@Override
	public List<Buying> getContentBuyingInformation(String search) {
		String SQL = "SELECT * FROM buying WHERE content LIKE ?";
		List<Buying> buyingList = template.query(SQL, new Object[]{"%" + search + "%"}, new BuyingRowMapper());
		return buyingList;
	}

	@Override
	public List<Selling> getContentSellingInformation(String search) {
		String SQL = "SELECT * FROM selling WHERE content LIKE ?";
	    List<Selling> sellingList = template.query(SQL, new Object[]{"%" + search + "%"}, new SellingRowMapper());
	    return sellingList;
		
	}
	
	//닉네임으로 검색할때 쓰는 sql 구문 
	@Override
	public List<Buying> getNicknameBuyingInformation(String search) {
		String SQL = "SELECT * FROM buying WHERE nickname LIKE ?";
		List<Buying> buyingList = template.query(SQL, new Object[]{"%" + search + "%"}, new BuyingRowMapper());
		return  buyingList;
	}

	@Override
	public List<Selling> getNicknameSellingInformation(String search) {
		String SQL = "SELECT * FROM buying WHERE nickname LIKE ?";
		List<Selling> buyingList = template.query(SQL, new Object[]{"%" + search + "%"}, new SellingRowMapper());
		return null;
	}

	
}
