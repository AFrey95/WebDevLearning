package com.ln.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ln.web.model.TabRow;


public class DBTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		DBUtils utils = new DBUtils();
		List<TabRow> rows = utils.getAllUsers();
		for(TabRow row : rows) {
			System.out.println(row.toString());
		}
		
		Assert.assertEquals(12, rows.size());
		
		//get person 2
		System.out.println("\nGetting User:id=2\n-----------------");
		
		List<TabRow> user2 = utils.getUserById(2);
		for(TabRow row : user2) {
			System.out.println(row.toString());
		}
		
		Assert.assertEquals(3, user2.size());
	}
	@Test
	public void test2() throws SQLException {
		DBUtils dbutils = new DBUtils();
//		List<TabRow> rows = dbutils.getAllUsers();
		List<TabRow> CurrUser = new ArrayList<TabRow>();
		
		String username = "Steven23";
//		String password = "hunter2";
		
		System.out.println("\n\n");
		CurrUser = dbutils.getUserByUsername(username);
		System.out.println(CurrUser.get(0).getClass().getName());
		
		for(TabRow row : CurrUser) {
			System.out.println(row.toString());
		}
		
		Assert.assertEquals(5, CurrUser.size());
		
	}

}