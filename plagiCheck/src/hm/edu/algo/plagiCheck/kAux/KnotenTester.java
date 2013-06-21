package hm.edu.algo.plagiCheck.kAux;

public class KnotenTester {
	
	public static void main(String[] args){
		
		StateKnoten root = new StateKnoten(0);
		StateKnoten eins = new StateKnoten(1);
		StateKnoten zwei = new StateKnoten(2);
		StateKnoten drei = new StateKnoten(3);
		StateKnoten vier = new StateKnoten(4);
		StateKnoten fuenf = new StateKnoten(5);
		
		root.addKante('a', eins);
		eins.addKante('b', zwei);
		zwei.addKante('c', drei);
		drei.addKante('a', vier);
		vier.addKante('b', fuenf);
		fuenf.addKante('c', drei);
		
		
		eins.addKante('a', eins);
		zwei.addKante('a', eins);
		vier.addKante('a', eins);
		fuenf.addKante('a', eins);
		
		
		String text = "abcaabcabcab";
		
		StateKnoten akt = root;
		for(int i=0; i<text.length(); i++){
			akt = akt.getKnoten(text.charAt(i));
			
			System.out.print("Num: "+akt.getZustand());
			if(akt.getZustand()==3)
				System.out.print("->B");
			else if(akt.getZustand()==5){
				System.out.print("->A");
			}
			System.out.println("");
		}
		
	}
}
