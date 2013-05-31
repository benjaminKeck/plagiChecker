package hm.edu.algo.plagiCheck.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import hm.edu.algo.plagiCheck.kAux.*;
import hm.edu.algo.plagiCheck.kAux.StringCoding;
import hm.edu.algo.plagiCheck.lexer.*;
import hm.edu.algo.plagiCheck.lexer.ILexer.LexerState;
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
		ITrie idTrie = new Trie<String>(new StringCoding(), new StringCounting());
		ITrie intTrie = new Trie<Integer>(new StringCoding(), new StringCounting());
		ITrie dateTrie = new Trie<String>(new StringCoding(), new StringCounting());
		HashMap<Integer, Integer> wordMap = new HashMap<Integer, Integer>();
		HashMap<Integer, String> index = new HashMap<Integer, String>();
		
		
		//Wenn nicht zwei Textfiles als Parameter angegeben werden.
		if(args.length!=2){
			System.out.println("Sie muessen zwei Dateien zum Vergleich angeben\nDas Programm wird beendet!");
			return;
		}
		
		ILexer baseLexer;
		try{
			baseLexer = new BaseLexer(new FileReader("/Users/bernhardklauser/Desktop/test.txt"));
			Log.println(Log.NORMAL, "File "+args[0]+" erfolgreich eingelesen");
		}catch(FileNotFoundException e){
			Log.println(Log.URGENT, "Datei "+args[0]+" konnte nicht gefunden werden");
			e.printStackTrace();
			return;
		}
		IToken token;
		do{
			token = baseLexer.getToken();
			System.out.println(token.getType()+"\t"+token.getValue());
			//Hier kann der Token in einen Trie gestopft werden...
			if(token.getType().equals(LexerState.ID)){
				ITrieReference ref = (TrieReference)idTrie.insert(new CharIterator(token.getValue()));
				//System.out.println("'"+ref.getCode()+"' wurde an Stelle "+ref.getPosition()+" eingefuegt");
				wordMap.put((Integer)ref.getPosition(), (Integer)ref.getCode());
				index.put((Integer)ref.getCode(), token.getValue());
			}
		}
		while(!baseLexer.isEOF());
		System.out.println("In File1 sind "+index.size()+" verschiedene Woerter");
		
		//System.out.println(idTrie.toString());
		
//		Iterator it = wordMap.values().iterator();
//		while(it.hasNext()){
//			System.out.println("it: "+index.get((Integer)it.next()));
//		}
		
		
		/*baseLexer.start();
		System.out.println(baseLexer.getIdTrie().toString());
		System.out.println(baseLexer.getWsTrie().toString());
		System.out.println(baseLexer.getIntTrie().toString());
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
