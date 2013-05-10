package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.triePackage.ITrie;

public class FilterLexer implements ILexer {

	private ILexer base;
	
	public FilterLexer(ILexer base){
		this.base = base;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ITrie getIdTrie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITrie getWsTrie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITrie getIntTrie() {
		// TODO Auto-generated method stub
		return null;
	}
}
