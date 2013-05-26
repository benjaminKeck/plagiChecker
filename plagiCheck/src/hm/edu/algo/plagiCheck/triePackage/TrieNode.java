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
	private Object counting;
	private Object code;
	private ITrieNode parent;
	private ITrieNode partOfKey;
	
	/**
	 * 
	 * @param parent
	 * @param value
	 * Parameter fuer Kante
	 */
	public TrieNode(ITrieNode parent, Object value){
		this.parent = parent;
		this.partOfKeyToTrieNode = new TreeMap<Comparable, ITrieNode>();
		this.code=value;
		this.counting = new Integer(0);
	}

	/**
	 * @author Benjamin Keckes
	 * @param it Iterator
	 * @param action Die Action fuer das (nicht) Finden des Values
	 * Fuegt den Inhalt des Iterators in die verkettete Liste ein.
	 */
	@Override
	public ITrieReference recursiveInsert(Iterator it, IActionAtInsert codingAction, IActionAtInsert countingAction) {

		if(it.hasNext()){
			
			Comparable key = (Comparable)it.next();
			
			if(!partOfKeyToTrieNode.containsKey(key)){
				partOfKeyToTrieNode.put(key, new TrieNode(this, null));
				//System.out.println("Lege "+(Character)key+" mit Value "+null);
			}
			//ITrieReference ref = partOfKeyToTrieNode.get(key).recursiveInsert(it, codingAction, countingAction);
			//ref.incrementDepth();
			//return ref;
			return partOfKeyToTrieNode.get(key).recursiveInsert(it, codingAction, countingAction);
		}
		//Wenn das Wort schon gespeichert war
		if(this.code!=null){
			code=codingAction.actionInCaseOfFoundKey(code);
			counting = countingAction.actionInCaseOfFoundKey(counting);
			return new TrieReference(code, counting, 1, true);
		}
		else{
			code=codingAction.actionInCaseOfNotFoundKey();
			counting = countingAction.actionInCaseOfNotFoundKey();
			return new TrieReference(code, counting,  1, false);
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
		return code;
	}

}
