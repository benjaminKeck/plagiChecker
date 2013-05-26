package hm.edu.algo.plagiCheck.lexer;


import hm.edu.algo.plagiCheck.lexer.ILexer.LexerState;

public interface IToken {

	public LexerState getType();
	public String getValue();
	
}
