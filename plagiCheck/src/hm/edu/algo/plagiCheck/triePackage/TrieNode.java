package hm.edu.algo.plagiCheck.triePackage;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Diese Klasse stellt einen einzelnen Knoten in dem Triesuchbaum dar.
 * @author keckes
 *
 */
public class TrieNode implements ITrieNode{
	private Map<Comparable, ITrieNode> partOfKeyToTrieNode;
	private Object value;
	private ITrieNode parent;
	
	public TrieNode(ITrieNode parent, Object value){
		this.parent = parent;
		this.partOfKeyToTrieNode = new TreeMap<Comparable, ITrieNode>();
		this.value=value;
	}

	@Override
	public ITrieReference recursiveInsert(Iterator it, Object value) {
		
		//Hat Iterator noch Nachfolger?
		if(it.hasNext()){
			
			//Aktuellen Wert aus Iterator holen
			Comparable key = (Comparable)it.next();
			
			//Gibt es den Key in dieser TrieNode noch nicht?
			if(!partOfKeyToTrieNode.containsKey(key)){
				
				//Key anlegen
				System.out.println("legt "+(Character)key+" an");
				partOfKeyToTrieNode.put(key, new TrieNode(this, value));
			}
			else{
				System.out.println("Buchstabe "+(Character)key+" schon vorhanden");
			}
			
			return partOfKeyToTrieNode.get(key).recursiveInsert(it, value);
		}
		return new TrieReference(null, 1, false);
	}
	
	public void showValues(){
		System.out.print("Value: "+(Integer)value+" Buchstaben: ");
		
		Iterator key = partOfKeyToTrieNode.keySet().iterator();
		while(key.hasNext()){
			Character buchstabe = (Character)key.next();
			System.out.print(buchstabe+", ");
		}
		System.out.println("");
		
		Iterator it= partOfKeyToTrieNode.values().iterator();
		while(it.hasNext()){
			ITrieNode temp = (TrieNode)it.next();
			
			temp.showValues();
			
		}
	}

}
