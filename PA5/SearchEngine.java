import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SearchEngine {

	/* Populate a BST from a file
	 * @param searchTree - BST to be populated
	 * @param fileName - name of the input file
	 */
	public static boolean populateSearchTree(BSTree<String> searchTree, String fileName) {
		File file = new File(fileName);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				//read two lines - one for document and the next line for the list of keywords
				String document = scanner.nextLine().trim();
				String keywords[] = scanner.nextLine().split(" ");
				
				//TODO
				
			}
			scanner.close();
		} catch(FileNotFoundException e) {
			System.out.println("\nFile not found!!");
			return false;
		}
		return true;
	}
	
	/*Search a query in a BST
	 * @param searchTree - BST to be searched
	 * @param fileName - query string
	 * @returns LinkedList of documents in which the query string is found
	 */
	public static void searchMyQuery(BSTree<String> searchTree, String query) {
		
		//TODO
	}
	
	/*Print method 
	 * @param query input
	 * @param documents - result of SearchMyQuery
	 */
	 
	public static void print(String query, LinkedList<String> documents) {
		if(documents==null || documents.isEmpty())
			System.out.println("The search yielded no results for "+query);
		else {
			Object[] converted = documents.toArray();
			Arrays.sort(converted);
			System.out.println("Documents related to "+ query +" are: "+Arrays.toString(converted));
		}
	}
	
	public static void main( String[] args ) {
		
		if(args.length < 2) {
			System.err.println("Invalid number of arguments passed");
			return;
		}
		
		BSTree<String> searchTree = new BSTree<>();
		
		String fileName = args[0];
		String query = args[1];
		
		//Create my BST from file
		boolean check = populateSearchTree(searchTree, fileName);
		if(check == false) {
			System.out.println("\nUnable to create search tree");
		}
		
		searchMyQuery(searchTree, query);
	}
}
