package me.sseob.demowebapplication.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
		table 생성하기
		h2 console로 확인하자 !
		
		mysql 사용함에 따라 excute method들 주석처리 
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//try catch with resource
		try(Connection connection = dataSource.getConnection()) {
			Statement statement = connection.createStatement();
			String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (ID));";
//			statement.executeUpdate(sql);
		}

//		jdbcTemplate.execute("INSERT INTO USER VALUES (1,'sseob')");
	}
}