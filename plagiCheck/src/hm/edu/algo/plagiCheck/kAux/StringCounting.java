package hm.edu.algo.plagiCheck.kAux;

public class StringCounting implements IActionAtInsert{

	private static int count;
	
	public StringCounting(){
		count=0;
	}
	@Override
	public Object actionInCaseOfFoundKey(Object foundValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object actionInCaseOfNotFoundKey() {
		return ++count;
	}

	@Override
	public void setActualValue(Object updateValue) {
		// TODO Auto-generated method stub
		
	}

}
