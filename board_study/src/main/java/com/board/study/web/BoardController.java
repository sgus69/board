package com.board.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.study.dto.board.BoardRequestDto;
import com.board.study.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/board/list")
	public String getBoardListPage(Model model, @RequestParam(required=false, defaultValue ="0")Integer page,
	@RequestParam(required = false, defaultValue = "5") Integer size)throws Exception{
		
		try {
			model.addAttribute("resultMap", boardService.findAll(page, size));
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "/board/list";
		
	}
	
	@GetMapping("/board/write")
	public String getBoardWritePage(Model model, BoardRequestDto req) {
		return "/board/write";
	}
	
	@GetMapping("/board/view")
	public String getBoardViewPage(Model model, BoardRequestDto req) throws Exception{
		try {
			if(req.getId()!= null) {
				model.addAttribute("info", boardService.findById(req.getId()));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "/board/view";
	}
	
	@PostMapping("/board/write/action")
	public String boardWriteAction(Model model, BoardRequestDto req) throws Exception{
		
		try {
			Long result = boardService.save(req);
			
			if(result <0 ) {
				throw new Exception("#Exception boardWriteAction!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return"redirect:/board/list";
	}
	
	@PostMapping("/board/view/action")
	public String boardViewAction(Model model, BoardRequestDto req)throws Exception{
		
			try {
				int result = boardService.updateBoard(req);
				
				if(result <1) {
					throw new Exception("#Exception boardViewAction!");
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		return "board/view";
	}
	
	@PostMapping("/baord/view/delete")
	public String boardDeleteAction(Model model, BoardRequestDto req,
			@RequestParam()Long id)throws Exception{
		try {
			
			boardService.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/board/delete")
	public String boardDeleteAction(Model model, @RequestParam()Long[]deleteId)throws Exception{
		try {
			boardService.deleteAll(deleteId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "redirect:/board/list";
	}
	
}
