package com.wbl.test;

import org.testng.annotations;
import org.testng.asserts.*;
import org.junit.Test;



public class TestScript {

	private static final String URL = "http://localhost:3000";

	private static RestExecutor executor;

	@BeforeClass
	publ
		executor = new RestExecutor(URL);
	}

	@Test
	public void testGETMethod() {
		
		executor.get("/posts")
			.expectCode(200)			
			.expectMessage("OK")		
			.expectHeader("Content-Type", "application/json") 
			.expectInBody("rest testing framework")	
			
		
		
		
			
		
		
	}


	@Test
	public void testPOSTMethod() {
		
		executor.post("/posts",  "application/json")
			.expectCode(201)
			.expectMessage("Created")
			.expectHeader("Content-Type", "application/json")
			
	}
}