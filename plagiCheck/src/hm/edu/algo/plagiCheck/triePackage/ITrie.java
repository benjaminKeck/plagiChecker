package hm.edu.algo.plagiCheck.triePackage;

import hm.edu.algo.plagiCheck.kAux.IActionAtInsert;

public interface ITrie<K extends Comparable> {
	public Object put(K key, Object value);
	public Object put(String key, IActionAtInsert action);
	public Object get(K key);
	public boolean hasKey(K key);
	
	public String toString();
}
