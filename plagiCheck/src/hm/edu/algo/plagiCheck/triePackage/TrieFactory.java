package hm.edu.algo.plagiCheck.triePackage;

public class TrieFactory implements ITrieFactory{

	@Override
	public ITrie createTrie() {
		
		return new Trie();
	}

}
