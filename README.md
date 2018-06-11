# paxos
paxos assignments

# Assignment 1


Publish a small service on the web that has two endpoints:
1. /messages takes a message (a string) as a POST and returns the SHA256 hash digest
of that message (in hexadecimal format)
2. /messages/<hash> is a GET request that returns the original message. A request to a
non-existent <hash> should return a 404 error.


## Implementation 
Assignment 1 has been implemented  based on microservice architecture using Spring Boot , Netflix Eureka Naming Server for service discovery and Google Guava cache.

In this implementaion, We have two microservices and one Naming server as shown on following architecture diagram.

 ![alt text]( https://github.com/kumarappu/paxos/blob/master/assignment1/Architecture.png)
 
    
There are two instances of SHA256-service and 1 instance of Dataaccess-service running in AWS EC2 instance. Apache HTTP server has been used to loadbalance traffic for SHA256-services. Google Guava has been used an in-memory cache in data access layer.
 
 ####  Services  endpoint: http://34.203.247.220/messages.
 
  #### Eureka monitoring dashboard is available at http://34.203.247.220/:8761/ . 
  Here is screenshot for same. It reflects two instances of SHA256 microservices and one instance of Dataaccess ervice.
 ![alt text](https://github.com/kumarappu/paxos/blob/master/assignment1/EurekaNamingServer.png)
   
## Performance Question
  What would the bottleneck(s) be in your implementation as you acquire more users? How you might scale your microservice?
	  
  Answer : Both SHA256-service  and Dataaccess-service can become bottleneck. SHA256-service can run out of resources to handle large concurrent requests. Dataaccess service can become slow on large load. This can be easily scaled with following approaches. 

  - Call to dataaccess service from SHA256 service can be made async.It will help with large concurrent requests.
  - Multiple instance of SHA256-service  and Dataaccess-service can be deployed for horizental scaling to achieve high throughput.
  - AWS Elastic Load balancer with auto scaling can be easily incorporated with the current design.
  - Netflix Ribbon can also be used as software loadbalnceer to distribute request from SHA256 to dataaccess layer.
  - We can use distributed cache like Redis/Memcahe in dataaccess layer to reduce the latancey in dataaccess layer  during high load.
  
  
#### Source Code    
   
   Here are the source code for Rest handler class within each microservices.
   
   SHA256-service  https://github.com/kumarappu/paxos/blob/master/assignment1/microservice-sha256-service/src/main/java/com/paxos/assignment/microservice/controller/SHA256ConversionController.java
   
   Dataaccess-service https://github.com/kumarappu/paxos/blob/master/assignment1/microservice-dataaccess-service/src/main/java/com/paxos/assignment/microservice/controller/DataAccessController.java
   
## Instructions to test Assignment 1


- Services can be tested using any rest client  like curl, Postman, ARC etc. Here are test example using  curl.

   ###### Example 1:  POST a JSON request  with a message , and receive  SHA256 hash digest of that message in response
    
   Request:
   
      $ curl -X POST -H "Content-Type: application/json" -d '{"message": "foo"}' http://34.203.247.220/messages
   
   Response:
   
      {"digest":"2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae"}


       
   ###### Example 2: GET request that returns the original message.
   Request:

       $ curl http://34.203.247.220/messages/2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae

   Response:
   
       {"message":"foo"}

   ###### Example 3: GET request that returns 404 for non-existent message.
   Request:

        $ curl http://34.203.247.220/messages/aaaaaaaaaaaaaaaaaaaa
        
   Response:
                  
       {"httpCode":404,"httpStatus":"Not Found","err_msg":"Message not found"}


## Instructions to run Assignment 1 on  your local 
 #### Pre-requisite : JDK 1.8 to be set on PATH
    - Download the zip or clone the Git repository.
    - Unzip the zip file (if you downloaded one)
    - Open Command Prompt and Change directory (cd) to paxos-master\assignment1
    - (on Windows) :
        Double click on runAssignment1.bat or type runAssignment1.bat from CMD
    - (on Linux) :
        chmod 755 runAssignment1.sh
        ./runAssignment1.sh
    - There are 20 seconds gap between  microservices boot time (Total wait  around 60 seconds).
    -  When all the micro services are up, submit request as shown in following examples
    
   
   ###### Example 1:  POST a JSON request  with a message , and receive  SHA256 hash digest of that message in response
    
   Request:
     http://localhost:8100/messages
        
        {
         "message": "foo"
        }
        
   Response:
   
       {
        "digest": "2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae"
       }
       
       

   ###### Example 2: GET request that returns the original message.
      
   Request:
   http://localhost:8100/messages/2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae 
         
         Response:
          {
           "message": "foo"
          }
        
        



   ###### Example 3: GET request that returns 404 for message not posted earlier
          
   Request:
           http://localhost:8100/messages/aaaaaaaaaaaaaaa
          
          Response:
           {
            "httpCode": 404,
            "httpStatus": "Not Found",
            "err_msg": "Message not found"
            }
       


# Assignment 2 & 3

## Instructions to run Assignment 2 & 3
    - Download the zip or clone the Git repository.
    - Unzip the zip file (if you downloaded one)
    - Open Command Prompt and Change directory (cd) to paxoss-master\assignments2and3
  
 #### Pre-requisite : JDK 1.8 to be set on PATH
 
 ### Assignment 2
   #### Source Code
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment2/Assignment2.java
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment2/Assignment2Test.java
  
   #### Running examples and test cases
      java -cp bin com.paxos.assignment2.Assignment2 price.txt 2500
      java -cp .;bin;lib/* org.junit.runner.JUnitCore  com.paxos.assignment2.Assignment2Test
      
   #####  Big O notation 
        Time:  O(N)
        Space: O(N)


 ### Assignment 2 (Bonus)
   #### Source Code
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment2Bonus/Assignment2Bonus.java
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment2Bonus/Assignment2BonusTest.java
   
   #### Running examples and test cases
      java -cp bin com.paxos.assignment2Bonus.Assignment2Bonus price.txt 10000
      java -cp .;bin;lib/* org.junit.runner.JUnitCore  com.paxos.assignment2Bonus.Assignment2BonusTest
      
   #####  Big O notation 
        Time:  O(N*N)
        Space: O(N)

 ### Assignment 3
   #### Source Code
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment3/Assignment3.java
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment3/Assignment3Test.java
   
   #### Running examples and test cases
      java -cp bin com.paxos.assignment3.Assignment3 10X10X0
      java -cp .;bin;lib/* org.junit.runner.JUnitCore  com.paxos.assignment3.Assignment3Test
      
   #####  Big O notation 
        Time:  O( pow(2,k))
        Space: O( pow(2,k))
         Note: here k is number of X in the given input string


