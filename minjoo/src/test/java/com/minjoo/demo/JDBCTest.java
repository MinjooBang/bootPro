package com.minjoo.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JDBCTest {
	Logger logger = LoggerFactory.getLogger("JDBCTest");

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		try (Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","gkdwjdtkf1!")
			)
		{
			logger.info(""+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
