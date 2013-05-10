package hm.edu.algo.plagiCheck.lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import hm.edu.algo.plagiCheck.kAux.IActionAtInsert;
import hm.edu.algo.plagiCheck.kAux.StringCoding;
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
	IActionAtInsert idAction;
	IActionAtInsert intAction;
	IActionAtInsert wsAction;
	
	public BaseLexer(FileReader fr){
		this.idTrie = new Trie<String>();
		this.intTrie = new Trie<Integer>();
		this.wsTrie = new Trie<String>();
		this.bfr = new BufferedReader(fr);
		this.idAction = new StringCoding();
		this.intAction = new StringCoding();
		this.wsAction = new StringCoding();
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
			//System.out.println(oldState+"\t"+line);
			if(oldState==LexerState.ID)
				idTrie.put(line, idAction);
			else if(oldState == LexerState.WHITESPACE)
				wsTrie.put(line, wsAction);
			else if(oldState == LexerState.INT)
				intTrie.put(line, intAction);
			return "";
		}
		return line;
	}

	@Override
	public ITrie getIdTrie() {
		return idTrie;
	}

	@Override
	public ITrie getWsTrie() {
		return wsTrie;
	}

	@Override
	public ITrie getIntTrie() {
		return intTrie;
	}

}
