package com.springmvc.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.xdevapi.JsonArray;
import com.springmvc.domain.Mentee;
import com.springmvc.domain.Mentor;
import com.springmvc.domain.MentorProfile;
import com.springmvc.domain.MentorRegistInfo;
import com.springmvc.service.AlarmService;
import com.springmvc.service.MentorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class MentorController {
	
	@Autowired
	MentorService mentorService; 
	
	@Autowired
	AlarmService alarmService;
	
	@GetMapping("/mentorlist")
	public String MentorList(Model model) {
		return "mentorlist";
	}
	
	@GetMapping("/mentorDetail")
	public String MentorDetail(Model model) {
		return "mentorDetail";
	}
	
	@GetMapping("/mentorIntro")
	public String requestMentorIntroPage() {
		return "MentorIntro";
	}
	
	@GetMapping("/mentorCheck")
	@ResponseBody
	public String MentorCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		
		if(memberId == null) {
			return "notLogin";
		}
		
//		MentorRegistInfo mentorRegistInfo = mentorService.getMentorApplyByMemberId(memberId);

		if(mentorService.getMentorApplyState(memberId) != null) {
			return "AlreadyApply";
		}
		
		Mentor mentor = mentorService.getMentor(memberId);
		if(mentor == null) {
			return "true";
		} else {
			return "false";
		}
	}
	
	@GetMapping("/mentorApply")
	public String requestMentorRegistPage(HttpServletRequest request) {
		return "MentorApply";
	}
	
	@PostMapping("/mentorApply/submit")
	public String mentorApplySubmit(MentorRegistInfo mentorRegistInfo,
									 HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		mentorRegistInfo.setMemberId(memberId);
			
		mentorService.mentorApply(mentorRegistInfo);
		
		alarmService.createMentoApplyAlarm(memberId);
		
		return "redirect:/main";
	}	
	
	@GetMapping("/mentorRegist")
	public String mentorRegist(@RequestParam("mId") String memberId,
							   @RequestParam("rId") String registId) {
		mentorService.mentorRegist(memberId, registId);
		alarmService.createMentoApplyResultAlarm(memberId, "승인");
		return "redirect:/myInfo?mode=mentorApplyManagement";
	}
	
	@GetMapping("/mentorApplyRefuse")
	public String mentorApplyRefuse(@RequestParam("mId") String memberId,
									@RequestParam("rId") String registId) {
		mentorService.mentorRefuse(memberId, registId);
		alarmService.createMentoApplyResultAlarm(memberId, "거절");
		return "redirect:/myInfo?mode=mentorApplyManagement";
	}
	
	@GetMapping("/mentor")
	public String mentorprofileform(@RequestParam("mode") String mode, Model model,HttpServletRequest request ) {
		System.out.println("멘토프로필 양식 폼인데 여긴 오니?");

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		MentorProfile mentorprofile = mentorService.MentorInformation(memberId);
		System.out.println(mentorprofile);
		System.out.println("야 꼭 떠줘 부탁해 ");
		if (mentorprofile ==null ) {
			System.out.println("떳다 null값22222");
			model.addAttribute("mode",mode);
		}else {
			mode = "mentorInformation";
			System.out.println("객체 가져 왓냐?3333333");
			model.addAttribute("mode",mode);
			model.addAttribute("mentorprofile",mentorprofile);
			
		}

		
		return "MyPage";
	}
	
	
	@PostMapping("/mentorProfileRegister")
	public String memtorRegister(@ModelAttribute MentorProfile mentorprofile,
			@RequestParam("file1") MultipartFile file1 ,
			@RequestParam("file2") MultipartFile file2 ,
			@RequestParam("file3") MultipartFile file3 ,
			Model model,HttpServletRequest request) {
		System.out.println("멘토프로필 등록 함수인데 여긴 오냐?");

		mentorprofile.setFilename1(file1.getOriginalFilename());
		mentorprofile.setFilename2(file2.getOriginalFilename());
		mentorprofile.setFilename3(file3.getOriginalFilename());
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		Mentor mentor = mentorService.getMentor(memberId);
		
		
		String mentorId =  mentor.getMentorId();
		System.out.println("이건 멘토아이디로 하면 됨"+mentorId);		
		mentorprofile.setMentorId(mentorId);
		
		String realfilename1 = "mentorprofile_"+mentorprofile.getMentorId()+mentorprofile.getFilename1();
		String realfilename2 = "mentorprofile_"+mentorprofile.getMentorId()+mentorprofile.getFilename2();
		String realfilename3 = "mentorprofile_"+mentorprofile.getMentorId()+mentorprofile.getFilename3();

		
		String realPath = request.getSession().getServletContext().getRealPath("/resources/img/ProfilePicture");
		File saveFile1 = new File(realPath,realfilename1);
		File saveFile2 = new File(realPath,realfilename2);
		File saveFile3 = new File(realPath,realfilename3);
		
		mentorprofile.setFilename1(realfilename1);
		mentorprofile.setFilename2(realfilename2);
		mentorprofile.setFilename3(realfilename3);
		
		System.out.println("saveFile1="+saveFile1);
		System.out.println("saveFile2="+saveFile2);
		System.out.println("saveFile3="+saveFile3);
		

		System.out.println("이건 멘토아이디로 하면 됨"+mentorId);


		mentorService.mentorProfileRegister(mentorprofile,memberId,mentorId);
		return "Main";
	}
	
}
