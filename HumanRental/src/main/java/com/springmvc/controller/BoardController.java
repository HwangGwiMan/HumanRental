package com.springmvc.controller;

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
	
	// 보드1 (자유게시판)
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
	
	@PostMapping("/board")
	public String BoardSearch(Model model, HttpServletRequest request) {
		
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
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Member member = memberService.getMember(memberId);
		model.addAttribute("member", member);
		return "BoardWrite";
	}
	
	@PostMapping("/boardwrite")
	public String BoardWriteAction(@ModelAttribute Board board, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		boardService.insertBoard(board, memberId);
		return "redirect:/board";
	}
	
	@GetMapping("/boardview")
	public String BoardViewAction(HttpServletRequest request, Model model) {
		
		String boardId = request.getParameter("boardId");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		Board board=new Board();
		boardService.updateHit(boardId);
		board = boardService.getBoardByNum(boardId, pageNum);

		model.addAttribute("BoardId", boardId);
		model.addAttribute("pageNum", pageNum);		
		model.addAttribute("board", board);
		
		return "BoardView";
	}

	@GetMapping("/boarddelete")
	public String BoardDelete(HttpServletRequest request, Model model) {
		
		String boardId = request.getParameter("boardId");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));	
		
		boardService.deleteBoard(boardId);
		
		return "redirect:/board?pageNum="+pageNum;
	}
	
	@GetMapping("/boardupdate")
	public String BoardUpdate(HttpServletRequest request, Model model) {

		String boardId = request.getParameter("boardId");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		Board board = boardService.getBoardByNum(boardId, pageNum);
		model.addAttribute("board", board);
		
		return "BoardUpdate";
	}

	@PostMapping("/boardupdate")
	public String BoardUpdateAction(@ModelAttribute Board board) {
		
		boardService.updateBoard(board);
		return "redirect:/board";
	}
	
	// board2 (공지사항)
	@GetMapping("/board2")
	public String BoardList2(Model model, HttpServletRequest request) {
		
		int pageNum;
		if(request.getParameter("pageNum")==null)
			pageNum=1;
		else
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		boardService.BoardList2(model, request, pageNum);
		return "Board2";
	}
	
	@GetMapping("/boardwrite2")
	public String BoardWrite2(@ModelAttribute Board board, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		Member member = memberService.getMember(memberId);
		model.addAttribute("member", member);
		return "BoardWrite2";
	}
	
	@PostMapping("/boardwrite2")
	public String BoardWriteAction2(@ModelAttribute Board board, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("user");
		boardService.insertBoard2(board, memberId);
		return "redirect:/board2";
	}
	
	@GetMapping("/boardview2")
	public String BoardViewAction2(HttpServletRequest request, Model model) {
		
		String boardId = request.getParameter("boardId");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		Board board=new Board();
		boardService.updateHit2(boardId);
		board = boardService.getBoardByNum2(boardId, pageNum);

		model.addAttribute("BoardId", boardId);
		model.addAttribute("pageNum", pageNum);		
		model.addAttribute("board", board);
		
		return "BoardView2";
	}

	@GetMapping("/boarddelete2")
	public String BoardDelete2(HttpServletRequest request, Model model) {
		
		String boardId = request.getParameter("boardId");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));	
		
		boardService.deleteBoard2(boardId);
		
		return "redirect:/board2?pageNum="+pageNum;
	}

	@GetMapping("/boardupdate2")
	public String BoardUpdate2(HttpServletRequest request, Model model) {

		String boardId = request.getParameter("boardId");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		Board board = boardService.getBoardByNum2(boardId, pageNum);
		model.addAttribute("board", board);
		
		return "BoardUpdate2";
	}

	@PostMapping("/boardupdate2")
	public String BoardUpdateAction2(@ModelAttribute Board board) {
		
		boardService.updateBoard2(board);
		return "redirect:/board2";
	}

}
