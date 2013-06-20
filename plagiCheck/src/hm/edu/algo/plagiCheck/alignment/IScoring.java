package hm.edu.algo.plagiCheck.alignment;

import hm.edu.algo.plagiCheck.lexer.IToken;

public interface IScoring {

	double getScore(IToken token1, IToken token2);
	
	double getGapScore();
}
