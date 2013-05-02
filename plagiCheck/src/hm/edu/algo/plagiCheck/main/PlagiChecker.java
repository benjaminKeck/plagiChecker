package hm.edu.algo.plagiCheck.main;

import hm.edu.algo.plagiCheck.kAux.IActionAtInsert;
import hm.edu.algo.plagiCheck.kAux.ITokenizer;
import hm.edu.algo.plagiCheck.kAux.KAux;
import hm.edu.algo.plagiCheck.kAux.StringCoding;
import hm.edu.algo.plagiCheck.kAux.Tokenizer;
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
			ITrie trie = new Trie<String>();
			ITokenizer tokenizer = new Tokenizer(args[0], trie, new StringCoding());
			tokenizer.start();
			System.out.println(trie.toString());
			
		}
		/*
		ITrie trie = new Trie<String>();
		IActionAtInsert action = new StringCoding();
		trie.put("wolf", action);
		trie.put("wolfsjunge", action);
		trie.put("wolfsmann", action);
		trie.put("wolf", action);
		trie.put("warze", action);
		trie.toString();
		*/
		//KAux.inhaltVonDateiAuslesen("c:\\users\\keckes\\test.txt");
	}
}
