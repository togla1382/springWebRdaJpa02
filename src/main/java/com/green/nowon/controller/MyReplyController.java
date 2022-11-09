package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.mybatis.MyReply;
import com.green.nowon.service.MyReplyService;
import com.green.nowon.service.board.MyReplyServiceProcess;

@Controller
public class MyReplyController {
	
	@Autowired
	private MyReplyService service;
	
	
	//댓글 모두 읽어오기
	@GetMapping("/mybatis/boards/{bno}/replies")
	public String replies(@PathVariable long bno, Model model) {
			
		service.getList(bno,model);
		return "board/replies";
		//응답을 다른페이지로 처리(HTML페이지가 요청한 페이지에서 성공시 결과데이터로 확인가능)
	}

	//댓글등록
	@ResponseBody
	@PostMapping("/mybatis/boards/{bno}/reply")
	public  boolean  save(@PathVariable long bno, MyReply dto) {
		service.save(bno, dto);
		return true;
	}
	
	//댓글삭제
	@ResponseBody
	@DeleteMapping("/mybatis/boards/{bno}/reply/{rno}")
	public int delete(@PathVariable long bno, @PathVariable long rno) {
		return service.delete(rno);
	}
	
	@PutMapping("/mybatis/boards/{bno}/reply/{rno}")
	public String update(@PathVariable long bno, @PathVariable long rno, String text) {
		service.update(rno, text);
		return "redirect:/mybatis/boards/"+bno;
	}
}
