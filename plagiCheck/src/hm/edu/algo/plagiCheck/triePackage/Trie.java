package hm.edu.algo.plagiCheck.triePackage;

import java.util.Iterator;

/**
 * 
 * @author Keckes
 * 
 * @param <K>
 */
public class Trie<K extends Comparable<K>> implements ITrie<K>{
	private ITrieNode root;
	
	public Trie(){
		this.root = new TrieNode(null, null);
	}
	// servas
	
	@Override
	public Object put(K key, Object v) {
		Object oldVal = get(key);
		
		/*
		 * Key ist ein Iterator 
		 */
		if(key instanceof Iterator){
			
		}
		return oldVal;
	}

	@Override
	public Object get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

}
