package com.minjoo.demo.controller;



import com.minjoo.demo.domain.BoardVO;
import com.minjoo.demo.domain.Criteria;
import com.minjoo.demo.domain.pageDTO;
import com.minjoo.demo.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Slf4j
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri")Criteria cri,Model model) {
		
		log.info("Board List...."+cri);
		model.addAttribute("list" , service.getList(cri));
		//model.addAttribute("pageMaker", new pageDTO(cri, 123));
		
		int total = service.getTotal(cri);
		log.info("total : "+total);
		model.addAttribute("pageMaker",new pageDTO(cri, total));
		
	}
	
	@GetMapping("/register")
	public void register(Model model) {
		
	}
	
	@PostMapping("/register_input")
	public String register(BoardVO board,Model model,RedirectAttributes  rttr) {
		log.info("register : "+board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
		
	}

	@GetMapping({"/get",  "/modify"})
	public void get(@RequestParam("bno")long bno,@ModelAttribute("cri") Criteria cri,Model model) {
		
		log.info("/get");
		model.addAttribute("board", service.get(bno));
		
	}
	@PostMapping("/modify_update")
	public String  modify_update(BoardVO board,@ModelAttribute("cri")Criteria cri,RedirectAttributes rttr) {
		
		log.info("modify : " + board);
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pagenum", cri.getPagenum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		
		return "redirect:/board/list"+cri.getListLink();
		
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") long bno,@ModelAttribute("cri")Criteria cri,RedirectAttributes rttr) {
		
		log.info("remove .. " +bno);
		
		if(service.delete(bno)) {
			rttr.addAttribute("result", "success");
		}
		rttr.addAttribute("pagenum", cri.getPagenum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list"+cri.getListLink();
	}
	
	

}//BoardController
