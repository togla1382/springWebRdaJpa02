package com.green.nowon.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;

@Mapper
public interface MyBoardMapper {

	@Select("select * from my_board")
	List<MyBoardDTO> findAll();

	@Insert("insert into my_board(title, content, writer,read_count) "
			+ "values(#{title}, #{content}, #{writer}, #{readCount} )")
	void save(MyBoardDTO obj);

	@Select("select * from my_board where bno=#{bno}")
	MyBoardDTO findByBno(long bno);

	@Delete("delete from my_board where bno=#{bno}")
	void deleteByBno(long bno);

}
