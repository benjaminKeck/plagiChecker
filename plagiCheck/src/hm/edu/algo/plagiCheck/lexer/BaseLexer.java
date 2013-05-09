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
		String digit = "";
		boolean enoughDays;
		boolean enoughMonth;
		
		try {
			
			while( (chInt = bfr.read()) != -1){
				
				ch = (char)chInt;

				state = getState(ch);
				
				switch (state){
				
				case ID:
					line = check(state, oldState, line) + ch;
					oldState = state;
					break;
				case INT:
					line = check(state, oldState, line) + ch;
					digit = checkInt(state, oldState, digit) + ch;
					enoughDays = enoughIntForPossibleDate(digit);	
					oldState = state;
					break;
				case COMMA:
					line = check(state, oldState, line) + ch;
					oldState = state;
					break;
				case COLON:
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
		else if(ch == '.'){
			return LexerState.COLON;
		}
		else if(Character.isDigit(ch)){
			return LexerState.INT;
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

	private String checkInt(LexerState newState, LexerState oldState, String digit){
		if(oldState == LexerState.INT){
			return digit;
		}
		return "";
	}
	
	private boolean enoughIntForPossibleDate(String digit){
		if(digit.length() == 2){
			return true;
		}
		return false;
	}
	
	@Override
	public IToken getToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
