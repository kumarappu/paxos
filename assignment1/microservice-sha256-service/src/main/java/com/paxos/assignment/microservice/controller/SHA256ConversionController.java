package com.paxos.assignment.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paxos.assignment.microservice.bean.DataAccessServiceMessage;
import com.paxos.assignment.microservice.bean.SHA256ServiceMessage;
import com.paxos.assignment.microservice.bean.SHA256ServiceMessage.ResponseDigest;
import com.paxos.assignment.microservice.exception.ResourceNotFoundException;
import com.paxos.assignment.microservice.proxy.DataAccessService;
import com.paxos.assignment.microservice.util.Sha256Utility;


/**
 * @author appu_kumar
 * 
 * SHA256ConversionController is entry point 
 * to accept rest GET and POST Request for 
 * SHA256 services .
 */
@RestController
public class SHA256ConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataAccessService dataAccessService;

/**
 * This POST service handler accepts a JSON request.
 * After request validation and  SHA256-hash 
 * calculation, result is sent to Dataaccess 
 * micro-service before sending response to user.
 * 
 * @param request
 * @return
 **/
	@PostMapping("/messages")
	public SHA256ServiceMessage.ResponseDigest getSha256HashDigest(@RequestBody SHA256ServiceMessage.Request request){
		
		if(Sha256Utility.validateRequest(request)){
			
			String digest= Sha256Utility.getSHA256Hash(request.getMesssage());
			
			dataAccessService.publishToCache(new DataAccessServiceMessage(request.getMesssage(),digest));
			
			return new SHA256ServiceMessage.ResponseDigest(digest);
			
		}
		else{
			 throw new ResourceNotFoundException("Invalid Request");
		}
		

		
		
		
	}
	
/**
 * This rest service handler returns the 
 * original message for provided hash digest.
 * 
 * For non-existent message it returns 404 error.
 * 
 * @param digest
 * @return
 */
	@GetMapping("/messages/{digest}")
	public SHA256ServiceMessage.ResponseMessage retrieveMessage(@PathVariable String digest){
		
		DataAccessServiceMessage dataAccessServiceMessage=dataAccessService.getMessage(digest);
		
		String message=dataAccessServiceMessage.getMessage();
		if(message!=null && message.length()!=0 )
			return new SHA256ServiceMessage.ResponseMessage(message);
		else
	       throw new ResourceNotFoundException("Message not found");
		
	}
	
	

}
