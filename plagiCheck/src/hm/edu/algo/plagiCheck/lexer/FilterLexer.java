package hm.edu.algo.plagiCheck.lexer;

public class FilterLexer implements ILexer {

	private ILexer base;
	
	public FilterLexer(ILexer base){
		this.base = base;
	}
}
