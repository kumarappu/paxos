package com.paxos.assignment.microservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.paxos.assignment.microservice.bean.DataAccessServiceMessage;


@FeignClient(name="dataaccess-service")
@RibbonClient(name="dataaccess-service")
public interface DataAccessService {
	
	  @GetMapping("/dataaccess/digest/{digest}")
	  public DataAccessServiceMessage getMessage
	    (@PathVariable("digest") String digest);
	  
	  
		@PostMapping("/dataaccess/publish")
		public ResponseEntity<HttpStatus> publishToCache(@RequestBody DataAccessServiceMessage request);
  
}
