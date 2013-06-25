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
	private int longestMatch;
	
	public Scorer(ArrayList<IIndexReference> in1, ArrayList<IIndexReference> in2, ILexer base){
		this.index1 = in1;
		this.index2 = in2;
		this.base = base;
		this.presenter = new Presenter();
		longestMatch=0;
	}

	public void printResult(){
		presenter.printHead();
	}
	
	
	public void startScoring(){
		
		presenter.printHead();
		int pos=0;
		int matchCountInARow=0;
		int i=0;
		
		for(i=0; i<index1.size(); i++){
			
			//Suche im anderen File
			pos=index2.indexOf(index1.get(i));
			
			//Falls Wort an gleicher Position in beiden Indexen
			if(i==pos){
				presenter.setWordForInput1(base.decode(index1.get(i)));
				presenter.setWordForInput2(base.decode(index2.get(pos)));
				presenter.setWordForCons(base.decode(index1.get(i)));
				matchCountInARow++;
			}
			
			
			//Falls das Wort im Index2 nicht gefunden wird.
			else if(pos==-1){
				String temp =base.decode(index1.get(i));
				IIndexReference tempRef = base.insertWordInTrie(LexerState.ID, getNotFoundChars(temp.length(), '+'));
				index2.add(i, tempRef);
				presenter.setWordForInput1(temp);
				presenter.setWordForInput2(base.decode(tempRef));
				
				presenter.setWordForCons(getNotFoundChars(temp.length(), '-'));
				matchCountInARow=0;
			}
			
			//Falls das Wort an einer anderen Position gefunden wird
			else if(pos!=i){
				
				//Falls es im Index2 an einer späteren Stelle gefunden wird.
				if(pos>i){
					int wordCount=0;
	
					for(int a=i; a<pos; a++){
						String temp =base.decode(index2.get(a));
						IIndexReference tempRef = base.insertWordInTrie(LexerState.ID, getNotFoundChars(temp.length(), '+'));
						index1.add(a, tempRef);
						presenter.setWordForInput1(base.decode(index1.get(a)));
						presenter.setWordForInput2(temp);
						
						presenter.setWordForCons(getNotFoundChars(temp.length(), '-'));
						matchCountInARow=0;
						wordCount++;
					}
					if(wordCount>1)
						i+=wordCount;

					continue;
				}
			
				
				//Falls das Wort schon an gleicher Position existiert, aber durch indexOf() früher gefunden wurde
				if(index2.get(i).equals(index1.get(i))){
					presenter.setWordForInput1(base.decode(index1.get(i)));
					presenter.setWordForInput2(base.decode(index2.get(i)));
					presenter.setWordForCons(base.decode(index1.get(i)));
				}
				else{
					presenter.setWordForInput1(base.decode(index1.get(i)));
					presenter.setWordForInput2(getNotFoundChars(base.decode(index1.get(i)).length(), '-'));
					presenter.setWordForCons(getNotFoundChars(base.decode(index1.get(i)).length(), '#'));
				}				
			}
		
			if(matchCountInARow>longestMatch)
				longestMatch=matchCountInARow;
		}

	
		presenter.print();
		
	}
	
	/**
	 * Gibt den längsten Match zurück.
	 * @return longestMatch
	 */
	public int getLongestMatch() {
		return longestMatch+1;
	}

	/**
	 * Gibt einen String aus dem sign in der länge length zurück.
	 * @param length
	 * @param sign
	 * @return auffüllString
	 */
	private String getNotFoundChars(int length, Character sign){
		String word="";
		for(int i=0; i<length; i++){
			word = word +sign;
		}
		return word;
	}
}
