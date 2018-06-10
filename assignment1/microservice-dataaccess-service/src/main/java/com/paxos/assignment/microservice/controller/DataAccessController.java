package com.paxos.assignment.microservice.controller;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paxos.assignment.microservice.bean.DataAccessServiceMessage;
import com.paxos.assignment.microservice.cache.CacheManager;


/**
 * This microservice handles request from SHA256 service
 * @author appu_kumar
 *
 */

@RestController
public class DataAccessController {
	
	CacheManager cacheManager=CacheManager.getInstance();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * This handler returns the original message 
	 * for the requested digest.
	 * 
	 * @param digest
	 * @return
	 */
	@GetMapping("/dataaccess/digest/{digest}")
	public DataAccessServiceMessage getMessageFromCache(@PathVariable String digest){
		
	      String message=null;
		try {
			message=cacheManager.get(digest);
			
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return new DataAccessServiceMessage(message,digest);
	}
	
	/**
	 * This handler post the digest and message in in cache
	 * @param request
	 * @return
	 */
	@PostMapping("/dataaccess/publish")
	public ResponseEntity<HttpStatus> publishToCache(@RequestBody DataAccessServiceMessage request){
		
		try {
			cacheManager.put(request.getDigest(), request.getMessage());
		     return new ResponseEntity<>(HttpStatus.OK); 
			
		} catch (ExecutionException e) {
			logger.error(e.getMessage());
			   return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED); 
		}
		
	}
	

}
