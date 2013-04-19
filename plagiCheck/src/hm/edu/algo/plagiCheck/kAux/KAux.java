package hm.edu.algo.plagiCheck.kAux;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * Hier sollen Hilfsfunktionen rein
 * @author keckes
 *
 */
public class KAux {

	/**
	 * Gibt den Inhalt einer übergebenen Datei aus.
	 */
	public static void inhaltVonDateiAuslesen(String pfad){
		try{
			BufferedReader auslesen = new BufferedReader(new FileReader(pfad));
			
			String zeile = "";
			try{
				while((zeile = auslesen.readLine()) != null){
					System.out.println(zeile);
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
