package hm.edu.algo.plagiCheck.triePackage;

import java.util.Iterator;

import hm.edu.algo.plagiCheck.kAux.IActionAtInsert;

public interface ITrie<K extends Comparable> {
	public Object put(K key, Object value);
	public Object put(String key, IActionAtInsert action);
	public Object get(int code);
	public boolean hasKey(K key);
	
	public Object insert(Iterator i/*, IActionAtInsert action*/);
	public String toString();
}
