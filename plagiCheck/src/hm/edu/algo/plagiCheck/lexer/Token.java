package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.lexer.ILexer.LexerState;

public class Token implements IToken{

	private LexerState type;
	private String value;
	
	public Token(LexerState type, String value){
		this.type=type;
		this.value=value;
	}
	@Override
	public LexerState getType() {
		return type;
	}

	@Override
	public String getValue() {
		return value;
	}

}
