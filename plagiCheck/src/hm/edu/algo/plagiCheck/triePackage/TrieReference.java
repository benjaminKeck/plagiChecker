package hm.edu.algo.plagiCheck.triePackage;

public class TrieReference implements ITrieReference{

	// Attribute
	private final Object stringCoding;
	private final Object stringCounting;
	
	private int depth;
	
	private final boolean found;
	
	@Override
	public boolean getFound() {
		return found;
	}

	@Override
	public Object getCode() {
		return this.stringCoding;
	}
	
	@Override
	public Object getPosition() {
		return this.stringCounting;
	}

	TrieReference (Object coding, Object counting, int depth, boolean found){
		this.stringCoding = coding;
		this.stringCounting=counting;
		this.depth = depth;
		this.found = found;
	}

	@Override
	public void incrementDepth() {
		this.depth++;
	}

	@Override
	public int getDepth() {
		return this.depth;
	}
}
