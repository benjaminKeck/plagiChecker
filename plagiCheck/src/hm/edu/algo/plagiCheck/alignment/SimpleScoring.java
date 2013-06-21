package hm.edu.algo.plagiCheck.alignment;

import hm.edu.algo.plagiCheck.lexer.IToken;

public class SimpleScoring implements IScoring {

	@Override
	public double getScore(IToken token1, IToken token2) {
		if(token1.getType() == token2.getType()){
			if(token1.getValue() == token2.getValue()){
				return 1;
			}
			return 0.5;
		}
		return 0;
	}

	@Override
	public double getGapScore() {
		// TODO Auto-generated method stub
		return 0;
	}
}
