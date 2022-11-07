package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.nowon.service.MybatisBoardService;
import com.green.nowon.service.board.MybatisBoardServiceProcess;

@Controller
public class MybatisBoardController {
	
	@Autowired
	private MybatisBoardService service;
	
	@GetMapping("/mybatis/boards")
	public String list(Model model) {
		
		service.list(model);
		
		return "board/list";
	}

}
