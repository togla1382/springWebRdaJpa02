package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.nowon.service.board.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/boards")
	public String list(Model model) {
		//service.listAll(model);
		service.getListAll(model);
		
		return "board/list";//Model객체는 응답 페이지까지 유효
	}
}
