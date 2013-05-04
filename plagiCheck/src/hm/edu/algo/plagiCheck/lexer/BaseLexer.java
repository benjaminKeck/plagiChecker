package hm.edu.algo.plagiCheck.lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import hm.edu.algo.plagiCheck.logging.Log;
import hm.edu.algo.plagiCheck.triePackage.ITrie;
import hm.edu.algo.plagiCheck.triePackage.Trie;

/**
 * @author Benjamin Keckes
 * 
 */
public class BaseLexer implements ILexer{
	ITrie idTrie;
	ITrie intTrie;
	ITrie wsTrie;
	BufferedReader bfr;
	
	public BaseLexer(FileReader fr){
		this.idTrie = new Trie<String>();
		this.intTrie = new Trie<Integer>();
		this.wsTrie = new Trie<String>();
		this.bfr = new BufferedReader(fr);
	}
	
	/**
	 * @author Benjamin Keckes
	 * 
	 */
	public void start(){
		int chInt=0;
		char ch;
		LexerState state = LexerState.READY;
		LexerState oldState = LexerState.READY;
		String line="";
		
		
		try {
			
			while( (chInt = bfr.read()) != -1){
				
				ch = (char)chInt;

				state = getState(ch);
				
				switch (state){
				
				case ID:
					line = check(state, oldState, line) + ch;
					oldState = state;
					break;
				case COMMA:
					line = check(state, oldState, line) + ch;
					oldState = state;
					break;
				case WHITESPACE:
					line = check(state, oldState, line) + ch;
					oldState = state;
					break;
				}
			}
			
			
		} catch (IOException e) {
			Log.println(Log.URGENT, "Ein Fehler beim lesen des Files ist aufgetreten");
			e.printStackTrace();
		}
	}
	private LexerState getState(char ch){
		if(ch==' '){
			return LexerState.WHITESPACE;
		}
		else if(ch == ','){
			return LexerState.COMMA;
		}
		else{
			return LexerState.ID;
		}
	}
	private String check(LexerState newState, LexerState oldState, String line){
		if(oldState==LexerState.READY)
			return line;
		if(newState!=oldState){
			System.out.println(oldState+"\t"+line);
			return "";
		}
		return line;
	}

}
