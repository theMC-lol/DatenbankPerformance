package mentoring;

import java.sql.SQLException;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		//Timestart um die Zeit in Millisekunden zu speichern
		final long timeStart = System.currentTimeMillis();
		
		//Ruft ein Objekt aus Klasse Databaseservice auf, um Funktionen durchzuführen
		DatabaseService service = new DatabaseService();

		System.out.println("berto@comp.de name:");
		System.out.println(service.queryBertoBartName());

		
		
		
		//Timend um die Zeit nochmal zu stoppen.
		final long timeEnd = System.currentTimeMillis();
		
		//Ausgabe des delta in Millisekunden
		System.out.println("Performance: " + (timeEnd - timeStart) + " Millisek.");
	}
	
	
	
}
