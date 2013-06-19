package hm.edu.algo.plagiCheck.kAux;

public class KnotenTester {
	
	public static void main(String[] args){
		
		Knoten root = new Knoten(0);
		Knoten eins = new Knoten(1);
		Knoten zwei = new Knoten(2);
		Knoten drei = new Knoten(3);
		Knoten vier = new Knoten(4);
		Knoten fuenf = new Knoten(5);
		
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
		
		Knoten akt = root;
		for(int i=0; i<text.length(); i++){
			akt = akt.jump(text.charAt(i));
			
			System.out.print("Num: "+akt.getZustand());
			if(akt.getEndZustand()!=null)
				System.out.print("->"+akt.getEndZustand());
			System.out.println("");
		}
		
	}
}
