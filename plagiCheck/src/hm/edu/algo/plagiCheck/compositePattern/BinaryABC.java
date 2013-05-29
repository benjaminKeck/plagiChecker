package hm.edu.algo.plagiCheck.compositePattern;

public abstract class BinaryABC implements IAST{
	private IAST child1;
	private IAST child2;
	
	public BinaryABC(IAST child1, IAST child2){
		this.child1 = child1;
		this.child2 = child2;
	}
	
	public String toString(){
		return child1 + " | " + child2;
	}
}
