package hm.edu.algo.plagiCheck.lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import hm.edu.algo.plagiCheck.kAux.IActionAtInsert;
import hm.edu.algo.plagiCheck.kAux.StringCoding;
import hm.edu.algo.plagiCheck.lexer.IToken.TokenType;
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
	
	LexerState state;
	int overlap=0;
	
	public BaseLexer(FileReader fr){
//		this.idTrie = new Trie<String>();
//		this.intTrie = new Trie<Integer>();
//		this.wsTrie = new Trie<String>();
		this.bfr = new BufferedReader(fr);
//		this.idAction = new StringCoding();
//		this.intAction = new StringCoding();
//		this.wsAction = new StringCoding();
	}
	
//	/**
//	 * @author Benjamin Keckes
//	 * 
//	 */
//	public void start(){
//		int chInt=0;
//		char ch;
//		LexerState state = LexerState.READY;
//		LexerState oldState = LexerState.READY;
//		String line="";
//		
//		
//		try {
//			
//			while( (chInt = bfr.read()) != -1){
//				
//				ch = (char)chInt;
//
//				state = getState(ch);
//				
//				switch (state){
//				
//				case ID:
//					line = check(state, oldState, line) + ch;
//					oldState = state;
//					break;
//				case COMMA:
//					line = check(state, oldState, line) + ch;
//					oldState = state;
//					break;
//				case WHITESPACE:
//					line = check(state, oldState, line) + ch;
//					oldState = state;
//					break;
//				}
//			}
//			
//			
//		} catch (IOException e) {
//			Log.println(Log.URGENT, "Ein Fehler beim lesen des Files ist aufgetreten");
//			e.printStackTrace();
//		}
//	}
//	private LexerState getState(char ch){
//		if(ch==' '){
//			return LexerState.WHITESPACE;
//		}
//		else if(ch == ','){
//			return LexerState.COMMA;
//		}
//		else{
//			return LexerState.ID;
//		}
//	}
//	private String check(LexerState newState, LexerState oldState, String line){
//		if(oldState==LexerState.READY)
//			return line;
//		if(newState!=oldState){
//			//System.out.println(oldState+"\t"+line);
//			if(oldState==LexerState.ID)
//				idTrie.put(line, idAction);
//			else if(oldState == LexerState.WHITESPACE)
//				wsTrie.put(line, wsAction);
//			else if(oldState == LexerState.INT)
//				intTrie.put(line, intAction);
//			return "";
//		}
//		return line;
//	}

	
	@Override
	public IToken getToken() {
		int chInt=0;
		LexerState oldState = LexerState.READY;
		String line ="";
		try {
			/*
			 * Überhang vom letzen Methodenaufruf.
			 */
			if(overlap!=0){
				state = readState(overlap);
				oldState = state;
				line = line+(char)overlap;
			}
				
			while((chInt = bfr.read()) != -1){
				
				state = readState(chInt);
				
				if(isStateChange(oldState, state)){
					overlap = chInt;
					return new Token(oldState, line);
				}
				else{
					line = line+(char)chInt;
					oldState = state;
				}
			}
			state = LexerState.EOF;
		} 
		catch (UnknownLexerState e){
			Log.println(Log.URGENT, "Zeichen "+(char)chInt+" konnte nicht zugewiesen werden");
			e.printStackTrace();
		}
		catch (IOException e) {

			e.printStackTrace();
		}
		return new Token(state, "");
	}
	
	private LexerState readState(int val) throws UnknownLexerState{
		if(isLetter(val)){
			return LexerState.ID;
		}
		else if(isComma(val)){
			return LexerState.COMMA;
		}
		else if(isWhiteSpace(val)){
			return LexerState.WHITESPACE;
		}
		else if(isNumber(val)){
			return LexerState.INT;
		}
		else if(isSpecialChar(val)){
			return LexerState.SPECIALCHAR;
		}
		
		throw new UnknownLexerState();
		
	}
	
	private boolean isNumber(int val){
		if(val>=48 && val<=57)
			return true;
		return false;
	}
	
	private boolean isStateChange(LexerState oldState, LexerState newState){
		if(oldState == LexerState.READY)
			return false;
		if(oldState!=newState)
			return true;
		else
			return false;
	}
	private boolean isLetter(int val){
		//Großbuchstaben
		if(val>=65 && val <=90)
			return true;
		//Kleinbuchstaben
		if(val>=97 && val<=122)
			return true;
		return false;
	}
	
	private boolean isComma(int val){
		//Komma oder Punkt
		if(val==44 || val==46)
			return true;
		return false;
	}
	
	private boolean isWhiteSpace(int val){
		char chValue = (char)val;
		//WS, Zeilenumbruch und Tab
		if(chValue==' ' || chValue=='\n' || chValue=='\t' || val==13)
			return true;
		return false;
		
	}
	
	private boolean isSpecialChar(int val){
		if(val>=33 && val<=57)
			return true;
		if(val>=58 && val<=64)
			return true;
		if(val>=91 && val<=96)
			return true;
		if(val>=123 && val<=126)
			return true;
		return false;
	}

	@Override
	public LexerState getState() {
		return state;
	}

}
