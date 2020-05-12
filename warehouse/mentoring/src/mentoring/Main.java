package mentoring;

import java.sql.SQLException;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		//Timestart um die Zeit in Millisekunden zu speichern
		
		
		//Ruft ein Objekt aus Klasse Databaseservice auf, um Funktionen durchzuführen
		DatabaseService service = new DatabaseService();

		
		System.out.println("berto@comp.de name:");
		long timeStart = System.currentTimeMillis();
		String name = service.queryBertoBartName();
		long timeEnd = System.currentTimeMillis();
		System.out.println(name);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();
		int count = 0;
		System.out.println("Amount of customers who watched more than 2 items (x100):");
		timeStart = System.currentTimeMillis();
		count = service.countCustomerBought();
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();
		
		System.out.println("Amount of customers who watched more than 2 items (x100) (Using No Index):");
		timeStart = System.currentTimeMillis();
		count = service.countCustomerBoughtNoIndex();
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();

		System.out.println("Amount of customers who watched more than 2 items (x100) (Stored):");
		timeStart = System.currentTimeMillis();
		count = service.countCustomerBoughtStored();
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();
		
		System.out.println("Amount of customers who watched more than 2 items (x100) (Stored) (Using No Index):");
		timeStart = System.currentTimeMillis();
		count = service.countCustomerBoughtStoredNoIndex();
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();

		System.out.println("Amount of bought Haushaltswaren (x100):");
		timeStart = System.currentTimeMillis();
		count = service.countBoughtHaushaltswaren();
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();

		System.out.println("Amount of bought Haushaltswaren (x100) (Using No Index):");
		timeStart = System.currentTimeMillis();
		count = service.countBoughtHaushaltswarenNoIndex();
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();

		System.out.println("Amount of bought Haushaltswaren (x100) (Stored):");
		timeStart = System.currentTimeMillis();
		count = service.countBoughtHaushaltswarenStored();
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();

		System.out.println("Amount of bought Haushaltswaren (x100) (Stored) (Using No Index):");
		timeStart = System.currentTimeMillis();
		count = service.countBoughtHaushaltswarenStoredNoIndex();
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();

		System.out.println("Ratio of Watched/Bought (x100):");
		timeStart = System.currentTimeMillis();
		float ratio = service.getRatioOfWatchedBought("marko@dhbw-stuttgart.de");
		timeEnd = System.currentTimeMillis();
		System.out.printf("%.3f\n", ratio);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();

		System.out.println("Ratio of Watched/Bought (x100) (Using No Index):");
		timeStart = System.currentTimeMillis();
		ratio = service.getRatioOfWatchedBought("marko@dhbw-stuttgart.de");
		timeEnd = System.currentTimeMillis();
		System.out.printf("%.3f\n", ratio);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();

		System.out.println("Ratio of Watched/Bought (x100) (Stored):");
		timeStart = System.currentTimeMillis();
		ratio = service.getRatioOfWatchedBoughtStored("marko@dhbw-stuttgart.de");
		timeEnd = System.currentTimeMillis();
		System.out.printf("%.3f\n", ratio);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.\n");

		service.resetCache();

		System.out.println("Ratio of Watched/Bought (x100) (Stored) (Using No Index):");
		timeStart = System.currentTimeMillis();
		ratio = service.getRatioOfWatchedBoughtStoredNoIndex("marko@dhbw-stuttgart.de");
		timeEnd = System.currentTimeMillis();
		System.out.printf("%.3f\n", ratio);
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.");
		
		service.close();
	}
	
	
	
}
