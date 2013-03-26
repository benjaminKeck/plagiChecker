package hm.edu.keckes.algo.plagiCheck.logging;

public class Log {
	public final static int URGENT=0;
	public final static int NORMAL=1;
	
	public static void println(int level, String text){
		if(level==URGENT)
			System.out.println("LOG_URGENT: "+text);
		else
			System.out.println("LOG_NORMAL: "+text);
	}
}
