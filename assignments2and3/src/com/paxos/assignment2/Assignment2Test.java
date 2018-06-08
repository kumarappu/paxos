package com.paxos.assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment2Test {

	@Test
	public void testFindPair() {
		
        assertEquals("Candy Bar 500, Earmuffs 2000",Assignment2.findPair("price.txt", 2500));
        assertEquals("Paperback Book 700, Headphones 1400",Assignment2.findPair("price.txt", 2300));
        assertEquals("Earmuffs 2000, Bluetooth Stereo 6000",Assignment2.findPair("price.txt", 10000));
        assertEquals("Not possible",Assignment2.findPair("price.txt", 1100));
	}

}
