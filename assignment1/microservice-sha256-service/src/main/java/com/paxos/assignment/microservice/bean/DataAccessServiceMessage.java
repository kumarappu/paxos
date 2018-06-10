package com.paxos.assignment.microservice.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author appu_kumar
 *
 * This is bean class to hold dataaccess message.
 */
public class DataAccessServiceMessage {
	
	String message;
	String digest;
	
	
	@JsonCreator
	public DataAccessServiceMessage(@JsonProperty("message")String message, @JsonProperty("digest")String digest) {
		super();
		this.message = message;
		this.digest = digest;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	
	
	

}
