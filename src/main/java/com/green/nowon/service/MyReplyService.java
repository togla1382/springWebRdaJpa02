package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.mybatis.MyReply;

public interface MyReplyService {

	void save(long bno, MyReply dto);

	void delete(long rno);

	void update(long rno, String text);

	void getList(long bno, Model model);

}
