package com.care.sc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.care.sc.dto.LoginDTO;
import com.care.sc.dto.RegisterDTO;

@Repository //저장소 관리
public class MemberDAO {
	/*
	 * 테이블은 sc 라는 이름으로 만들어주세요
	 * 컬럼은 id, pw, name 세개의 컬럼을 만들어주세요.
	 * 사이즈는 자유, id는 primary key
	 * 
	 * 데이터를 직접 명령으로 입력하세요.
	 * id : admin
	 * pw : 1234
	 * name : 관리자
	 * 
	 * --정답--
	 * SQL> create table sc(
  2  id varchar2(10),
  3  pw varchar2(10),
  4  name varchar2(20),
  5  primary key(id)
  6  );
 
 테이블이 생성되었습니다.
  
  insert into sc values('admin','1234','관리자');
  
 SQL> commit;
	 */
	private Connection con;
	public MemberDAO() {
		// 데이터베이스 드라이버 로드
		// 데이터베이스 연결해서 로그인
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="1234";
		try {
			//JVM에 클래스를 로드할 수 있다.
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public LoginDTO login(String id) {
		String sql="SELECT * FROM sc WHERE id=?";
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				LoginDTO login=new LoginDTO();
				login.setId(id);
				login.setPw(rs.getString("pw"));
				return login;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int register(RegisterDTO reg) {
		String sql="INSERT INTO sc VALUES(?,?,?)";
		int rowCount=0;
		
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, reg.getId());
			ps.setString(2, reg.getPw());
			ps.setString(3, reg.getName());
			
			rowCount=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return rowCount;
	}
}
