package hm.edu.algo.plagiCheck.lexer;

import java.io.BufferedReader;

import hm.edu.algo.plagiCheck.triePackage.ITrie;

public class BaseLexer implements ILexer{
	ITrie idTrie;
	ITrie intTrie;
	ITrie wsTrie;
	BufferedReader bfr;
}
