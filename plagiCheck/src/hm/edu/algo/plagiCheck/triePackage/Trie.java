package hm.edu.algo.plagiCheck.triePackage;

import hm.edu.algo.plagiCheck.kAux.CharIterator;

import java.util.Iterator;

/**
 * 
 * @author Keckes,klaes
 * 
 * @param <K>
 */
public class Trie<K extends Comparable<K>> implements ITrie<K>{
	private ITrieNode root;
	
	public Trie(){
		this.root = new TrieNode(null, null);
	}
	
	@Override
	public Object put(K key, Object value) {
		Object oldVal = get(key);
		
		/*
		 * Key ist ein Iterator 
		 */
		if(key instanceof Iterator){
			
		}
		return oldVal;
	}

	@Override
	public Object put(String key, Object value) {
		Iterator it = new CharIterator(key);
		
		root.recursiveInsert(it, value);
		//root.showValues(0);
		return null;
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

	public String toString(){
		root.showValues(0);
		return "";
	}

}
