package hm.edu.algo.plagiCheck.triePackage;

import hm.edu.algo.plagiCheck.kAux.CharIterator;
import hm.edu.algo.plagiCheck.kAux.IActionAtInsert;
import hm.edu.algo.plagiCheck.kAux.StringCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author Keckes,klaes
 * 
 * @param <K>
 */
public class Trie<K extends Comparable<K>> implements ITrie<K>{
	private ITrieNode root;
	private IActionAtInsert codingAction;
	private IActionAtInsert countingAction;
	private HashMap<Integer, ITrieNode> leaves = new HashMap<Integer, ITrieNode>();
	
	public Trie(IActionAtInsert codingAction, IActionAtInsert countingAction){
		
		this.codingAction = codingAction;
		this.countingAction = countingAction;
		
		this.root = new TrieNode(null, null);
	}
	
	@Override
	public Object put(K key, Object value) {
		//Object oldVal = get(key);
		
		/*
		 * Key ist ein Iterator 
		 */
		if(key instanceof Iterator){
			
		}
		return null;
	}

	@Override
	public Object put(String key, IActionAtInsert action) {
		Iterator it = new CharIterator(key);
		
		return null;
	}
	
	@Override
	public Object get(int code) {
		return leaves.get(code).getStringReference("");
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

	@Override
	public Object insert(Iterator i/*, IActionAtInsert action*/) {
		ITrieReference ref = root.recursiveInsert(i, codingAction, countingAction);
		
		//Alle Blätter sammeln
		leaves.put((Integer)ref.getStringCode(), ref.getNode());
		return ref;
	}

}
