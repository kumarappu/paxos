# paxos
paxos assignments

## Instrunctions to run Assinment 1 on local
 #### Pre-requisite : JDK 1.8 to be set on PATH
    - Download the zip or clone the Git repository.
    - Unzip the zip file (if you downloaded one)
    - Open Command Prompt and Change directory (cd) to paxos\assignment1
    - (on Windows) :
        Double click on runAssignment1.bat or type runAssignment1.bat from CMD
    - (on Linux) :
        chmod 755 runAssignment1.sh
        ./runAssignment1.sh
    - There are 20 seconds gap between  two micro services (Total wait 40 seconds)
    -  When all the micro services are up, submit  request as shown in following examples
    
   
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
       



## Instrunctions to run Assinment 2 & 3
    - Download the zip or clone the Git repository.
    - Unzip the zip file (if you downloaded one)
    - Open Command Prompt and Change directory (cd) to paxos\assignments2and3
  
 #### Pre-requisite : JDK 1.8 to be set on PATH
 
 ### Assinment 2
   #### Source Code
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment2/Assignment2.java
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment2/Assignment2Test.java
  
   #### Running examples and test cases
      java -cp bin com.paxos.assignment2.Assignment2 price.txt 2500
      java -cp .;bin;lib/* org.junit.runner.JUnitCore  com.paxos.assignment2.Assignment2Test
      
   #####  Big O notation 
        Time:  O(N)
        Space: O(N)


 ### Assinment 2 (Bonus)
   #### Source Code
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment2Bonus/Assignment2Bonus.java
   https://github.com/kumarappu/paxos/blob/master/assignments2and3/src/com/paxos/assignment2Bonus/Assignment2BonusTest.java
   
   #### Running examples and test cases
      java -cp bin com.paxos.assignment2Bonus.Assignment2Bonus price.txt 10000
      java -cp .;bin;lib/* org.junit.runner.JUnitCore  com.paxos.assignment2Bonus.Assignment2BonusTest
      
   #####  Big O notation 
        Time:  O(N*N)
        Space: O(N)

 ### Assinment 3
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


