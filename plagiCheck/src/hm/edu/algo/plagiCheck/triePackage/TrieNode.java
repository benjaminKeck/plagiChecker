package hm.edu.algo.plagiCheck.triePackage;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TrieNode implements ITrieNode{
	private Map<Comparable, ITrieNode> partOfKeyToTrieNode;
	private Object value;
	private ITrieNode parent;
	
	public TrieNode(ITrieNode parent, Object value){
		this.parent = parent;
		this.partOfKeyToTrieNode = new TreeMap<Comparable, ITrieNode>();
	}

	@Override
	public ITrieReference recursiveInsert(Iterator it, Object value) {
		if(it.hasNext()){
			//hat Knoten schon einen Value mit diesem value...if(partOfKeyToTrieNode.co)
			//if(!partOfKeyToTrieNode.containsKey(key))
			new TrieNode(this, value);
		}
		return null;
	}

}
