package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.lexer.ILexer.LexerState;

import java.util.Set;

public class DFA implements IDFA{

	@Override
	public int getInitial() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void trans(int state, LexerState symbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFinal(int state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<TokenClass> getTokenClasses(int s) {
		// TODO Auto-generated method stub
		return null;
	}

}
