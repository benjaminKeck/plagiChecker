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

		if(it.hasNext()){
			
			Comparable key = (Comparable)it.next();
			
			if(!partOfKeyToTrieNode.containsKey(key)){
				partOfKeyToTrieNode.put(key, new TrieNode(this, null));
				//System.out.println("Lege "+(Character)key+" mit Value "+null);
			}
			return partOfKeyToTrieNode.get(key).recursiveInsert(it, value);
		}
		if(this.value!=null){
			this.value=value;
			return new TrieReference(value, 1, true);
		}
		else{
			this.value=value;
			return new TrieReference(value, 1, false);
		}
		
	}
	
	public void showValues(int depth){

		
		Iterator kante = partOfKeyToTrieNode.keySet().iterator();
		
		while(kante.hasNext()){
			Character kName = (Character)kante.next();
			System.out.print("("+(Integer)value+")");
			System.out.println(einruecken(depth) + kName);
			partOfKeyToTrieNode.get(kName).showValues(++depth);
			depth--;
		}
	}
	private String einruecken(int depth){
		String sum="";
		for(int i=0; i<depth; i++)
			sum+="  ";
		return sum;
	}

}
