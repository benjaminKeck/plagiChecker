package hm.edu.algo.plagiCheck.triePackage;

public interface ITrieReference {
	boolean getFound();
	Object getStringCode();
	Object getPosition();
	void incrementDepth();
	int getDepth();
}
