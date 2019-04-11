package com.automationapproach;

import org.testng.annotations.Test;

import com.automationapproach.base.BaseWebTest;

public class FirstTest extends BaseWebTest{

	@Test
	public void firstTest() {

		// open google.com
		driver.get("http://www.google.com");
		System.out.println("Google opened. Test passed.");

	}

}