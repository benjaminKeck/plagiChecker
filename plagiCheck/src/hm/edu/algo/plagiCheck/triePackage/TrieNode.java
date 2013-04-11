package hm.edu.algo.plagiCheck.triePackage;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Diese Klasse stellt einen einzelnen Knoten in dem Triesuchbaum dar.
 * @author keckes,klaes
 *
 */
public class TrieNode implements ITrieNode{
	private Map<Comparable, ITrieNode> partOfKeyToTrieNode;
	private Object value;
	private ITrieNode parent;
	private ITrieNode partOfKey;//Kante zu this
	
	/**
	 * 
	 * @param parent
	 * @param value
	 * Parameter für Kante
	 */
	public TrieNode(ITrieNode parent, Object value){
		this.parent = parent;
		this.partOfKeyToTrieNode = new TreeMap<Comparable, ITrieNode>();
		this.value=value;
		/**Kante zu this müssen das noch iwie implementieren*/
		//this.partOfKey=partOfKey;
	}

	@Override
	public ITrieReference recursiveInsert(Iterator it, Object value) {
		
		//Hat Iterator noch Nachfolger?
		if(it.hasNext()){
			//System.out.println("Buchstabe ");
			//Aktuellen Wert aus Iterator holen
			Comparable key = (Comparable)it.next();
			
			//Gibt es den Key in dieser TrieNode noch nicht?
			if(!partOfKeyToTrieNode.containsKey(key)){
				//Key anlegen
				//System.out.println("legt "+(Character)key+" an");
				System.out.print((Character)key);
				partOfKeyToTrieNode.put(key, new TrieNode(this, value));			
			}
			else{
				//System.out.println("Buchstabe "+(Character)key+" schon vorhanden");
				System.out.print((Character)key);
			}
			return partOfKeyToTrieNode.get(key).recursiveInsert(it, value);	
		}
		System.out.println();
		
		return new TrieReference(this,partOfKeyToTrieNode.size(),true);
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
