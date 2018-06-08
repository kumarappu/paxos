package com.paxos.assignment2Bonus;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2Bonus {
	
	
	
	static ArrayList <String> identifierList=new ArrayList<>();
	static ArrayList <Integer> priceList=new ArrayList<>();
	
	public static void main(String[] args) {
		String file;
		int giftCardBalance;
		
		if(args.length==2){
			file= args[0];
			giftCardBalance =Integer.parseInt(args[1]);
		}else{
			System.out.println("Enter  following  two arguements :\n FilePath and GiftCard balance");
			return;
		}
		
	
		
         System.out.println(findThreeItems(file,giftCardBalance));
		
	}
	
	
	public static String findThreeItems(String file,int giftCardBalance){
		
		try {
			readFromFile(file);
		
		 } catch (IOException e) {

			System.out.println("Error while reading from the input file :"+e.getMessage());
			System.exit(1);
		}
		
		
		/** Number of items */
		int size=priceList.size(); 		
        int diff = Integer.MAX_VALUE;
		
        /**Place holder for result pair */
		int leftResultIndex=0;
		int rightResultIndex= size-1;
		
		int ithResultIndex= 0;;
		
		int threeItemsSum=0;//Holds sum of two prices at each iteration;
        
		/**
		 * Keeping one item fixed and iterating 
		 * through rest of the list 
		 * 
		 */
        for(int i=0;i<size;i++){
        	
	        /** Initializing  left and right indexes before iterating over remaining list */
	        int leftIndex = i+1, rightIndex = size-1;	
			
			while(rightIndex>leftIndex){
				
	            /**Finding pair difference against gift card balance  */
				threeItemsSum=priceList.get(leftIndex) + priceList.get(rightIndex)+priceList.get(i);		
				int currentDiff= giftCardBalance-threeItemsSum;
				
	            if (currentDiff >=0 && currentDiff < diff)
	            {
	            	leftResultIndex = leftIndex;
	            	rightResultIndex = rightIndex;
	            	ithResultIndex = i;
	                diff = currentDiff;
	            }
				
	            if (threeItemsSum > giftCardBalance){
	            	
	            	rightIndex--; //Moving right index to smaller value
	            }
	            else{
	            	leftIndex++; ////Moving left index to higher value
	            }
	            
	            
			}
		
        }
		threeItemsSum=priceList.get(leftResultIndex) + priceList.get(rightResultIndex)+priceList.get(ithResultIndex);
		
		if(threeItemsSum>giftCardBalance )			
			return "Not possible";

		else {
			String output = String.format("%s %d, %s %d, %s %d",
					        identifierList.get(ithResultIndex), priceList.get(ithResultIndex),
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
