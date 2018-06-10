package com.paxos.assignment.microservice.util;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

import com.paxos.assignment.microservice.bean.SHA256ServiceMessage;

public class Sha256Utility {
	
	
    /**
     * Returns a hexadecimal encoded SHA-256 hash for the input String.
     * @param data
     * @return 
     */
    public static String getSHA256Hash(String data) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return bytesToHex(hash); // make it printable
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    
    /**
     * Use javax.xml.bind.DatatypeConverter class in JDK to convert byte array
     * to a hexadecimal string. Note that this generates hexadecimal in lower case.
     * @param hash
     * @return 
     */
    public static String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash).toLowerCase();
    }
    
    public static boolean validateRequest(SHA256ServiceMessage.Request request){
    	String message=request.getMesssage();
    	if(message!=null && message.length()!=0 )
    		return true;
    	else
    		return false;
    }
    
    
}
