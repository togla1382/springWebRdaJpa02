package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;

public interface MybatisBoardService {

	void list(Model model);

	void save(MyBoardDTO dto);

}
