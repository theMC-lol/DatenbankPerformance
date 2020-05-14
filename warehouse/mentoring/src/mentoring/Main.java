package mentoring;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {

		// Timestart um die Zeit in Millisekunden zu speichern

		// Ruft ein Objekt aus Klasse Databaseservice auf, um Funktionen durchzuführen
		DatabaseService service = new DatabaseService();

		service.resetCache(true); // Leert den Cache 
		int count = 0;

		// Zählt die Durchschnittszeit der Abfrage "Anzahl Kunden die mehr als 2 Items angeschaut haben" unter Verwendung vom Index
		System.out.println("\nAmount of customers who watched more than 2 items (x100) (Using Index):");
		long timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			count = service.countCustomerBought();
			service.resetCache(true);
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n");

		service.resetCache(true); // Leert den Cache (Wird immer nach einer Messung geleert)

		// Zählt die Durchschnittszeit der Abfrage "Anzahl Kunden die mehr als 2 Items angeschaut haben" unter keiner Verwendung vom Index
		System.out.println("Amount of customers who watched more than 2 items (x100) (Using No Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			count = service.countCustomerBoughtNoIndex();
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n");

		service.resetCache(true);

		// Zählt die Durchschnittszeit der Abfrage "Anzahl Kunden die mehr als 2 Items angeschaut haben" unter Verwendung vom Index und Stored Procedure
		System.out.println("Amount of customers who watched more than 2 items (x100) (Stored) (Using Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			count = service.countCustomerBoughtStored();
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n");

		service.resetCache(true);

		// Zählt die Durchschnittszeit der Abfrage "Anzahl Kunden die mehr als 2 Items angeschaut haben" unter Verwendung von Stored Procedure und keiner Verwendung vom Index
		System.out.println("Amount of customers who watched more than 2 items (x100) (Stored) (Using No Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			count = service.countCustomerBoughtStoredNoIndex();
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n \n");

		service.resetCache(true);
		
		// Zählt die Durchschnittszeit der Abfrage "Anzahl gekaufter Haushaltswaren" unter Verwendung vom Index
		System.out.println("Amount of bought Haushaltswaren (x100) (Using Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			count = service.countBoughtHaushaltswaren();
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n");

		service.resetCache(true);

		// Zählt die Durchschnittszeit der Abfrage "Anzahl gekaufter Haushaltswaren" unter keiner Verwendung vom Index
		System.out.println("Amount of bought Haushaltswaren (x100) (Using No Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			count = service.countBoughtHaushaltswarenNoIndex();
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n");

		service.resetCache(true);

		// Zählt die Durchschnittszeit der Abfrage "Anzahl gekaufter Haushaltswaren" unter Verwendung vom Index und Stored Procedure
		System.out.println("Amount of bought Haushaltswaren (x100) (Stored) (Using Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			count = service.countBoughtHaushaltswarenStored();
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n");

		service.resetCache(true);

		// Zählt die Durchschnittszeit der Abfrage "Anzahl gekaufter Haushaltswaren" unter keiner Verwendung von Stored Procedure und keiner Verwendung vom Index
		System.out.println("Amount of bought Haushaltswaren (x100) (Stored) (Using No Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			count = service.countBoughtHaushaltswarenStoredNoIndex();
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n \n");

		service.resetCache(true);

		// Zählt die Durchschnittszeit der Abfrage "Conversion-Rate" unter Verwendung vom Index
		float ratio = 0;
		System.out.println("Ratio of Watched/Bought (x100) (Using Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			ratio = service.getRatioOfWatchedBought("marko@dhbw-stuttgart.de");
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.printf("%.3f\n", ratio);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n");

		service.resetCache(true);

		// Zählt die Durchschnittszeit der Abfrage "Conversion-Rate" unter keiner Verwendung vom Index
		System.out.println("Ratio of Watched/Bought (x100) (Using No Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			ratio = service.getRatioOfWatchedBought("marko@dhbw-stuttgart.de");
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.printf("%.3f\n", ratio);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n");

		service.resetCache(true);

		// Zählt die Durchschnittszeit der Abfrage "Conversion-Rate" unter Verwendung vom Index und Stored Procedure
		System.out.println("Ratio of Watched/Bought (x100) (Stored) (Using Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			ratio = service.getRatioOfWatchedBoughtStored("marko@dhbw-stuttgart.de");
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.printf("%.3f\n", ratio);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.\n");

		service.resetCache(true);

		// Zählt die Durchschnittszeit der Abfrage "Conversion-Rate" unter keiner Verwendung vom Index aber unter Verwendung von Stored Procedure
		System.out.println("Ratio of Watched/Bought (x100) (Stored) (Using No Index):");
		timeStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			ratio = service.getRatioOfWatchedBoughtStoredNoIndex("marko@dhbw-stuttgart.de");
			service.resetCache(true);
		}
		timeEnd = System.currentTimeMillis();
		System.out.printf("%.3f\n", ratio);
		System.out.println("Performance / Query: " + (timeEnd - timeStart) / 100 + " Millisek.");

		service.close();
	}

}
