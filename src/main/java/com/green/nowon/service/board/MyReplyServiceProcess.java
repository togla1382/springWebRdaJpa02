package com.green.nowon.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dao.MyReplyMapper;
import com.green.nowon.domain.dto.mybatis.MyReply;
import com.green.nowon.service.MyReplyService;


@Service
public class MyReplyServiceProcess implements MyReplyService {

	@Autowired
	private MyReplyMapper mapper;
	
	@Override
	public void save(long bno, MyReply dto) {
		dto.setBno(bno);
		mapper.save(dto);
		
	}

}
