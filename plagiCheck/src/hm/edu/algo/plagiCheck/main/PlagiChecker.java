package hm.edu.algo.plagiCheck.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import hm.edu.algo.plagiCheck.alignment.Presenter;
import hm.edu.algo.plagiCheck.kAux.*;
import hm.edu.algo.plagiCheck.kAux.StringCoding;
import hm.edu.algo.plagiCheck.lexer.*;
import hm.edu.algo.plagiCheck.lexer.ILexer.LexerState;
import hm.edu.algo.plagiCheck.logging.Log;
import hm.edu.algo.plagiCheck.triePackage.*;


public class PlagiChecker {

	/**
	 * @author Benjamin Keckes
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args){
		
		final int traceLevel = Log.URGENT;
		
		
		//Wenn nicht zwei Textfiles als Parameter angegeben werden.
		if(args.length!=2){
			System.out.println("Sie muessen zwei Dateien zum Vergleich angeben\nDas Programm wird beendet!");
			return;
		}
		
		
		ILexer baseLexer = new BaseLexer();
		try{
			baseLexer.setFile(new FileReader(args[0]));
			Log.println(Log.NORMAL, "File "+args[0]+" erfolgreich eingelesen");
		}catch(FileNotFoundException e){
			Log.println(Log.URGENT, "Datei "+args[0]+" konnte nicht gefunden werden");
			e.printStackTrace();
			return;
		}
		
		ArrayList<IIndexReference> index1, index2;
		index1 = baseLexer.read();
		
		try{
			baseLexer.setFile(new FileReader(args[1]));
			Log.println(Log.NORMAL, "File "+args[1]+" erfolgreich eingelesen");
		}catch(FileNotFoundException e){
			Log.println(Log.URGENT, "Datei "+args[1]+" konnte nicht gefunden werden");
			e.printStackTrace();
			return;
		}
		index2 = baseLexer.read();
		
		Iterator it;
//		it = index2.iterator();
//		while(it.hasNext()){
//			IIndexReference ref = (IndexReference)it.next();
//			System.out.println(ref.getClassCode()+": "+ref.getStringCode()+" "+baseLexer.decode(ref));
//		}
		
		Scorer scorer = new Scorer(index1, index2, baseLexer);	
		scorer.startScoring();
		
		
		//scorer.printResult();
	
		
		
	}
	
}
