
public class HashTable implements IHashTable {
	
	//You will need a HashTable of LinkedLists. 
	
	private int nelems;  //Number of element stored in the hash table
	private int expand;  //Number of times that the table has been expanded
	private int collision;  //Number of collisions since last expansion
	private String statsFileName;     //FilePath for the file to write statistics upon every rehash
	private boolean printStats = false;   //Boolean to decide whether to write statistics to file or not after rehashing
	
	//You are allowed to add more :)
	
	public HashTable(int size) {
		
		//Initialize
	}
	
	public HashTable(int size, String fileName){
		
		// Set printStats to true and statsFileName to fileName
	}

	public boolean insert(String value) {
		
		//TODO
	}

	public boolean delete(String value) {
		
		//TODO
	}

	public boolean lookup(String value) {
		
		//TODO
	}

	public void printTable() {

		//TODO
	}
	
	public int getSize() {

		//TODO
	}

	private int hashVal(String str) {

		//TODO
	}

	private void rehash() {

		//TODO
	}

	private void printStatistics() {

		//TODO
	}

}
