package hm.edu.algo.plagiCheck.kAux;

import java.util.HashMap;

public class Knoten {
	private HashMap<Character, Knoten> kante;
	private int zustand;
	private Character endZustand;
	
	public Knoten(int zustand){
		kante = new HashMap<Character, Knoten>();
		this.zustand = zustand;
		if(zustand==3){
			endZustand='B';
		}
		else if(zustand==5){
			endZustand='A';
		}
		else
			endZustand=null;
	}
	
	public int getZustand(){
		return zustand;
	}
	
	public Character getEndZustand(){
		return endZustand;
	}
	public Knoten getKnoten(Character key){
		return kante.get(key);
	}
	
	public void addKante(Character c, Knoten k){
		kante.put(c, k);
	}
	
	public Knoten jump(Character c){
		return kante.get(c);
	}
}
