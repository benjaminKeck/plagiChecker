package hm.edu.algo.plagiCheck.triePackage;

public interface ITrie<K extends Comparable> {
	public Object put(K key, Object value);
	public Object put(String key, Object value);
	public Object get(K key);
	public boolean hasKey(K key);
	
	public String toString();
}
