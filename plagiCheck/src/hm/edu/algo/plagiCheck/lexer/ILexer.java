package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.triePackage.ITrie;

public interface ILexer {
	public enum LexerState{

		READY, ID, WHITESPACE, INT, FLOAT, DATE, COMMA, EOF, UNKNOWN, SPECIALCHAR;

		//READY, ID, WHITESPACE, INT, COLON, COMMA, SPECIAL_CHARACTER, ERROR;

	}
	public class UnknownLexerState extends Exception{
		public UnknownLexerState() {
			super();
		}
	}
	public boolean isEOF();
	
	public IToken getToken();
	

}
