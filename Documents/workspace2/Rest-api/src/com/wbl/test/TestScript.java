package com.wbl.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.axatrikx.controller.RestExecutor;

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
			.expectCode(200)			// Expected code of 200
			.expectMessage("OK")		// Expected Message of 'OK'
			.expectHeader("Content-Type", "application/json; charset=utf-8") // Content-Type header value
			.expectInBody("rest testing framework")	// Content inside the response body
			.expectInBody("webdriver framework") 	// Another Content inside the response body
			.expectInBody("axatrikx");				// Yet Another Content inside the response body
		
		/*
		 * GET for a specific item
		 */
		executor.get("/posts/1")
			.expectCode(200)
			.expectMessage("OK")
			.expectHeader("Content-Type", "application/json; charset=utf-8")
			.expectInBody("rest testing framework")
			.expectInBody("axatrikx");
		
		
		executor.get("/posts?title=rest%20testing%20framework&author=axatrikx")
			.expectCode(200)
			.expectMessage("OK")
			.expectHeader("Content-Type", "application/json; charset=utf-8")
			.expectInBody("rest testing framework")
			.expectInBody("axatrikx");
	}
	


	@Test
	public void testPOSTMethod() {
		
		executor.post("/posts", "{ \"title\": \"new test\", \"author\": \"axatrikx\" }", "application/json")
			.expectCode(201)
			.expectMessage("Created")
			.expectHeader("Content-Type", "application/json; charset=utf-8")
			.expectInBody("\"title\": \"new test\"")
			.expectInBody("axatrikx");
	}
}