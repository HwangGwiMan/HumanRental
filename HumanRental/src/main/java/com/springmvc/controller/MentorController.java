package com.springmvc.controller;

import java.io.File;
import java.io.IOException;

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
		
		alarmService.createMentoApplyAlarm(memberId, mentorRegistInfo.getRegistId());
		
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

	    //세션 에서 아이디 불러옴 
	    HttpSession session = request.getSession();
	    String memberId = (String) session.getAttribute("user");
	    
	    //멘토프로필데이터베이스에 조회되는가 체크 
	    Mentor mentor = mentorService.getMentor(memberId);
	    MentorProfile mentorprofile	=mentorService.MentorprofileInformation(memberId);
	    
	    //멘토에 등록이 안되어 있으면 멘토센청으로 가게 하는 로직
	    if(mentor == null) {	
	    	
	        mode = "mentorFail";
	        model.addAttribute("mode",mode);
	        return "redirect:/myInfo";
	        
	    }
	    
	    //멘토신청을해서 승인받은 뒤 멘토 프로필 등록 폼으로 가는 else if
	    else if (mentor != null && mentorprofile == null ) {
	    	mode ="mentorProfile";
	        model.addAttribute("mode", mode);
	        return "redirect:/myInfo";
	    }
	    
	    //멘토승인과 멘토프로필에 등록이 완로가 되어서  멘토 프로필 뿌려주는 else
	    else if(mentor != null && mentorprofile != null ) {
	    	System.out.println("이제 뿌려주기만 하면 되는데 여기는 올까?;");
	    System.out.println("멘토 카테고리 "+mentorprofile.getCategory());
	        mode = "mentorInformation";
	        model.addAttribute("mode", mode);
	        model.addAttribute("mentorprofile",mentorprofile);
	        System.out.println("그럼 여기는?");
	        
	        return "MyPage";
	    }
	     return "redirect:/myInfo";
	}
	
	@PostMapping("/mentorProfileRegister")
	public String memtorRegister(@ModelAttribute MentorProfile mentorprofile,
			@RequestParam("file1") MultipartFile file1 ,
			@RequestParam("file2") MultipartFile file2 ,
			@RequestParam("file3") MultipartFile file3 ,
			Model model,HttpServletRequest request ,@RequestParam("mode") String mode) {
		   System.out.println("멘토프로필 등록 하는 컨트롤러입니다 ");

		    HttpSession session = request.getSession();
		    String memberId = (String) session.getAttribute("user");
		    Mentor mentor = mentorService.getMentor(memberId);
		    String mentorId =  mentor.getMentorId();
		    mentorprofile.setMentorId(mentorId);
		    String realPath = request.getSession().getServletContext().getRealPath("/resources/img/ProfilePicture");

		    if (!file1.isEmpty()) { 
		        String realfilename1 = "mentorprofile_"+mentorprofile.getMentorId()+file1.getOriginalFilename();
		        File saveFile1 = new File(realPath,realfilename1);
		        mentorprofile.setFilename1(realfilename1);
		        try {
		            file1.transferTo(saveFile1);  // 파일 저장
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        System.out.println("saveFile1="+saveFile1);
		    }
		    if (!file2.isEmpty()) { 
		        String realfilename2 = "mentorprofile_"+mentorprofile.getMentorId()+file2.getOriginalFilename();
		        File saveFile2 = new File(realPath,realfilename2);
		        mentorprofile.setFilename2(realfilename2);
		        try {
		            file1.transferTo(saveFile2);  // 파일 저장
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        
		        System.out.println("saveFile2="+saveFile2);
		    }
		    if (!file3.isEmpty()) { 
		        String realfilename3 = "mentorprofile_"+mentorprofile.getMentorId()+file3.getOriginalFilename();
		        File saveFile3 = new File(realPath,realfilename3);
		        mentorprofile.setFilename3(realfilename3);
		        try {
		            file1.transferTo(saveFile3);  // 파일 저장
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        System.out.println("saveFile3="+saveFile3);
		    }


		    mentorService.mentorProfileRegister(mentorprofile,memberId,mentorId);
		    mode = "mentorProfile";
		    model.addAttribute("mode", mode);
		    return "redirect:/mentor";
	}
	
	@GetMapping("/mentorprofileupdate")
	public String UpdateMentorProfileform(Model model,HttpServletRequest request ,@RequestParam("mode") String mode) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
	
		MentorProfile mentorProfile = mentorService.MentorprofileInformation(memberId);
	
		mode="mentorProfileUpdate";
		
		model.addAttribute("mode", mode);
		model.addAttribute("mentorprofile",mentorProfile);
		
        return "MyPage";
	
	}
	@PostMapping("/mentorProfileUpdate")
	public String UpdateMentorProfile(@ModelAttribute MentorProfile mentorprofile,
			@RequestParam("file1") MultipartFile file1 ,
			@RequestParam("file2") MultipartFile file2 ,
			@RequestParam("file3") MultipartFile file3 , Model model , HttpServletRequest request ,@RequestParam("mode") String mode) {

		   System.out.println("멘토프로필 등록 하는 컨트롤러입니다 ");

		    HttpSession session = request.getSession();
		    String memberId = (String) session.getAttribute("user");
		    Mentor mentor = mentorService.getMentor(memberId);
		    String mentorId =  mentor.getMentorId();
		    mentorprofile.setMentorId(mentorId);
		    String realPath = request.getSession().getServletContext().getRealPath("/resources/img/ProfilePicture");

		    if (!file1.isEmpty()) { 
		        String realfilename1 = "mentorprofile_"+mentorprofile.getMentorId()+file1.getOriginalFilename();
		        File saveFile1 = new File(realPath,realfilename1);
		        mentorprofile.setFilename1(realfilename1);        
		        try {
		            file1.transferTo(saveFile1);  // 파일 저장
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        System.out.println("saveFile1="+saveFile1);
		    }
		    if (!file2.isEmpty()) { 
		        String realfilename2 = "mentorprofile_"+mentorprofile.getMentorId()+file2.getOriginalFilename();
		        File saveFile2 = new File(realPath,realfilename2);
		        mentorprofile.setFilename2(realfilename2);
		        try {
		            file2.transferTo(saveFile2);  // 파일 저장
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        System.out.println("saveFile2="+saveFile2);
		    }
		    if (!file3.isEmpty()) { 
		        String realfilename3 = "mentorprofile_"+mentorprofile.getMentorId()+file3.getOriginalFilename();
		        File saveFile3 = new File(realPath,realfilename3);
		        mentorprofile.setFilename3(realfilename3);
		        try {
		            file3.transferTo(saveFile3);  // 파일 저장
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        System.out.println("saveFile3="+saveFile3);
		    }

		mentorService.UpdateMentorProfile(mentorprofile,memberId);
		MentorProfile mentorProfile = mentorService.MentorprofileInformation(memberId);
	    mode = "mentorInformation";
		model.addAttribute("mode", mode);
		model.addAttribute("mentorprofile",mentorProfile);
	    
	    return "MyPage";

	}
	
	
	@GetMapping("/mentorprofileCheck")
	@ResponseBody
	public String MentorProfileCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("user");
		
		if(memberId == null) {
			return "notLogin";
		}
		
		MentorProfile mentorprofile = mentorService.MentorprofileInformation(memberId);
		if(mentorprofile == null) {
			return "false";
		} else {
			return "true";
		}
	}
}
