package QA_Test_pkg;
import java.util.Random;

// 2) Write a simple script that accepts a valid integer between 1 to 3 - call it n

 // Solution: The idea is that I will be generating 10 random integer numbers. Each could be anywhere from 0 to 11 (0 & 11 included).
       // compiler checks if the randomly generated number is equivalent to the values 1 or 2 or 3.

        
             /**********************************************************************************************************
                                    Screenshots provided in:  2_Screenshot.png
             **********************************************************************************************************/
public class B_validInteger {

	public static void main(String[] args) {
		
		Random generate= new Random();
		int count= 10;
		for (int i=0; i<count  ;i++)  // loops 10 times.
		{
			int randomIntRange= generate.nextInt(12);  // Range of each random number generated is 0 to 11 (0 & 11 included)
		
			if (randomIntRange <=3 && randomIntRange !=0)
			{
				System.out.println("");
				System.out.println("============== Generated Random number is: " +randomIntRange +" =====================");
				System.out.println(" n= " +randomIntRange + " : Is a valid integer between 1 to 3");
				System.out.println("");
			}
	
			else
			{   System.out.println("");
			    System.out.println("============== Generated Random number is: " +randomIntRange +" =====================");
				System.out.println(randomIntRange + " : Is Not a valid integer between 1 to 3"); 
				System.out.println("");
			}
		}

	}

}
