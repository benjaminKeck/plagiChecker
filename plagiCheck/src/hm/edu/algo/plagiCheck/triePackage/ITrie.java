package hm.edu.algo.plagiCheck.triePackage;

public interface ITrie<K extends Comparable> {
	public Object put(K key, Object v);
	public Object get(K key);
	public boolean hasKey(K key);
	//
}
