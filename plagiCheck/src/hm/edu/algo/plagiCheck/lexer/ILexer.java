package hm.edu.algo.plagiCheck.lexer;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import hm.edu.algo.plagiCheck.kAux.IIndexReference;
import hm.edu.algo.plagiCheck.triePackage.ITrie;

public interface ILexer {
	public enum LexerState{


		READY, ID, WHITESPACE, INT, FLOAT, FLOAT_TO_DATE, DATE, COMMA, COLON, SPECIALCHAR;

		//READY, ID, WHITESPACE, INT, COLON, COMMA, SPECIAL_CHARACTER, ERROR;

	}
	public void setFile(FileReader fr);
	public ArrayList<IIndexReference> read();
	public boolean isEOF();

	public IToken getToken();
	
	public String decode(IIndexReference ref);
	
	public String showTrie(LexerState state);
	/**
	 * Exception f�r einen nicht gefundenen LexerState.
	 * Also falls ein Zeichen keinem State zugewiesen kann.
	 * @author keckes
	 *
	 */
	public class UnknownLexerState extends Exception{
		public UnknownLexerState() {
			super();
		}
		public UnknownLexerState(String text){
			super(text);
		}
	}
}