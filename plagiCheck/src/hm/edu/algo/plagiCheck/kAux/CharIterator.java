package hm.edu.algo.plagiCheck.kAux;

import java.util.Iterator;

/**
 * Wird eigentlich nicht mehr benötigt.
 * @author keckes
 *
 */
public class CharIterator implements Iterator<Character>{

	private final String str;
	private int pos;
	
	public CharIterator(String str){
		this.str = str;
		pos=0;
	}
	@Override
	public boolean hasNext() {
		return pos < str.length();
	}

	@Override
	public Character next() {
		return str.charAt(pos++);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
