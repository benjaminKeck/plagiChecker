package hm.edu.algo.plagiCheck.triePackage;

public interface ITrieReference {
	boolean getFound();
	Object getCode();
	Object getPosition();
	void incrementDepth();
	int getDepth();
}
