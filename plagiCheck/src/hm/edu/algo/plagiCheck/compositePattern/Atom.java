package hm.edu.algo.plagiCheck.compositePattern;

public class Atom implements IAST{
	private String name;
	public Atom(String name){
		this.name=name;
	}
	public String toString(){
		return name;
	}
}
