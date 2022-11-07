package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import com.green.nowon.service.MybatisBoardService;
import com.green.nowon.service.board.MybatisBoardServiceProcess;

@Controller
public class MybatisBoardController {
	
	@Autowired
	private MybatisBoardService service;
	
	@GetMapping("/mabatis/boards/registration")
	public String write() {
		return "board/mybatis-write";
	}
	
	//리스트로 이동하는 주소
	@GetMapping("/mybatis/boards")
	public String list(Model model) {
		
		service.list(model);
		
		return "board/list";
	}
	
	@PostMapping("/mabatis/boards")
	public String save(MyBoardDTO dto) {
		
		service.save(dto);
		
		return "redirect:/mybatis/boards";//get요청방식으로
	}
	
	@GetMapping("/mybatis/boards/{bno}")
	public String detail(@PathVariable long bno, Model model) {
		
		service.detail(bno, model);
		
		return "board/detail";
	}
	
	@DeleteMapping("/mybatis/boards/{bno}")
	public String delete(@PathVariable long bno) {
		
		service.delete(bno);
		
		return "redirect:/mybatis/boards";//get요청방식으로
	}

}
