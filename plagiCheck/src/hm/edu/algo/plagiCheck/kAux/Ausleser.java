package hm.edu.algo.plagiCheck.kAux;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Ausleser {
	  public static void main(String[] args) throws IOException
	  {
	    FileReader fr = new FileReader("C:\\Users\\Prodanova\\workspaceBagi\\test.txt");
	    BufferedReader br = new BufferedReader(fr);

	    String zeile = "";

	    while( (zeile = br.readLine()) != null ) {
	    	String[] zeileSplit = zeile.split(" ");
	    	for(String wort: zeileSplit) {
	    		wort = Pattern.compile("\\p{Punct}").matcher(wort).replaceAll("");
	    		System.out.println(wort);
	    	}
	    }

	    br.close();
	  }
}
