package com.paxos.assignment.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author appu_kumar
 *
 *This class boot start the micro-service.
 */

@SpringBootApplication
@EnableFeignClients("com.paxos.assignment.microservice")
@EnableDiscoveryClient
public class Sha256ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sha256ServiceApplication.class, args);
	}
}
