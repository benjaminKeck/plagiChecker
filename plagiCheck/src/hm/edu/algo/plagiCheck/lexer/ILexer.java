package hm.edu.algo.plagiCheck.lexer;

public interface ILexer {
	public enum LexerState{
		READY, ID, WHITESPACE, INT, COMMA;
	}
	
	public void start();
}
