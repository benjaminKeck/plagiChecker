package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.triePackage.ITrie;

public interface ILexer {
	public enum LexerState{


		READY, ID, WHITESPACE, INT, FLOAT, FLOAT_TO_DATE, DATE, COMMA, COLON, SPECIALCHAR;

		//READY, ID, WHITESPACE, INT, COLON, COMMA, SPECIAL_CHARACTER, ERROR;

	}

	public boolean isEOF();

	public IToken getToken();
	
	String decode(IToken tk);
	
	/**
	 * Exception f�r einen nicht gefundenen LexerState.
	 * Also falls ein Zeichen keinem State zugewiesen kann.
	 * @author keckes
	 *
	 */
	public class UnknownLexerState extends Exception{
		public UnknownLexerState() {
			super();
		}
		public UnknownLexerState(String text){
			super(text);
		}
	}



}
