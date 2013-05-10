package hm.edu.algo.plagiCheck.lexer;

import hm.edu.algo.plagiCheck.triePackage.ITrie;

public interface ILexer {
	public enum LexerState{
		READY, ID, WHITESPACE, INT, COMMA;
	}
	
	public void start();
	
	public ITrie getIdTrie();
	public ITrie getWsTrie();
	public ITrie getIntTrie();
}
