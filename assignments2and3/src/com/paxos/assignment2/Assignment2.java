package com.paxos.assignment2;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	
	
	static ArrayList <String> identifierList=new ArrayList<>();
	static ArrayList <Integer> priceList=new ArrayList<>();
	
	public static void main(String[] args) {
		String file;
		int giftCardBalance;
		
		if(args.length==2){
			file= args[0];
			giftCardBalance =Integer.parseInt(args[1]);
		}else{
			System.out.println("Pass  following  two arguements :\n FilePath and GiftCard balance");
			return;
		}
		
	
		
         System.out.println(findPair(file,giftCardBalance));
		
	}
	
	
	public static String findPair(String file,int giftCardBalance){
		
		/** Read the input file and initialize identifierList and priceList */
		try {
			readFromFile(file);
		
		 } catch (IOException e) {

			System.out.println("Error while reading from the input file :"+e.getMessage());
			System.exit(1);
		}
		
		

		int size=priceList.size(); 
		
        /** Initializing  left and right indexes before iterating over list */
        int leftIndex = 0, rightIndex = size-1;
        		
        
        /** This holds difference of giftcard
         *   balance and sum of pair , initializing
         *    with MAX integer value*/
        int diff = Integer.MAX_VALUE;
		
        /**Place holder for result pair */
		int leftResultIndex=0;
		int rightResultIndex= rightIndex;
		
		int pairSum=0;//Holds sum of two prices at each iteration;
		
		while(rightIndex>leftIndex){
			
     
			pairSum=priceList.get(leftIndex) + priceList.get(rightIndex);		
			int currentDiff= giftCardBalance-pairSum;
			
            if (currentDiff >=0 && currentDiff < diff)
            {
            	leftResultIndex = leftIndex;
            	rightResultIndex = rightIndex;
                diff = currentDiff;
            }
			
            if (pairSum > giftCardBalance){
            	
            	rightIndex--; //Moving right index to smaller value
            }
            else{
            	leftIndex++; ////Moving left index to higher value
            }
            
            
		}
		
		pairSum=priceList.get(leftResultIndex) + priceList.get(rightResultIndex);
		
		if(pairSum>giftCardBalance )			
			return "Not possible";

		else {
			String output = String.format("%s %d, %s %d",
							identifierList.get(leftResultIndex), priceList.get(leftResultIndex),
							identifierList.get(rightResultIndex), priceList.get(rightResultIndex)
							);
			return output;
		}
	}
	
	
	

    /** 
     * Reading file line by line
     * and storing the identifier 
     * and price in ArrayList 
     *  
     * */
	
  public static void readFromFile(String file) throws IOException{
	    identifierList.clear();
	    priceList.clear();
	  
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream(file);
		    sc = new Scanner(inputStream, "UTF-8");
		    

		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        String[] tokens=line.split(",");
		        identifierList.add(tokens[0].trim());
		        priceList.add(Integer.parseInt(tokens[1].trim()));
		        
		    }
		    
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		
  }

}
