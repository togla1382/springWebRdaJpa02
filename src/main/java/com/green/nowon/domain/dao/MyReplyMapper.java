package com.green.nowon.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.green.nowon.domain.dto.mybatis.MyReply;

@Mapper
public interface MyReplyMapper {

	@Insert("insert into my_reply(text, writer, bno) values(#{text}, #{writer}, #{bno})")
	void save(MyReply dto);

	@Select("select * from my_reply where bno=#{fk}")
	List<MyReply> findByBno(@Param("fk") long bno);

}
