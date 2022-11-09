package com.green.nowon.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.green.nowon.domain.dto.mybatis.MyReply;

@Mapper
public interface MyReplyMapper {

	@Insert("insert into my_reply(text, writer, bno) values(#{text}, #{writer}, #{bno})")
	void save(MyReply dto);

	@Select("select * from my_reply where bno=#{fk} order by rno desc")
	List<MyReply> findByBno(@Param("fk") long bno);

	@Delete("delete from my_reply where rno=#{rno}")
	int deleteByRno(long rno);

	@Update("update my_reply set text=#{text} where rno=#{rno}")
	void update(@Param("rno")long rno,@Param("text") String text);

}
