package hm.edu.algo.plagiCheck.compositePattern;

public class Conc implements IAST{
	private IAST child1;
	private IAST child2;
	
	public Conc(IAST child1, IAST child2){
		this.child1=child1;
		this.child2=child2;
	}
	
	public String toString(){
		return child1+" ° "+child2;
	}
}
