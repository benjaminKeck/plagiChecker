package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.lexer.ILexer.LexerState;

import java.util.Set;

public interface IDFA {

	public int getInitial();
	
	public void trans(int state, LexerState symbol);
	
	public boolean isFinal(int state);
	
	public Set<TokenClass> getTokenClasses(int s);
}
