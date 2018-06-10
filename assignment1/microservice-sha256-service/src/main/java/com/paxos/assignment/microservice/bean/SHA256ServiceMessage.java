package com.paxos.assignment.microservice.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author appu_kumar
 *
 * Request/Response bean
 */
public class SHA256ServiceMessage {



	public  static final class Request{
		
		
		@JsonCreator
		public Request(@JsonProperty("message") String message) {
			super();
			this.messsage = message;
		}

		String messsage;

		public String getMesssage() {
			return messsage;
		}

		public void setMesssage(String messsage) {
			this.messsage = messsage;
		}	
		
	}
	
	
	public  static final class ResponseDigest{
		
		  private String digest;
		  
		
		public ResponseDigest() {

		}

		public ResponseDigest(String digest) {
			  super();

			this.digest=digest;
		}

		public String getDigest() {
			return digest;
		}

		public void setDigest(String digest) {
			this.digest = digest;
		}

	}
	
	public  static final class ResponseMessage{
		
		private String message;

		public ResponseMessage(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		
	}
	
}
