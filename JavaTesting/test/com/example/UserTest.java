package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {
	
	private final User us = new User();

//	@Test
//	void testConnection() {
//		actualValue = DBConnUtil.getConn();
//		assertNotNull(actualValue , " DB Connection failure");
//	}
//		
//	}
//	
	//Positive test case
	@Test
	void testValidUser() {
		assertTrue(us.isValidUser("sai", "123456")); // assuming that this user name exist 
	}
	
	// Negative test case
	@Test
	void testInValidUser()
	{
		
		assertFalse(us.isValidUser("Hello", "abc123")); // To check invalid user that does not exist in a table
	}
	
	@Test
	void testShortPassword()
	{
		
		assertFalse(us.isValidUser("sai", "123")); // checking the password length which should be greater than 6
	}
	
	@Test
	void testEmptyInput()
	{
		
		assertFalse(us.isValidUser("sai", "")); // checking the empty fields 
	}

}