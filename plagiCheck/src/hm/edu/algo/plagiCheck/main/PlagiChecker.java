package hm.edu.algo.plagiCheck.main;

import hm.edu.algo.plagiCheck.kAux.KAux;
import hm.edu.algo.plagiCheck.logging.Log;
import hm.edu.algo.plagiCheck.triePackage.*;


public class PlagiChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int traceLevel = Log.URGENT;
		
		if(args.length!=2){
			System.out.println("Sie muessen zwei Dateien zum Vergleich angeben\nDas Programm wird beendet!");
			return;
		}
		else{
			Log.println(traceLevel, "erste Datei: "+args[0]);
			Log.println(traceLevel, "zweite Datei: "+args[1]);
		}
		
		ITrie trie = new Trie<String>();
		trie.put("wolf", new Integer(4711));
		trie.put("wo", new Integer(4712));
		trie.put("woher", new Integer(4713));
		trie.put("wolfsjunge", new Integer(4714));
		trie.put("wolfsmensch", new Integer(4715));
		trie.put("wolfsmenschen", new Integer(4716));
		trie.toString();
		
		KAux.inhaltVonDateiAuslesen("c:\\users\\keckes\\test.txt");
	}
}
