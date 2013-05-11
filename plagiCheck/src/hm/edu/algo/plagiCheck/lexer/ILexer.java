package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.triePackage.ITrie;

public interface ILexer {
	public enum LexerState{
		READY, ID, WHITESPACE, INT, FLOAT, DATE, COMMA, EOF, UNKNOWN, SPECIALCHAR;
	}
	public class UnknownLexerState extends Exception{
		public UnknownLexerState() {
			super();
		}
	}
	
	public LexerState getState();
	public IToken getToken();
}
