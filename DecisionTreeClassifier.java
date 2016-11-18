import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * Varun Batra
 * this is the runner class
 * 
 */
public class DecisionTreeClassifier {
	TreeNavigator t = new TreeNavigator();
	InputStreamReader inStream = new InputStreamReader(System.in);
	BufferedReader scan = new BufferedReader(inStream);
	/*
	 * runs menu of edit tree operations
	 */
	public void editTree(){
	
		System.out.println("E) Edit Keywords" );
		System.out.println("C) Add Children" );
		System.out.println("D) Delete Children and make leaf" );
		System.out.println("N) Cursor to no child" );
		System.out.println("Y) Cursor to yes child" );
		System.out.println("R) Cursor to root" );
		System.out.println("M) Main Menu" );
		if(t.getRoot()==null){
			String[] empty ={" Empty Node", };
			t.setRoot(new TreeNode(empty,null,null));
		}
		t.resetCursor();
		if(t.getRoot()!=null){
		System.out.println("Cursor is at Root, keywords are ");
		for(int i =0; i<t.getCursor().getKeywords().length;i++){
		System.out.print(t.getCursor().getKeywords()[i]+ ", ");
		}
		}
		this.editTreeOperate();
		
	}
	/*
	 * performs operations of edit tree
	 */
	public void editTreeOperate(){
	
	
		try {
			switch(scan.readLine().toUpperCase()){// case insensitive
			case "E":System.out.println("Please enter keywords for this node, separated by a comma");
			String text = scan.readLine();
			String []words = text.split(",");
			t.editCursor(words);// set new words to cursors keywords
			System.out.print("Cursor updated to ");
			for(int i =0;i < t.getCursor().getKeywords().length;i++){
				System.out.print(t.getCursor().getKeywords()[i]+", ");// print out  keywords
			}
			System.out.println();
			this.editTreeOperate();
			break;
			case "C":System.out.println("Please enter terminal text for the no leaf");
			String noLeaf = scan.readLine();
			String [] noL = noLeaf.split(",");
			t.getCursor().setLeft(new TreeNode(noL,null,null));
			System.out.println("Please enter terminal text for the yes leaf");
			String yesLeaf = scan.readLine();
			String [] yL = yesLeaf.split(",");
			t.getCursor().setRight(new TreeNode(yL,null,null));
	System.out.println("Children are "+ " yes: "+ yesLeaf+ " No: "+ noLeaf);
			this.editTreeOperate();
			break;
			
			case"N":
			if(t.getCursor().getleft()!=null){
				t.cursorLeft();
			System.out.println("Cursor moved, message is ");
			for(int i =0;i < t.getCursor().getKeywords().length;i++){
				System.out.print(t.getCursor().getKeywords()[i]+", ");
			}
			}
			else{
				System.out.println("Left is null please add a left child");
			}
			this.editTreeOperate();
			break;
			
		case"Y":if(t.getCursor().getRight()!=null){
			
			t.cursorRight();
		System.out.println("Cursor moved, message is ");
		for(int i =0;i < t.getCursor().getKeywords().length;i++){
			System.out.print(t.getCursor().getKeywords()[i]+", ");
		}
		}
		else{
			System.out.println("Right is null please add a right child");
		}
		this.editTreeOperate();
		break;
		case"R": t.resetCursor();
		System.out.println("Cursor is at root");
		for(int i =0; i<t.getCursor().getKeywords().length;i++){
			System.out.print("Cursor keywords are "+t.getCursor().getKeywords()[i]+ " ");
			}
		this.editTreeOperate();
		break;
		
		case "D":
			System.out.println("Enter a terminal text for this node");
			String newText = scan.readLine();
			String [] newT = newText.split(",");
			t.editCursor(newT);
			t.getCursor().setLeft(null);
			t.getCursor().setRight(null);
			System.out.println("Current node is leaf, keywords are");
			
			for(int i =0; i<t.getCursor().getKeywords().length;i++){
				System.out.print(t.getCursor().getKeywords()[i]+ " ");
				}
			this.editTreeOperate();
			break;
		case"M": this.operate();
			}
	
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
/*
 * runs operations of main menu
 */
public void operate(){
	this.mainMenu();
	try {
		switch(scan.readLine().toUpperCase()){
		case "I":System.out.println("Enter the file name");// build Tree Navigator based on file
		String fileName = scan.readLine();
		t=t.buildTree(fileName);
		this.operate();
		break;
		case "E":this.editTree();// call edit tree operations
		this.operate();
		break;
		case "P":
			System.out.println("Enter some text");
			String path = scan.readLine();
			t.getPath(path);// generate a path on a given text
			this.operate();
			break;
		case"C":
			System.out.println("I didnt implement this method");
			this.operate();
			break;
		case"Q":
			System.out.println("Exiting...");
			break;
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*
 * Shows main menu operations
 */
public void mainMenu(){
	System.out.println("Main Menu: " );
	System.out.println("I) Import tree From a file" );
	System.out.println("E) Edit Current Tree" );
	System.out.println("C) Classify a description" );
	System.out.println("P) Show decision path for a description" );
	System.out.println("Q) Quit" );

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecisionTreeClassifier d = new DecisionTreeClassifier();

		d.operate();

	}

}
