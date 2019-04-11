package com.automationapproach;

import org.testng.annotations.Test;

import com.automationapproach.base.BaseWebTest;

public class SecondTest extends BaseWebTest{
	
	@Test
	public void secondTest() {

		// open ecosia.org
		driver.get("http://www.ecosia.org");
		System.out.println("Ecosia opened. Test passed.");

	}

}
