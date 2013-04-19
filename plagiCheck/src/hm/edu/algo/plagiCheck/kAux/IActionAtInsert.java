package hm.edu.algo.plagiCheck.kAux;

public interface IActionAtInsert {
	public Object actionInCaseOfFoundKey(Object foundValue);
	public Object actionInCaseOfNotFoundKey();
	void setActualValue(Object updateValue);
}
