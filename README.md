# paxos
paxos assignments




## Instrunctions to run Assinment 2 & 3
    - Download the zip or clone the Git repository.
    - Unzip the zip file (if you downloaded one)
    - Open Command Prompt and Change directory (cd) to paxos\assignments2and3
  
  
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


