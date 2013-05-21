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

	BufferedReader bfr;
	
	LexerState state;
	boolean isEOF;
	int overlap=0;
	
	public BaseLexer(FileReader fr){

		this.bfr = new BufferedReader(fr);
		isEOF=false;
	}

	
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
				
				if(isStateChange(oldState)){
					overlap = chInt;
					return new Token(oldState, line);
				}
				else{
					line = line+(char)chInt;
					oldState = state;
				}
			}
			isEOF=true;
		} 
		catch (UnknownLexerState e){
			Log.println(Log.URGENT, "Zeichen "+(char)chInt+" konnte nicht zugewiesen werden");
			e.printStackTrace();
		}
		catch (IOException e) {

			e.printStackTrace();
		}
		return new Token(state, line);
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
	
	private boolean isStateChange(LexerState oldState){
		if(oldState == LexerState.READY)
			return false;
		if(oldState==LexerState.INT && state==LexerState.COMMA){
			state=LexerState.FLOAT;
			return false;
		}
		else if(oldState==LexerState.FLOAT && state==LexerState.INT){
			state=LexerState.FLOAT;
			return false;
		}
		else if(oldState==LexerState.FLOAT && state==LexerState.COMMA){
			state=LexerState.DATE;
			return false;
		}
		else if(oldState==LexerState.DATE && state==LexerState.INT){
			state=LexerState.DATE;
			return false;
		}
		if(oldState!=state)
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
	public boolean isEOF() {
		return isEOF;
	}


}
