import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.SynchronousQueue;
/*
 * Varun Batra
 * This class implements an instance of TreeNavigator
 * Treenode root
 * root node
 * Treenode cursor
 * cursor of tree
 * Treenode parent of cursor
 * cursor before cursor is moved
 */
public class TreeNavigator {
	private TreeNode root;
	private TreeNode cursor;
	private TreeNode parentOfCursor;
	
	/*
	 * This method returns a Treenavigator
	 * @param String treeFile
	 * file name
	 * 
	 */
	public static TreeNavigator buildTree(String treeFile){
		FileInputStream fis;
		String data="";
		TreeNavigator t = new TreeNavigator();
		
		try {
			String [] split;
			String [] keywords;
			fis = new FileInputStream(treeFile);
			InputStreamReader inStream = new InputStreamReader(fis);
			BufferedReader stdin = new BufferedReader(inStream);
			// set up the file reader
			
				 data = stdin.readLine();
				 while(data!=null){
				 split =data.split(";");
				 keywords = split[1].split(",");
				 t.cursor=t.root;
				 // read file until it ends
					 for(int j =0; j<split[0].length();j++) {// if j = root
						
						 if(j==0&& j==split[0].length()-1){
							 t.root = new TreeNode(keywords,null,null);
							 System.out.println(split[0]+ t.root.getKeywords()[0]);
							 continue;
							 
						 }
						 if(j!=0&&split[0].charAt(j)=='0'){// if its not the root and 0 go to left
							 t.parentOfCursor=t.cursor;
							 t.cursor= t.cursor.getleft();
							 if(j==split[0].length()-1){
								
								
								 t.cursor= new TreeNode(keywords,null,null);
								 t.parentOfCursor.setLeft(t.cursor);
								 System.out.println(split[0]+ t.cursor.getKeywords()[0]);
								// set keywords of that node to keywords, print it oout
							 }
							 
						 }
						 if(j!=0&&split[0].charAt(j)=='1'){// if not root and 1 go to right
							 t.parentOfCursor=t.cursor;
							 t.cursor= t.cursor.getRight();
							 if(j==split[0].length()-1){
								 t.cursor= new TreeNode(keywords,null,null);
								 t.parentOfCursor.setRight(t.cursor);
								 System.out.println(split[0]+ t.cursor.getKeywords()[0]);
								
							 }
							 
						 }
					 
				 }
					 data = stdin.readLine();
				 }
				
					
				
			
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		
		
		return t;
		
	}
/*
 * set this cursor to root
 */
	public void resetCursor(){

		this.cursor = root;
		
	}
	/*
	 * @ return TreeNode
	 * current cursor
	 */
	public TreeNode getCursor(){
		return this.cursor;
	}
	/*
	 * move cursor to the left
	 */
	public void cursorLeft(){
		parentOfCursor = cursor;
		cursor = cursor.getleft();
	
	
	}
	/*
	 * move cursor to the right
	 */
	public void cursorRight(){
		parentOfCursor = cursor;
		cursor = cursor.getRight();
	
	}
	/*
	 * set the keywords of this cursor to text
	 * @ param String[] text
	 * new words
	 */
	public void editCursor(String[] text){
		if( this.cursor!=null){
			this.cursor.setKeywords(text);
		}
		
	}
	/*
	 * set the cursor to a treenode
	 * @ param TreeNode x
	 * new cursor
	 */
	public void setCursor(TreeNode x){
		this.cursor = x;
	}
	/*
	 * set root to Treenode
	 * @param Treenode x
	 * new root
	 */
	public void setRoot(TreeNode x){
		this.root = x;
	}
	/*
	 * @return TreeNode
	 * root
	 */
	public TreeNode getRoot(){
		return this.root;
	}
	/*
	 * get decision path of a string
	 */
	public void getPath(String text){
		
		
	
		this.getPathHelper(this.root, text);
	

	
	
}
	/*
	 * Return decision path of a string
	 * @ param TreeNode t
	 * root
	 * @param String text
	 * text to be decided
	 */
	public void getPathHelper(TreeNode t, String text ){
	
String [] words = text.split("[\\s\\n]");// split the text
if(t.isLeaf()){// if it is a leaf then it is the decision (base case)
	System.out.println("Decision "+ t.getKeywords()[0]);
	System.exit(0);
}
for(int i =0; i<t.getKeywords().length;i++){// while the words of this node match the words in the text
	for(int j =0; j<words.length;j++){
		if(t.getKeywords()[i].equalsIgnoreCase(words[j])){// if it does print is, recursively call on the right
			System.out.println( "IS "+t.getKeywords()[0]);
			this.getPathHelper(t.getRight(),text);
		
		
		}
		
	}
	
}
System.out.println( "NOT "+t.getKeywords()[0]);// if it doesnt print not recursively call on the left
this.getPathHelper(t.getleft(),text);
			
		
	
}
	
	
	
	
	 
	

	public static void main(String[] args) {
	
	}

}
