package com.green.nowon.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dao.MyBoardMapper;
import com.green.nowon.domain.dao.MyReplyMapper;
import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import com.green.nowon.domain.dto.mybatis.MyReply;
import com.green.nowon.service.MybatisBoardService;

@Service
public class MybatisBoardServiceProcess implements MybatisBoardService {

	//Mybatis를 이용한 DB : DAO-Mapper
	
	@Autowired
	private MyBoardMapper mapper;
	
	@Override
	public void list(Model model) {
		
		List<MyBoardDTO> result=mapper.findAll();
		
		model.addAttribute("list", result);
		
	}

	@Override
	public void save(MyBoardDTO dto) {
		mapper.save(dto);		
	}

	
	@Autowired
	private MyReplyMapper myReplyMapper;
	
	//상세페이지 처리
	@Override
	public void detail(long bno, Model model) {
		MyBoardDTO result=mapper.findByBno(bno);
		
		model.addAttribute("detail", result);
		
		//댓글도 읽어와서
		List<MyReply> replies=myReplyMapper.findByBno(bno);
		model.addAttribute("replies", replies);
		
	}

	@Override
	public void delete(long bno) {
		mapper.deleteByBno(bno);
		
	}

	@Override
	public void update(long bno, MyBoardDTO dto) {
		//수정할때
		dto.setBno(bno);
		mapper.updateByBno(dto);
		
	}
	
	

}
