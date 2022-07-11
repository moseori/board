package me.light.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import me.light.AppTest;

public class MemberTest extends AppTest{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	@Ignore
	public void MemberInsertTest() {
		String sql="insert into member_tbl(userId, userPw, userName) values(?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "leekwanghyup");
			pstmt.setString(2, passwordEncoder.encode("1234"));
			pstmt.setString(3, "이광협");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void adminInsertTest() {
		String sql="insert into member_tbl(userId, userPw, userName) values(?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "admin");
			pstmt.setString(2, passwordEncoder.encode("1234"));
			pstmt.setString(3, "관리자");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
