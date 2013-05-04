package hm.edu.algo.plagiCheck.triePackage;

import hm.edu.algo.plagiCheck.kAux.IActionAtInsert;
import hm.edu.algo.plagiCheck.kAux.StringCounting;

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
	 * Parameter fuerr Kante
	 */
	public TrieNode(ITrieNode parent, Object value){
		this.parent = parent;
		this.partOfKeyToTrieNode = new TreeMap<Comparable, ITrieNode>();
		this.value=value;
		/**Kante zu this müssen das noch iwie implementieren*/
		//this.partOfKey=partOfKey;
	}

	/**
	 * @author Benjamin Keckes
	 * @param it Iterator
	 * @param action Die Action fuer das (nicht) Finden des Values
	 * Fuegt den Inhalt des Iterators in die verkettete Liste ein.
	 */
	@Override
	public ITrieReference recursiveInsert(Iterator it, IActionAtInsert codingAction/*, IActionAtInsert countingAction*/) {

		if(it.hasNext()){
			
			Comparable key = (Comparable)it.next();
			
			if(!partOfKeyToTrieNode.containsKey(key)){
				partOfKeyToTrieNode.put(key, new TrieNode(this, null));
				//System.out.println("Lege "+(Character)key+" mit Value "+null);
			}
			return partOfKeyToTrieNode.get(key).recursiveInsert(it, codingAction);
		}
		//Wenn der Value gefunden wurde
		if(this.value!=null){
			this.value=codingAction.actionInCaseOfFoundKey(this.value);
			return new TrieReference(value, 1, true);
		}
		else{
			this.value=codingAction.actionInCaseOfNotFoundKey();
			
			return new TrieReference(value, 1, false);
		}
		
	}
	
	/**
	 * @author Benjamin Keckes
	 * @param depth Tiefe der Einrueckung
	 * Zeigt rekursiev alle Werte der Kanten und Knoten.
	 */
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
	
	/**
	 * @author Benjamin Keckes
	 * @param depth
	 * @return Leerzeichenstring.
	 */
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
