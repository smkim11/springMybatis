package com.example.mbboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.service.BoardService;
import com.example.mbboard.service.IBoardService;

@Controller
public class BoardController {

	@Autowired IBoardService boardService; // 인터페이스 형태로 의존성 주입 -> 디커플링
	
	// 전체 리스트
	@GetMapping("/boardList")
	public String boardList(Model model, Page p) {
		Page p2 = new Page(p.getCurrentPage(),p.getRowPerPage(),p.getSearchWord());
		p.setTotalCount(boardService.totalCount(p));
		int lastPage = p.getLastPage();
		
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("p2",p2);
		model.addAttribute("list",boardService.selectBoardList(p2));
		return "boardList";
	}
	
	// 상세페이지
	@GetMapping("/boardOne")
	public String boardOne(Model model,Board board) {
		
		model.addAttribute("board",boardService.selectBoardOne(board));
		return "boardOne";
	}
	
	// 추가
	@GetMapping("/insertBoard")
	public String insertBoard() {
			
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:/boardList";
	}
	
	// 수정
	@GetMapping("/updateBoard")
	public String updateBoard(Model model, Board board) {
		model.addAttribute("board",boardService.selectBoardOne(board));
		return "updateBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "redirect:/boardOne?boardNo="+board.getBoardNo();
	}
	
	// 삭제
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "redirect:/boardList";
	}
}
