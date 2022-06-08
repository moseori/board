package me.light.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariConfig config=new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost/board");
		config.setUsername("root");
		config.setPassword("1234");
		return new HikariDataSource(config);
		
	}

}
