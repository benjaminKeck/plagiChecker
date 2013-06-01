package hm.edu.algo.plagiCheck.lexer;

import java.io.FileReader;
import java.util.ArrayList;

import hm.edu.algo.plagiCheck.kAux.IIndexReference;
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


	@Override
	public void setFile(FileReader fr) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<IIndexReference> read() {
		// TODO Auto-generated method stub
		return null;
	}
}
