package hm.edu.algo.plagiCheck.compositePattern;

public class It implements IAST{
	private IAST child;
	
	public It(IAST child){
		this.child=child;
	}
	public String toString(){
		return child+" * ";
	}
}
