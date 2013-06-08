package hm.edu.algo.plagiCheck.kAux;

import java.util.ArrayList;

public class Scorer {
	private ArrayList<IIndexReference> index1, index2;
	public Scorer(ArrayList<IIndexReference> in1, ArrayList<IIndexReference> in2){
		this.index1 = in1;
		this.index2 = in2;
		start();
	}
	
	private void start(){
		for(int i=0; i<index1.size(); i++){
			if(isThere(index1.get(i))){
				System.out.println("Gibt es in beiden: "+index1.get(i).getStringCode());
			}
		}
	}
	private boolean isThere(IIndexReference word){
		for(int i=0; i<index2.size(); i++){
			if(index2.get(i).getClassCode().equals(word.getClassCode())){
				if(index2.get(i).getStringCode()== word.getStringCode()){
					return true;
				}
			}
		}
		return false;
	}
}
