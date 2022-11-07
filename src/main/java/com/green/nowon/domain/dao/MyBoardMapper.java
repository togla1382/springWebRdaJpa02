package com.green.nowon.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;

@Mapper
public interface MyBoardMapper {

	@Select("select * from my_board")
	List<MyBoardDTO> findAll();

}
