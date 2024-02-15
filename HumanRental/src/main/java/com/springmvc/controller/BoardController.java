package com.springmvc.controller;

import java.util.Arrays;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Board;
import com.springmvc.domain.Member;
import com.springmvc.service.BoardService;
import com.springmvc.service.MemberService;

@Controller
@RequestMapping
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/board")
	public String BoardList(Model model, HttpServletRequest request) {
		int pageNum;
		if(request.getParameter("pageNum")==null)
			pageNum=1;
		else
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		boardService.BoardList(model, request, pageNum);
		return "Board";
	}

	@GetMapping("/boardwrite")
	public String BoardWrite(@ModelAttribute Board board, Model model, HttpServletRequest request) {
		System.out.println("boardwirte 접근");
		HttpSession session = request.getSession();
		String MemberId = (String)session.getAttribute("user");
		Member member = memberService.getMember(MemberId);
		model.addAttribute("member", member);
		return "BoardWrite";
	}
	
	@PostMapping("/boardwrite")
	public String BoardWriteAction(@Valid @ModelAttribute Board board, HttpServletRequest request) {
		System.out.println("네임"+board.getName());
		System.out.println("타이틀"+board.getTitle());
		System.out.println("컨텐츠"+board.getContent());
		HttpSession session = request.getSession();
		String MemberId = (String)session.getAttribute("user");
		boardService.insertBoard(board, MemberId);
		return "redirect:/board";
	}
	
	@GetMapping("/boardview")
	public String BoardViewAction(HttpServletRequest request, Model model) {
		System.out.println("boardview 접근");
		int BoardId = Integer.parseInt(request.getParameter("BoardId"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		System.out.println("BoardId="+BoardId);
		System.out.println("pageNum="+pageNum);
		
		Board board=new Board();
		boardService.updateHit(BoardId);
		board = boardService.getBoardByNum(BoardId, pageNum);
		
		request.setAttribute("BoardId", BoardId);		 
   		request.setAttribute("page", pageNum); 
		model.addAttribute("board", board);
		System.out.println(board.getContent());
		
		return "BoardView";
	}
	
}
