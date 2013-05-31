package hm.edu.algo.plagiCheck.alignment;

import hm.edu.algo.plagiCheck.lexer.IToken;

public interface ITokenStream {

	boolean hasNext();
	
	IToken next();
	
	void add(IToken tk);
	
	IToken getToken(int i);
}
