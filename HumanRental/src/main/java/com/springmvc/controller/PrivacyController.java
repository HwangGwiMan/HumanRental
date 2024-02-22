package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springmvc.domain.Member;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorRegistInfo;
import com.springmvc.service.MemberService;
import com.springmvc.service.MentorService;
import com.springmvc.service.ReportService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PrivacyController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MentorService mentorService;
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/myInfo")
	public String requestMyPage(@RequestParam("mode") String mode,
								@RequestParam(value = "id", defaultValue = "none") String targetId,
								@RequestParam(value = "t", defaultValue = "none") String state,								Model model, 
								HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			String memberId = (String) session.getAttribute("user");
			Member member = memberService.getMember(memberId);
			
			if(member.getProfileImage() == null) {
				member.setProfileImage("default.png");
			}
			
			model.addAttribute("member", member);
			model.addAttribute("mode", mode);
			
			// 어드민 관련 데이터
			if(memberId.equals("admin")) {
				
				if(mode.equals("memberManagement")) {
					// 멤버 관리
					model.addAttribute("memberList", mentorService.getMentorListWithMember());
				} else if(mode.equals("mentorApplyManagement")) {
					// 멘토 신청 관리
					if(state.equals("none") ) {
						model.addAttribute("applyList", mentorService.getMentorApplyList());
					} else {
						model.addAttribute("applyList", mentorService.getMentorApplyList(state));
					}
				} else if(mode.equals("applyInfo") ) {
					// 개별 멘토 신청 관리
					model.addAttribute("applyInfo", mentorService.getMentorApplyByMemberId(targetId));
				} else if(mode.equals("report")) {
					// 신고 관리
					model.addAttribute("reportList", reportService.getReportList());
				}

			} else {// 일반 유저 관련 데이터
				if(mode.equals("memberManagement") || mode.equals("applyInfo") || mode.equals("memberManagement")) {
					mode = "myPage";
				}
				
				if(mentorService.getMentor(memberId) == null) {
					model.addAttribute("isMentor", "NO");
					if(mentorService.getMentorApplyState(memberId) != null) {
						model.addAttribute("isMentor", "멘토 심사 중");
					} 
				} else {
					model.addAttribute("isMentor", "YES");
				}
			}
			
			return "MyPage";
		} else {
			return "redirect:/main";
		}
	}
	
	// 2차 로그인 확인
	@PostMapping("/myInfo")
	public String userCheck(HttpServletRequest request, 
							Member member,
							Model model) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		Member sessionMember = memberService.getMember(memberId);
		
		if(sessionMember != null) {
			if((sessionMember.getMemberId().equals(member.getMemberId())) && (sessionMember.getMemberPw().equals(member.getMemberPw()))) {
				model.addAttribute("mode", "myPageEdit");
				return "redirect:/myInfo";
			} else {
				model.addAttribute("mode", "myPage");
				return "redirect:/myInfo"; 
			}
		} else {
			model.addAttribute("mode", "myPage");
			return "redirect:/myInfo"; 
		}
	}
	
	// 회원 정보 수정
	@PostMapping("/myPageEdit")
	public String myPageEdit(HttpServletRequest request,
							 Member member, 
							 Model model,
							 @RequestParam("Image") MultipartFile file) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		
		String realPath = request.getSession().getServletContext().getRealPath("/resources/img/ProfilePicture");
		File saveFile = new File(realPath, setFileName(memberId));
		
		Member targetMember = memberService.getMember(memberId);
		
		// 새로운 이미지가 있을 경우 바로 업데이트
		if(file != null && !file.isEmpty() && !file.getOriginalFilename().isEmpty()) {
			
			member.setProfileImage(setFileName(memberId));
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} else {// 이미지가 없을 경우
			// 디폴트 이미지일 경우			
			if(targetMember.getProfileImage().equals("default.png")) {
				member.setProfileImage("default.png");
			} else { // 디폴트 이미지가 아닐 경우
				// 기존 이미지 그대로 사용
				member.setProfileImage(targetMember.getProfileImage());
			}
		}

		memberService.updateMember(member, memberId);
		session.setAttribute("user", member.getMemberId());
		model.addAttribute("mode", "myPage");
		return "redirect:/myInfo";
	}
	
	public String setFileName(String memberId) {
		Member member = memberService.getMember(memberId);
		
		String fileImageName = member.getProfileImage();
		
		if(fileImageName != null && fileImageName.contains("profileImage")) {
			return fileImageName;
		} else {
			return "profileImage" + member.getMemberId() +".jpg";
		}
	}
	
	//회원탈퇴처리
	@PostMapping("/deleteMember") 
	public String deleteMember(@RequestParam("mode") String mode, @RequestParam("memberId") String memberId,
	        @RequestParam("memberPw") String memberPw, Model model ,HttpServletRequest request) {
	
	   
	    memberService.deleteMember(memberId,memberPw);
	    HttpSession session = request.getSession();
		session.invalidate();
	    
	    return "redirect:main"; // 다른 페이지로 리다이렉트
	}

}
