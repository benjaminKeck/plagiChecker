package hm.edu.algo.plagiCheck.lexer;

public class Token implements IToken{
	
	private int relativeCode;
	
	private TokenClass classCode;
	
	// Getter für den Relativcode des Token
	public int getRelativeCode(){
		return relativeCode;
	}
	
	// Getter für den Classcode des Token
	public TokenClass getClassCode(){
		return classCode;
	}	
}
