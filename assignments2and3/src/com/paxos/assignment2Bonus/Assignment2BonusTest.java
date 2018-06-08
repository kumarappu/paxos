package com.paxos.assignment2Bonus;

import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment2BonusTest {

	@Test
	public void testFindThreeItems() {
		
	   assertEquals("Candy Bar 500, Paperback Book 700, Detergent 1000",Assignment2Bonus.findThreeItems("price.txt", 2500));
       assertEquals("Candy Bar 500, Paperback Book 700, Headphones 1400",Assignment2Bonus.findThreeItems("price.txt", 2700));
       assertEquals("Headphones 1400, Earmuffs 2000, Bluetooth Stereo 6000",Assignment2Bonus.findThreeItems("price.txt", 10000));
       assertEquals("Not possible",Assignment2Bonus.findThreeItems("price.txt", 1100));
		
	}
}
