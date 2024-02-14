package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
import com.springmvc.service.MemberService;
import com.springmvc.service.MentorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class PrivacyController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MentorService mentorService;
	
	@GetMapping("/myInfo")
	public String requestMyPage(@RequestParam("mode") String mode,
								Model model, 
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
			
			if(mentorService.getMentor(memberId) == null) {
				model.addAttribute("isMentor", "NO");
			} else {
				model.addAttribute("isMentor", "YES");
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
		
		System.out.println(realPath);
		
		Member targetMember = memberService.getMember(memberId);
		
		// 새로운 이미지가 있을 경우 바로 업데이트
		if(file != null && !file.isEmpty()) {
			
			member.setProfileImage(setFileName(memberId));
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} else {// 이미지가 없을 경우
			// 기존 이미지 체크
			// 기존 이미지 있으면
			if(!targetMember.getProfileImage().isEmpty()) {
				// 기존 이미지 사용 
				member.setProfileImage(setFileName(memberId)); 
			} else {
				// 디폴트 이미지 사용
				member.setProfileImage("default.png");
			}
		}

		memberService.updateMember(member, memberId);
		session.setAttribute("user", member.getMemberId());
		model.addAttribute("mode", "myPage");
		return "redirect:/myInfo";
	}
	
	public String setFileName(String memberId) {
		List<Member> memberList = memberService.getMembers();
		Member member = memberService.getMember(memberId);
		
		String fileImageName = member.getProfileImage();
		
		if(fileImageName != null && fileImageName.contains("profileImage")) {
			return fileImageName;
		} else {
			int userCount = memberList.size();
			return "profileImage" + userCount +".jpg";
		}
	}
}
