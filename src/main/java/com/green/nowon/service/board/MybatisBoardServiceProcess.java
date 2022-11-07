package com.green.nowon.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dao.MyBoardMapper;
import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
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

}
