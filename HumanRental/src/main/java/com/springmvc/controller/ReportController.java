package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.savedrequest.Enumerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.service.BoardService;
import com.springmvc.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/boardreport")
	public String requestBoardReportPage(@RequestParam("boardId") int boardId,
										 Model model) {
		model.addAttribute("target", "게시글");
		model.addAttribute("memberId", boardService.getMemberIdByBoardId(boardId));
		model.addAttribute("boardId", boardId);
		return "Report";
	}
	
	@PostMapping("/report")
	@ResponseBody
	public void boardReport(//@RequestParam Map<String, Object> map,
							HttpServletRequest request) {
		HttpSession session = request.getSession();
		String reporterId = (String) session.getAttribute("user");
		
		reportService.createBoardReport(request, reporterId);
	}
	
	
}
