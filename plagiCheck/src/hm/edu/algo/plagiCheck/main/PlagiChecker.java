package hm.edu.algo.plagiCheck.main;

import hm.edu.algo.plagiCheck.logging.Log;
import hm.edu.algo.plagiCheck.triePackage.Trie;

public class PlagiChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int traceLevel = Log.URGENT;
		
		if(args.length!=2){
			System.out.println("Sie müssen zwei Dateien zum Vergleich angeben\n das Programm wurde beendet!");
		}
		else{
			Log.println(traceLevel, "erste Datei: "+args[0]);
			Log.println(traceLevel, "zweite Datei: "+args[1]);
		}
		
		Trie trie = new Trie<Integer>();
		trie.put(1, "asd");
	}

}
