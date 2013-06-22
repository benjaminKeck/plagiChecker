package hm.edu.algo.plagiCheck.kAux;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

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
	

	@Override
	public boolean equals(Object obj) {
		IndexReference ref;
		if (obj instanceof IndexReference){
			ref = (IndexReference) obj;
		} else {
			return false;
		}
	
		if(!this.classCode.equals(ref.getClassCode())){
			return false;
		}
		if(this.stringCode != ref.getStringCode()){
			return false;
		}
	
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + stringCode;
		result = 31 * result + classCode.hashCode();
		return result;
	}
}
