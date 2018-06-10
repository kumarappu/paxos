package com.paxos.assignment.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author appu_kumar
 *
 *This class boot start the micro-service.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DataaccessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataaccessServiceApplication.class, args);
	}
}
