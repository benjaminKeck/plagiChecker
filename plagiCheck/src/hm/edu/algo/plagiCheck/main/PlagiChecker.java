package hm.edu.algo.plagiCheck.main;

import java.io.FileNotFoundException;
import java.io.FileReader;

import hm.edu.algo.plagiCheck.kAux.*;
import hm.edu.algo.plagiCheck.kAux.StringCoding;
import hm.edu.algo.plagiCheck.lexer.*;
import hm.edu.algo.plagiCheck.logging.Log;
import hm.edu.algo.plagiCheck.triePackage.*;


public class PlagiChecker {

	/**
	 * @author Benjamin Keckes
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args){
		
		final int traceLevel = Log.URGENT;
		
		//Wenn nicht zwei Textfiles als Parameter angegeben werden.
		if(args.length!=2){
			System.out.println("Sie muessen zwei Dateien zum Vergleich angeben\nDas Programm wird beendet!");
			return;
		}
		
		ILexer baseLexer;
		try{
			baseLexer = new BaseLexer(new FileReader(args[0]));
			Log.println(Log.NORMAL, "File "+args[0]+" erfolgreich eingelesen");
		}catch(FileNotFoundException e){
			Log.println(Log.URGENT, "Datei "+args[0]+" konnte nicht gefunden werden");
			e.printStackTrace();
			return;
		}
		
		baseLexer.start();
		System.out.println(baseLexer.getIdTrie().toString());
		System.out.println(baseLexer.getWsTrie().toString());
		/*
		ITrie trie = new Trie<String>();
		ITokenizer tokenizer = new Tokenizer(args[0], trie, new StringCoding());
		tokenizer.start();
		System.out.println(trie.toString());
			
		
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
