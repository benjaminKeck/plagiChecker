package hm.edu.algo.plagiCheck.triePackage;

import hm.edu.algo.plagiCheck.kAux.IActionAtInsert;

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
	public ITrieReference recursiveInsert(Iterator it, IActionAtInsert action) {

		if(it.hasNext()){
			
			Comparable key = (Comparable)it.next();
			
			if(!partOfKeyToTrieNode.containsKey(key)){
				partOfKeyToTrieNode.put(key, new TrieNode(this, null));
				//System.out.println("Lege "+(Character)key+" mit Value "+null);
			}
			return partOfKeyToTrieNode.get(key).recursiveInsert(it, action);
		}
		//Wenn der Value gefunden wurde
		if(this.value!=null){
			this.value=action.actionInCaseOfFoundKey(this.value);
			return new TrieReference(value, 1, true);
		}
		else{
			this.value=action.actionInCaseOfNotFoundKey();
			return new TrieReference(value, 1, false);
		}
		
	}
	
	public void showValues(int depth){
		Iterator kante = partOfKeyToTrieNode.keySet().iterator();
		
		while(kante.hasNext()){
			Object nextKante = kante.next();
			Character kName = (Character)nextKante;
			//System.out.print("("+(Integer)value+")");
			System.out.print(einruecken(depth) + kName);
			if(partOfKeyToTrieNode.get(kName).getValue()!=null)
				System.out.println(" -> "+(Integer)partOfKeyToTrieNode.get(kName).getValue());
			else
				System.out.println("");
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
	public Object getValue(){
		return value;
	}

}
