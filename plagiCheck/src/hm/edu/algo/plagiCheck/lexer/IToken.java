package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.lexer.ILexer.LexerState;

public interface IToken {
	public enum TokenType{
		ID, INT, DATE, COMMA;
	}
	public LexerState getType();
	public String getValue();
}
