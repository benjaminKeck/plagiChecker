package hm.edu.keckes.algo.plagiCheck.main;

import hm.edu.keckes.algo.plagiCheck.logging.Log;

public class PlagiChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int traceLevel = Log.URGENT;
		
		if(args.length!=2){
			System.out.println("Sie müssen zwei Dateien zum Vergleich angeben, das Programm wurde beendet");
		}
		else{
			Log.println(traceLevel, "erste Datei: "+args[0]);
			Log.println(traceLevel, "zweite Datei: "+args[1]);
		}
	}

}
