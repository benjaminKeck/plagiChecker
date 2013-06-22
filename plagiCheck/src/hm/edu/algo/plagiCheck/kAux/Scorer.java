package hm.edu.algo.plagiCheck.kAux;

import hm.edu.algo.plagiCheck.alignment.Presenter;
import hm.edu.algo.plagiCheck.lexer.ILexer;
import hm.edu.algo.plagiCheck.lexer.ILexer.LexerState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.prefs.PreferenceChangeEvent;

public class Scorer {
	private ArrayList<IIndexReference> index1, index2;
	private ILexer base;
	private Presenter presenter;
	
	public Scorer(ArrayList<IIndexReference> in1, ArrayList<IIndexReference> in2, ILexer base){
		this.index1 = in1;
		this.index2 = in2;
		this.base = base;
		this.presenter = new Presenter();
	}
	
	public void printResult(){
		presenter.printHead();
	}
	
	public void startScoring(){
		
		presenter.printHead();
		int pos=0;
		int f1Pos=-1;
		int count=0;
		
		int i=0;
		for(i=0; i<index1.size(); i++){
			
			//Suche im anderen File
			pos=index2.indexOf(index1.get(i));
//			if(pos<0)
//				presenter.setWordForInput2(getNotFoundChars(base.decode(index1.get(i)).length()));
			if(pos!=i){
				if(pos<0){
					presenter.setWordForInput2(getNotFoundChars(base.decode(index1.get(i)).length(), '-'));
				}
				if(pos>i){
					IIndexReference tempRef = base.insertWordInTrie(LexerState.ID, getNotFoundChars(5, '+'));
					index1.add(i, tempRef);
				}
				else{
					if(pos>0)
						index2.add(pos, index1.get(i));
				}
			}
			
			presenter.setWordForInput1(base.decode(index1.get(i)));
			presenter.setWordForInput2(base.decode(index2.get(i)));
		}
		Iterator it = index1.iterator();
		while(it.hasNext())
			presenter.setWordForInput1(base.decode((IIndexReference)it.next()));
		it = index2.iterator();
		while(it.hasNext()){
			presenter.setWordForInput2(base.decode((IIndexReference)it.next()));
		}
		
		
		
		/**
		 * 
		 
		
		
		Iterator<IIndexReference> it = index1.iterator();
		while(it.hasNext()){
			IIndexReference ref = it.next();
			presenter.setWordForInput1(base.decode(ref));
			f1Pos++;
			
			pos = index2.indexOf(ref);
			if(pos!=f1Pos && pos>0){
				if(index2.get(pos).equals(ref)){
					pos=f1Pos;
				}
			}
			if(pos>=0){
				count++;
				if(f1Pos == pos)
					presenter.setWordForCons(base.decode(ref));
				else{
					String word="";
					for(int i=0; i<base.decode(ref).length(); i++){
						word = word +"-";
					}
					presenter.setWordForCons(word);
				}
				//System.out.println(base.decode(ref)+" an Stelle "+pos+" Schon "+count+" in a row");
			}
			else{
				count=0;
				String word="";
				for(int i=0; i<base.decode(ref).length(); i++){
					word = word +"_";
				}
				presenter.setWordForCons(word);
			}
		}
		*/
		presenter.print();
		
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
	
	private String getNotFoundChars(int length, Character sign){
		String word="";
		for(int i=0; i<length; i++){
			word = word +sign;
		}
		return word;
	}
}
