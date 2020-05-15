package mentoring;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratingSample {
	
	public static void main (String[]args) 
	{
		LocalDateTime timeStamp = LocalDateTime.now();
		int intCustomerId = 0;
		int intProductId = 0;
		int intStateId = 2;
		
		for (int i = 1; i < 10000; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1,101);
			
			if (randomNum < 15 && i != 1 && intStateId != 2)
			{
				timeStamp = timeStamp.plusSeconds(randomNum);
				intStateId = 2;
			}
			else
			{
				
				intCustomerId = (randomNum % 5) + 1;
				
				intProductId = (randomNum % 16) + 1;
				
				timeStamp = timeStamp.plusMinutes(randomNum);
				
				intStateId = 1;
			}
			
			System.out.print("(" + intCustomerId + ", " + intProductId + ",*" + timeStamp + "*," + intStateId + "),");			
			
		}
		
		
		
	}
	

}
