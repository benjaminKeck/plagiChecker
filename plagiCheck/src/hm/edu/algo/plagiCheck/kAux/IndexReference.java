package hm.edu.algo.plagiCheck.kAux;

import hm.edu.algo.plagiCheck.lexer.ILexer.LexerState;

public class IndexReference implements IIndexReference{

	private LexerState classCode;
	private int stringCode;
	
	
	public IndexReference(LexerState classCode, int stringCode){
		this.classCode=classCode;
		this.stringCode = stringCode;
	}
	@Override
	public LexerState getClassCode() {
		return classCode;
	}

	@Override
	public int getStringCode() {
		return stringCode;
	}

}
