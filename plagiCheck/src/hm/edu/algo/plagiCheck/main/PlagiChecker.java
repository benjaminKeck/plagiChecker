package hm.edu.algo.plagiCheck.main;

import hm.edu.algo.plagiCheck.logging.Log;
import hm.edu.algo.plagiCheck.triePackage.*;


public class PlagiChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int traceLevel = Log.URGENT;
		/*
		if(args.length!=2){
			System.out.println("Sie m�ssen zwei Dateien zum Vergleich angeben\nDas Programm wird beendet!");
			return;
		}
		else{
			Log.println(traceLevel, "erste Datei: "+args[0]);
			Log.println(traceLevel, "zweite Datei: "+args[1]);
		}
		*/
		
		ITrie trie = new Trie<String>();
		trie.put("Software", new Integer(4711));
		trie.put("Softeis", new Integer(4712));
		trie.put("Sware", new Integer(4713));
	}

}
