package hm.edu.algo.plagiCheck.alignment;

import java.util.ArrayList;
import java.util.Iterator;

public class Presenter implements IPresenter {

	private String wordIn1, wordIn2, wordCons;
	private ArrayList<String> l1, l2, lCons;
	private String ausgabe;
	@Override
	public String backward() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Presenter(){
		wordIn1="";
		wordIn2="";
		wordCons="";
		ausgabe="";
		l1 = new ArrayList<String>();
		l2 = new ArrayList<String>();
		lCons = new ArrayList<String>();
	}
	
	public void print(){
		int i, count=0;
		int changeList = 0;
		Iterator it1 = l1.iterator();
		Iterator it2 = l2.iterator();
		Iterator itCons = lCons.iterator();

		while(it2.hasNext()){
			switch(changeList){
			case 0:
				if(it1.hasNext())
					ausgabe = ausgabe + it1.next();
				else
					ausgabe = ausgabe +" ";
				break;
			case 1:
				if(itCons.hasNext())
					ausgabe = ausgabe + itCons.next();
				else
					ausgabe = ausgabe +" ";
				break;
			case 2:
				if(it2.hasNext())
					ausgabe = ausgabe + it2.next();
				else
					ausgabe = ausgabe +" ";
				break;
				default:
					ausgabe = ".";
			}
			
			count++;
			if(count>=32){
				ausgabe = ausgabe + "|";
				count=0;
				changeList++;
				if(changeList==3){
					changeList=0;
					ausgabe = ausgabe +"\n";
				}
			}
		}
		// Liste 2 noch fertig ausgeben

		
			
		
		
		System.out.println(ausgabe);
	
	}	
	public void setOutput(String in1, String in2, String con){
		
		if(in1.length() != in2.length() && in2.length() != con.length())
			throw new IllegalArgumentException("Ungleiche Laenger der Ausgabe");
		
		for(int i=0; i<in1.length(); i++)
			l1.add(""+in1.charAt(i));
		for(int i=0; i<in2.length(); i++)
			l2.add(""+in2.charAt(i));
		for(int i=0; i<con.length(); i++)
			lCons.add(""+con.charAt(i));
		l1.add(" ");
		l2.add(" ");
		lCons.add(" ");
	}
	public void setWordForInput1(String word){
		wordIn1 = wordIn1 + word+" ";
		for(int i=0; i<word.length(); i++)
			l1.add(""+word.charAt(i));
		l1.add(" ");
	}
	public void setWordForInput2(String word){
		wordIn2 = wordIn2 + word+" ";
		for(int i=0; i<word.length(); i++)
			l2.add(word.charAt(i)+"");
		l2.add(" ");
	}
	public void setWordForCons(String word){
		wordCons = wordCons + word+" ";
		for(int i=0; i<word.length(); i++)
			lCons.add(word.charAt(i)+"");
		lCons.add(" ");
	}
	public void printHead(){
		int i=0;
		for(i=0; i<(3*32)+2; i++){
			System.out.print("-");
		}
		System.out.print("\nInput 1");
		for(i=0; i<25; i++){
			System.out.print(" ");
		}
		System.out.print("|Consensus");
		for(i=0; i<23; i++){
			System.out.print(" ");
		}
		System.out.print("|Input 2");
		for(i=0; i<32; i++){
			System.out.print(" ");
		}
		System.out.println("");
	}
}
