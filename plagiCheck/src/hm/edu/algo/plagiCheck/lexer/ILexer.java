package hm.edu.algo.plagiCheck.lexer;

public interface ILexer {
	public enum LexerState{
		READY, ID, WHITESPACE, INT, COLON, COMMA, SPECIAL_CHARACTER, ERROR;
	}
	
	public IToken getToken();
	
	public void start();
}
