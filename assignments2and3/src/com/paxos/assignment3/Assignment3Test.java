package com.paxos.assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment3Test {

	@Test
	public void testGenerateAllPatterns() {
		 /** Validating count of patterns generated */
		  System.out.println("Input pattern : X0");
		  System.out.println("Output pattern");
		  Assignment3.counter=0;
		  assertEquals(2,Assignment3.generateAllPatterns("X0".toCharArray(),0));
		  
		  System.out.println("\nInput pattern : 10X10X0");
		  System.out.println("Output pattern");
		  Assignment3.counter=0;
		  assertEquals(4,Assignment3.generateAllPatterns("10X10X0".toCharArray(),0));
		  
		  System.out.println("\nInput pattern : 10X10XX");
		  System.out.println("Output pattern");
		  Assignment3.counter=0;
		  assertEquals(8,Assignment3.generateAllPatterns("10X10XX".toCharArray(),0));
	}

}
