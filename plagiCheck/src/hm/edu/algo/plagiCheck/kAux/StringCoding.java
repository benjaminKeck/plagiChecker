package hm.edu.algo.plagiCheck.kAux;

public class StringCoding implements IActionAtInsert{

	private int counter;
	
	public StringCoding(){
		this.counter=0;
	}
	
	/**
	 * Im Fall das der Key gefunden wurde
	 */
	@Override
	public Object actionInCaseOfFoundKey(Object foundValue) {
		
		return foundValue;
	}

	/**
	 * Im Fall das der Key nicht gefunden wurde
	 */
	@Override
	public Object actionInCaseOfNotFoundKey() {
		//hier counter hochzählen
		return new Integer(counter++);
	}

	/**
	 * Methode wird wohl nie verwendet
	 */
	@Override
	public void setActualValue(Object updateValue) {
		// TODO Auto-generated method stub
		
	}

}
