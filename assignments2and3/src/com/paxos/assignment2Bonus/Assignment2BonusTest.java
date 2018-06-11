package com.paxos.assignment2Bonus;

import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment2BonusTest {

	@Test
	public void testFindThreeItems1() {
		System.out.println(" assertEquals('Candy Bar 500, Paperback Book 700, Detergent 1000',Assignment2Bonus.findThreeItems('price.txt', 2500))");
	   assertEquals("Candy Bar 500, Paperback Book 700, Detergent 1000",Assignment2Bonus.findThreeItems("price.txt", 2500));

	}
	
	@Test
	public void testFindThreeItems2() {
		System.out.println(" assertEquals('Candy Bar 500, Paperback Book 700, Headphones 1400',Assignment2Bonus.findThreeItems('price.txt', 2700))");

	     assertEquals("Candy Bar 500, Paperback Book 700, Headphones 1400",Assignment2Bonus.findThreeItems("price.txt", 2700));
     	
	}
	
	@Test
	public void testFindThreeItems3() {
		System.out.println(" assertEquals('Headphones 1400, Earmuffs 2000, Bluetooth Stereo 6000',Assignment2Bonus.findThreeItems('price.txt', 10000))");
	    assertEquals("Headphones 1400, Earmuffs 2000, Bluetooth Stereo 6000",Assignment2Bonus.findThreeItems("price.txt", 10000));

	}
	
	@Test
	public void testFindThreeItems4() {
		System.out.println(" assertEquals('Not possible',Assignment2Bonus.findThreeItems('price.txt', 1100))");
	    assertEquals("Not possible",Assignment2Bonus.findThreeItems("price.txt", 1100));
		
	}
}
