package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentee;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.MentorRegistInfo;
import com.springmvc.util.Utility;

@Repository
public class MentorRepositroyImpl implements MentorRepository {
	
	@Autowired
	AlarmRepository alarmRepository;
	
	Utility util = new Utility(); 
	
	// JDBC
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	// 멘토 정보
	@Override
	public Mentor getMentor(String memberId) {
		String SQL = "SELECT * FROM mentor WHERE memberId = ?";
	
		try {
			List<Mentor> mentors = template.query(SQL, new BeanPropertyRowMapper<Mentor>(Mentor.class), memberId);
			return mentors.get(0);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	// 멘토 신청
	@Override
	public void mentorApply(MentorRegistInfo mentorRegistInfo) {
		String SQL;
			
		try {
			mentorRegistInfo.setRegistId(util.createId("mentorApply"));
			
			SQL = "INSERT INTO mentorregistinfo VALUES(?, ?, ?, ?, ?, ?, ?)";
			template.update(SQL, mentorRegistInfo.getRegistId(), mentorRegistInfo.getMemberId(), mentorRegistInfo.getSpecialty(), mentorRegistInfo.getLocation(), mentorRegistInfo.getReason(), mentorRegistInfo.getEtc(), LocalDateTime.now(ZoneId.of("Asia/Seoul")));
			
			SQL = "INSERT INTO mentorapply VALUES(?, ?, ?, ?)";
			template.update(SQL, mentorRegistInfo.getRegistId(), mentorRegistInfo.getMemberId(), null, "Wait");
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	// 멘토 신청 리스트
	@Override
	public List<Map<String, Object>> getMentorApplyList(String sort, String sortTarget) {
		String SQL = "SELECT mentorregistinfo.registId, mentorregistinfo.memberId, mentorregistinfo.applyDate, mentorapply.state, mentorapply.confirmDate FROM mentorapply "
				+ "LEFT JOIN mentorregistinfo "
				+ "ON mentorapply.registId = mentorregistinfo.registId ";

		if(!(sort.equals("none") || sort.equals("0"))) {
			SQL += util.sortSQL(sort, sortTarget);
		}
				
		try {
			return template.query(SQL, new RowMapper<Map<String, Object>>() {

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map<String, Object> applyInfo = new HashMap<String, Object>();
					applyInfo.put("registId", rs.getString(1));
					applyInfo.put("memberId", rs.getString(2));
					applyInfo.put("applyDate", rs.getTimestamp(3));
					applyInfo.put("state", rs.getString(4));
					applyInfo.put("confirmDate", rs.getTimestamp(5));

					return applyInfo;
				}
				
			});
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public List<Map<String, Object>> getMentorApplyList(String state, String sort, String sortTarget) {
		String SQL = "SELECT mentorregistinfo.registId, mentorregistinfo.memberId, mentorregistinfo.applyDate, mentorapply.state, mentorapply.confirmDate FROM mentorapply "
				+ "LEFT JOIN mentorregistinfo "
				+ "ON mentorapply.registId = mentorregistinfo.registId ";
		
		if(state.equals("Confirm")) {
			SQL = SQL + "WHERE state = 'Accept' or state = 'Refuse' ";
		} else if(state.equals("Wait")) {
			SQL = SQL + "WHERE state = 'Wait' ";			
		}
		
		if(!(sort.equals("none") || sort.equals("0"))) {
			SQL += util.sortSQL(sort, sortTarget);
		}
		
		try {
			return template.query(SQL, new RowMapper<Map<String, Object>>() {

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map<String, Object> applyInfo = new HashMap<String, Object>();
					applyInfo.put("registId", rs.getString(1));
					applyInfo.put("memberId", rs.getString(2));
					applyInfo.put("applyDate", rs.getTimestamp(3));
					applyInfo.put("state", rs.getString(4));
					applyInfo.put("confirmDate", rs.getTimestamp(5));

					return applyInfo;
				}
				
			});
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	
	// 멘토 신청 회원의 정보
	@Override
	public MentorRegistInfo getMentorApplyByRegistId(String registId) {
		String SQL = "SELECT * FROM mentorregistinfo WHERE registId = ?";
		try {
			return template.query(SQL, new BeanPropertyRowMapper<MentorRegistInfo>(MentorRegistInfo.class), registId).get(0);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	@Override
	public Map<String, Object> getMentorApplyByRegistIdTEST(String registId) {
		String SQL = "SELECT * FROM mentorregistinfo as mI "
				+ "LEFT JOIN mentorapply as mA "
				+ "ON mI.registId = mA.registId "
				+ "WHERE mI.registId = ?;";
		try {
			return template.query(SQL, new RowMapper<Map<String,Object>>() {

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					MentorRegistInfo info = new MentorRegistInfo();
					info.setRegistId(rs.getString("registId"));
					info.setMemberId(rs.getString("memberId"));
					info.setSpecialty(rs.getString("specialty"));
					info.setLocation(rs.getString("location"));
					info.setReason(rs.getString("reason"));
					info.setEtc(rs.getString("etc"));
					info.setApplyDate(util.outputFormatting(rs.getTimestamp("applyDate")));
					
					Map<String, Object> data = new HashMap<String, Object>();
					data.put("info", info);
					data.put("state", rs.getString("state"));
					
					return data;
				}
				
			}, registId).get(0);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	// 특정 멤버의 멘토 신청의 상태
	@Override
	public Map<String, Object> getMentorApplyState(String memberId) {
		String SQL;
		
		try {
			SQL = "SELECT * FROM mentorapply WHERE memberId = ? and state = 'Wait'";
			return template.queryForMap(SQL, memberId);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	// 멤버 리스트
	@Override
	public List<Map<String, Object>> getMentorListWithMember(String sort, String sortTarget) {
		String SQL = "SELECT mentor.mentorId, member.memberId, mentor.registDate, member.joinDate FROM member "
				+ "LEFT JOIN mentor "
				+ "ON member.memberId = mentor.memberId ";
		
		if(!(sort.equals("none") || sort.equals("0"))) {
			SQL += util.sortSQL(sort, sortTarget);
		}
		

		try {
			return template.query(SQL, new RowMapper<Map<String, Object>>() {

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map<String, Object> memberInfo = new HashMap<String, Object>();
					memberInfo.put("mentorId", rs.getString(1));
					memberInfo.put("memberId", rs.getString(2));
					
					if(rs.getTimestamp(3) != null) {
						memberInfo.put("mentorRegistDate", util.outputFormatting(rs.getTimestamp(3)));
					} else {
						memberInfo.put("mentorRegistDate", null);
					}
					
					memberInfo.put("memberJoinDate", util.outputFormatting(rs.getTimestamp(4)));
					
					return memberInfo;
				}
			});
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	

	@Override
	public List<Map<String, Object>> getMentorListWithMember(String state, String sort, String sortTarget) {
		if(state.equals("Accept")) {
			state = "IS NOT NULL ";
		} else if(state.equals("NotRegist")) {
			state = "IS NULL ";
		}
		String SQL = "SELECT mentor.mentorId, member.memberId, mentor.registDate, member.joinDate FROM member "
				+ "LEFT JOIN mentor "
				+ "ON member.memberId = mentor.memberId "
				+ "WHERE registDate " + state;
		
		if(!(sort.equals("none") || sort.equals("0"))) {
			SQL += util.sortSQL(sort, sortTarget);
		}
		
		try {
			return template.query(SQL, new RowMapper<Map<String, Object>>() {

				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map<String, Object> memberInfo = new HashMap<String, Object>();
					memberInfo.put("mentorId", rs.getString(1));
					memberInfo.put("memberId", rs.getString(2));
					if(rs.getTimestamp(3) != null) {
						memberInfo.put("mentorRegistDate", util.outputFormatting(rs.getTimestamp(3)));
					} else {
						memberInfo.put("mentorRegistDate", null);
					}
					
					memberInfo.put("memberJoinDate", util.outputFormatting(rs.getTimestamp(4)));
					
					return memberInfo;
				}
			});
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			return null;
		}
	}

	// 멘토 신청 승인
	@Override
	public void mentorRegist(String memberId, String registId) {
		String SQL;
		
		try {
			SQL = "INSERT INTO mentor VALUES(?, ?, ?)";
			template.update(SQL, util.createId("mentor"), memberId, LocalDateTime.now(ZoneId.of("Asia/Seoul")));
			
			SQL = "UPDATE mentorapply SET state = 'Accept', confirmDate = ?  WHERE memberId = ? and registId = ?";
			template.update(SQL, LocalDateTime.now(ZoneId.of("Asia/Seoul")) , memberId, registId);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	// 멘토 신청 거절
	@Override
	public void mentorRefuse(String memberId, String registId) {
		String SQL;

		try {
			SQL = "UPDATE mentorapply SET state = 'Refuse', confirmDate = ? WHERE memberId = ? and registId = ?";
			template.update(SQL, LocalDateTime.now(ZoneId.of("Asia/Seoul")), memberId, registId);
		} catch(EmptyResultDataAccessException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
	}
	
	//멘토프로필 등록 함수 
	@Override
	public void mentorProfileRegister(MentorProfile mentorprofile ,String memberId, String mentorId) {
		String SQL;
//		String SQL = "INSERT INTO MenteeProfile (menteeId,memberId,interest,introduction) VALUES(?,?,?,?)";
//		template.update(SQL, utility2,Mentee.getMemberId(),Mentee.getInterest(),Mentee.getIntroduction());
		
		 String a ="mentorprofile_" + mentorprofile.getMentorId();
		 System.out.println(a);
		try {
			SQL ="insert into  mentorProfile(mentorId,memberId,introduction,certification,category,filename1,filename2,filename3)VALUES(?,?,?,?,?,?,?,?)";
			template.update(SQL, mentorId, memberId, mentorprofile.getIntroduction(),mentorprofile.getCertification(),mentorprofile.getCategory(),mentorprofile.getFilename1(),mentorprofile.getFilename2(),mentorprofile.getFilename3());
			
		}catch(EmptyResultDataAccessException | IndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}
	
	//멘토 프로필 조회 함수 count 로 읽을거임 
	public int getMentorProfile() {
		 String SQL = "select count(*) from MentorProfile";
		    int rowCount = 0;
		    
		    try {
		        rowCount = template.queryForObject(SQL, Integer.class);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return rowCount;
	}	    
	
	///멘토 프로필 조회 함수 select쓸거임 
	public MentorProfile MentorprofileInformation (String memberId) {
		 System.out.println("데이터베이스에서 정보를 찾는 중...");
		    String SQL = "select * from MentorProfile where memberId=?";
		    
		    // 데이터베이스에서 정보를 찾는 작업
		    List<MentorProfile> profiles = template.query(SQL, new Object[]{memberId}, new MentorProfileMapper());

		    // 정보가 있다면, 그 정보를 사용
		    if (!profiles.isEmpty()) {
		        MentorProfile mentorprofile = profiles.get(0);
		        System.out.println("멘토 소개: " + mentorprofile.getIntroduction());
		        System.out.println("멘토 ID: " + mentorprofile.getMemberId());
		        System.out.println("자격증 정보: " + mentorprofile.getCertification());
		        return mentorprofile;
		    } else {
		        // 정보가 없다면, null을 반환
		        System.out.println("조회 결과가 없음");
		        return null;
		    }
	}
	
	// 예약 전용
	@Override
	public Mentor getMentor2(String mentorId) {
//		System.out.println("겟멘토2 접근");
		String SQL = "SELECT * FROM mentor WHERE mentorId = ?";
		Mentor mentor = template.queryForObject(SQL, new BeanPropertyRowMapper<Mentor>(Mentor.class), mentorId);
		return mentor;
	}

	@Override
	public void UpdateMentorProfile(MentorProfile mentorprofile, String memberId) {
		
		String SQL = "UPDATE mentorProfile SET introduction = ?, certification = ?, category = ?, filename1 = ?, filename2 = ?, filename3 = ? WHERE mentorId = ? AND memberId = ?";

		try {
			template.update(SQL, mentorprofile.getIntroduction(),mentorprofile.getCertification(),mentorprofile.getCategory(),mentorprofile.getFilename1(),mentorprofile.getFilename2(),mentorprofile.getFilename3(),mentorprofile.getMentorId(),memberId);

		}catch(EmptyResultDataAccessException | IndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}

	@Override
	public void DeleteMentorProfile(String memberId) {
		// TODO Auto-generated method stub
		
	}
}
