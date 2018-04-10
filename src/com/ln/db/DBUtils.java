package com.ln.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ln.web.model.TabRow;

public class DBUtils {
	
	public List<TabRow> getAllUsers() throws SQLException {
	
		TabRow inRow = null;
		List<TabRow> rows = new ArrayList<TabRow>();
		
		//connect
		Connection conn = null;
		try {
			conn = connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement stmt = null;
		stmt = conn.createStatement();

		String sql = "select p.person_id, p.username, p.password, i.role, i.name, i.age, c.class,"
				+ " t.chapter, t.test_grade from WebPeople.Person p"
				+ " join WebPeople.Person_info i on p.person_id = i.person_id"
				+ " join WebPeople.Class c on i.info_id = c.info_id"
				+ "	join WebPeople.Test t on c.class_id = t.class_id";
		
		// get the stuff
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			inRow = new TabRow();
			
			inRow.setId(rs.getInt("person_id"));
			inRow.setUsername(rs.getString("username"));
			inRow.setPassword(rs.getString("password"));
			inRow.setRole(rs.getString("role"));
			inRow.setName(rs.getString("name"));
			inRow.setAge(rs.getInt("age"));
			inRow.setTheclass(rs.getString("class"));
			//inRow.setClass_grade(rs.getInt("class_grade"));
			inRow.setChapter(rs.getInt("chapter"));
			inRow.setTest_grade(rs.getInt("test_grade"));
			
			rows.add(inRow);
		}
		
		rs.close();
		conn.close();
		
		return rows;
	}
	
	// creates connection
	private Connection connect() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		// connect
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String DB_URL = "jdbc:mysql://localhost:3306/WebPeople";
//		String DB_URL = "localhost:3306/WebPeople";
		String user = "root";
		String pass = "TemporaryLatitude";
		Connection conn = null;
		conn = DriverManager.getConnection(DB_URL + "?user=" + user + "&password=" + pass);
		return conn;
	}
	// Gets specific person
	public List<TabRow> getUserById(int id) throws SQLException {
		List<TabRow> all = getAllUsers();
		List<TabRow> getPerson = new ArrayList<TabRow>();
		
		for(TabRow row : all) {
			if(row.getId() == id) {
				getPerson.add(row);
			}
		}
		
		return getPerson;
	}
	
	public List<TabRow> getUserByUsername(String user) throws SQLException {
		List<TabRow> all = getAllUsers();
		List<TabRow> getPerson = new ArrayList<TabRow>();
		
		for(TabRow row : all) {
			if(user.equals(row.getUsername())) {
				getPerson.add(row);
			}
		}
		
		return getPerson;
	}
	
}
