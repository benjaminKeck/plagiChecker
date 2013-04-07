package hm.edu.algo.plagiCheck.triePackage;

import hm.edu.algo.plagiCheck.kAux.CharIterator;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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
		if(it.hasNext()){
			//hat Knoten schon einen Value mit diesem value...if(partOfKeyToTrieNode.co)
			Character buchstabe = (Character)it.next();
			//System.out.println("Char: "+buchstabe);
			
			String rest="";
			while(it.hasNext()){
				rest = rest+it.next();
			}
			//System.out.println("rest: "+rest);
			
			if(!partOfKeyToTrieNode.containsKey(buchstabe)){
				System.out.println("legt "+buchstabe+" an");
				partOfKeyToTrieNode.put(buchstabe, new TrieNode(this, value));
				
				//return new TrieReference(value, 1, false);
			}
			
			return partOfKeyToTrieNode.get(buchstabe).recursiveInsert(new CharIterator(rest), value);
			/*else{
				System.out.println(buchstabe+ " ist vorhanden");
				partOfKeyToTrieNode.get(buchstabe).recursiveInsert(new CharIterator(rest), value);
				return new TrieReference(value, 1, true);
			}*/
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
