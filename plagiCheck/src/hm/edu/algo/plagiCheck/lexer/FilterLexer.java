package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.triePackage.ITrie;

public class FilterLexer implements ILexer {

	private ILexer base;
	
	public FilterLexer(ILexer base){
		this.base = base;
	}


	@Override
	public boolean isEOF() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IToken getToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decode(IToken tk) {
		// TODO Auto-generated method stub
		return null;
	}
}
