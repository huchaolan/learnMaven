package com.juvenxu.mvnbook.helloworld;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void testSayHello() {
		HelloWorld h = new HelloWorld();
		String result = h.sayHello();
		assertEquals("Hello,Maven", result);
	}
}