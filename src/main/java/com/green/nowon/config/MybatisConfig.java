package com.green.nowon.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig { //baen: mybatisConfig
	//DataSource : jpa 적용
	//SqlSessionFactory
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration myMybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}
	
		
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
		ssfb.setDataSource(dataSource);
		ssfb.setConfiguration(myMybatisConfig());
		
		String locationPattern="classpath:mapper/**/*-mapper.xml";
		
		Resource[] mapperLocations=
				new PathMatchingResourcePatternResolver().getResources(locationPattern);
		
		ssfb.setMapperLocations(mapperLocations);
		
		return ssfb.getObject();
	}
	
	@Bean
	public SqlSessionTemplate  SqlSessionTemplate(DataSource dataSource) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory(dataSource));
	}
	

}
