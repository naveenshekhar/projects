package com.java.trafficcontrolsystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrafficServiceTest {

	TrafficService trafficService = new TrafficService();
	boolean result;

	@After
	public void test2() {
		System.out.println("After");
	}

	@Before
	public void test3() {
		System.out.println("before");
	}

	@Test
	public void reNameTest() throws InterruptedException {

		String newname = trafficService.reName(1, "ABC");
		assertEquals(newname, "ABC");
	}

	@Test
	public void manualModeTest() throws InterruptedException {

		// System.out.println(result);
		result = trafficService.manualMode(1, 1);
		System.out.println("<<<<<<<<" + result + ">>>>>>>>>>");
		assertEquals(true, result);
	}

	@Test
	public void automatedTrafficTest() throws InterruptedException {

		result = false;
		result = trafficService.automatedTraffic(1, 1);
		assertEquals(true, result);
		// assertFalse(result == true);
	}

}
