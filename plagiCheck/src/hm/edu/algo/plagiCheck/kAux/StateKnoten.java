package hm.edu.algo.plagiCheck.kAux;

import java.util.HashMap;

public class StateKnoten {
	private HashMap<Character, StateKnoten> kante;
	private int zustand;
	private Character endZustand;
	
	public StateKnoten(int zustand){
		kante = new HashMap<Character, StateKnoten>();
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
	public StateKnoten getKnoten(Character key){
		return kante.get(key);
	}
	
	public void addKante(Character c, StateKnoten k){
		kante.put(c, k);
	}
	
	public StateKnoten jump(Character c){
		return kante.get(c);
	}
}
