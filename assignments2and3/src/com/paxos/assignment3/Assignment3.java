package com.paxos.assignment3;

public class Assignment3 {
 public static int counter=0; //This will hold number of total patterns, it will used to run test cases
	
	public static void main(String [] args){
		String pattern;
		
		if(args.length==1){
			pattern= args[0];
		}else{
			System.out.println("Provide an input string pattern");
			return;
		}
		
	 char[] charArray = pattern.toCharArray();
	 counter=generateAllPatterns(charArray, 0); // Starting with first character
		
	}
	
	
	public static int generateAllPatterns(char charArray[], int charIndex){
	
		 if (charIndex == charArray.length)
	        {
			    //Reached end of charArray, print string
	            System.out.println(charArray);
	            return counter++;
	        }
	 
	        if (charArray[charIndex] == 'X')
	        {
	        	
	            /**  replacing 'X' by '0'  and '1'
	             * and recurse after each step
	        	**/
	        	charArray[charIndex] = '0';
	        	generateAllPatterns(charArray, charIndex + 1);
	             
	            charArray[charIndex] = '1';
	            generateAllPatterns(charArray, charIndex + 1);
	             
	           
	            charArray[charIndex] = 'X'; //Reset the replaced character with X
	        }
	        else
	        	generateAllPatterns(charArray, charIndex + 1);
		
	        return counter;
	}
	
	
	
}
