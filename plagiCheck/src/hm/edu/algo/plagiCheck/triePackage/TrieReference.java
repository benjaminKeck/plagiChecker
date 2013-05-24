package hm.edu.algo.plagiCheck.triePackage;

public class TrieReference implements ITrieReference{

	// Attribute
	private final Object value;
	
	private int depth;
	
	private final boolean found;
	
	@Override
	public boolean getFound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	TrieReference (Object value, int depth, boolean found){
		this.value = value;
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
