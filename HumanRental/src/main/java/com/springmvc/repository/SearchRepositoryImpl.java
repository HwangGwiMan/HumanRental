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
	public List<Buying> getAllBuyingInformation(String search) {


		   List<Buying> buyingList = new ArrayList();
	 
	        String SQL = "SELECT * FROM buying WHERE introduction LIKE ? OR title LIKE ? OR content LIKE ? OR category LIKE ? OR location LIKE ? OR nickname LIKE ? ORDER BY regist_day DESC "; 

	       buyingList = template.query(SQL, new Object[]{"%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%"}, new BuyingRowMapper()); 

	       return buyingList;
	    }
	
	@Override
	public List<Map<String, Object>> getAllMentorProfileInformaiton(String search) {
		   String SQL = "SELECT member.nickname, member.profileImage, mentorprofile.category, mentorprofile.introduction " +
	                 "FROM member " +
	                 "JOIN mentor ON member.memberId = mentor.memberId " +
	                 "JOIN mentorprofile ON mentor.mentorId = mentorprofile.mentorId " +
	                 "WHERE member.nickname LIKE ? OR mentorprofile.category LIKE ? OR mentorprofile.introduction LIKE ?";
	   
	   String searchPattern = "%" + search + "%";
	   Object[] params = {searchPattern, searchPattern, searchPattern}; // 모든 LIKE 조건에 대해 검색 패턴 적용
	   
	   List<Map<String, Object>> mentorProfileList = template.query(SQL, new RowMapper<Map<String, Object>>() {
	       @Override
	       public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
	           Map<String, Object> map = new HashMap<>();
	           map.put("nickname", rs.getString("nickname"));
	           map.put("category", rs.getString("category"));
	           map.put("introduction", rs.getString("introduction"));
	           map.put("profileImage", rs.getString("profileImage")); // 올바른 키 값으로 수정
	           return map;
	       }
	   }, params);
	   
	   return mentorProfileList;
	}

	

	@Override
	public List<Buying> getAllBuyingInformationlimit(String search, int page) {
		  int limit = 12;
		    int start = (page - 1) * limit;
		    
		    // SQL 쿼리에 LIMIT와 OFFSET을 추가합니다.
		    String SQL = "SELECT * FROM buying WHERE introduction LIKE ? OR title LIKE ? OR content LIKE ? OR category LIKE ? OR location LIKE ? OR nickname LIKE ? ORDER BY regist_day DESC LIMIT ? OFFSET ?";

		    // 쿼리 파라미터 배열을 생성합니다. 검색어와 페이지네이션을 위한 limit, start 값을 포함합니다.
		    Object[] params = {
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        limit,
		        start
		    };

		    // jdbcTemplate의 query 메소드를 사용하여 SQL 쿼리를 실행합니다. 결과는 BuyingRowMapper를 통해 Buying 객체 리스트로 매핑됩니다.
		    List<Buying> buyingList = template.query(SQL, params, new BuyingRowMapper());

		    // 검색된 구매 목록을 반환합니다.
		    return buyingList;
	}
	    
	public List<Buying> getAllSelingInformationlimit(String search, int page) {
		  int limit = 12;
		    int start = (page - 1) * limit;
		    
		    // SQL 쿼리에 LIMIT와 OFFSET을 추가합니다.
		    String SQL = "SELECT * FROM buying WHERE introduction LIKE ? OR title LIKE ? OR content LIKE ? OR category LIKE ? OR location LIKE ? OR nickname LIKE ? ORDER BY regist_day DESC LIMIT ? OFFSET ?";

		    // 쿼리 파라미터 배열을 생성합니다. 검색어와 페이지네이션을 위한 limit, start 값을 포함합니다.
		    Object[] params = {
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        limit,
		        start
		    };

		    // jdbcTemplate의 query 메소드를 사용하여 SQL 쿼리를 실행합니다. 결과는 BuyingRowMapper를 통해 Buying 객체 리스트로 매핑됩니다.
		    List<Buying> buyingList = template.query(SQL, params, new BuyingRowMapper());

		    // 검색된 구매 목록을 반환합니다.
		    return buyingList;
	}

	@Override
	public List<Selling> getAllSellingInformationlimit(String search, int page) {
		  int limit = 12;
		    int start = (page - 1) * limit;
		    
		    // SQL 쿼리에 LIMIT와 OFFSET을 추가합니다.
		    String SQL = "SELECT * FROM Selling WHERE introduction LIKE ? OR title LIKE ? OR content LIKE ? OR category LIKE ? OR location LIKE ? OR nickname LIKE ? ORDER BY regist_day DESC LIMIT ? OFFSET ?";

		    // 쿼리 파라미터 배열을 생성합니다. 검색어와 페이지네이션을 위한 limit, start 값을 포함합니다.
		    Object[] params = {
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        "%" + search + "%",
		        limit,
		        start
		    };

		    // jdbcTemplate의 query 메소드를 사용하여 SQL 쿼리를 실행합니다. 결과는 BuyingRowMapper를 통해 Buying 객체 리스트로 매핑됩니다.
		    List<Selling> sellingList = template.query(SQL, params, new SellingRowMapper());

		    // 검색된 구매 목록을 반환합니다.
		    return sellingList;
	}

	@Override
	public List<Map<String, Object>> getAllMentorprofileInformationlimit(String search, int page) {
		 int limit = 12;
		 int start = (page - 1) * limit;
		 
		 String SQL = "SELECT member.nickname, member.profileImage, mentorprofile.category, mentorprofile.introduction " +
		            "FROM member " +
		            "JOIN mentor ON member.memberId = mentor.memberId " +
		            "JOIN mentorprofile ON mentor.mentorId = mentorprofile.mentorId " +
		            "WHERE member.nickname LIKE ? OR mentorprofile.category LIKE ? OR mentorprofile.introduction LIKE ? " +
		            "LIMIT " + limit + " OFFSET " + start;
		 
		  String searchPattern = "%" + search + "%";
		   Object[] params = {searchPattern, searchPattern, searchPattern}; // 모든 LIKE 조건에 대해 검색 패턴 적용
		   
		   List<Map<String, Object>> mentorProfileList = template.query(SQL, new RowMapper<Map<String, Object>>() {
		       @Override
		       public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		           Map<String, Object> map = new HashMap<>();
		           map.put("nickname", rs.getString("nickname"));
		           map.put("category", rs.getString("category"));
		           map.put("introduction", rs.getString("introduction"));
		           map.put("profileImage", rs.getString("profileImage")); // 올바른 키 값으로 수정
		           return map;
		       }
		   }, params);
		   
		   return mentorProfileList;
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}
