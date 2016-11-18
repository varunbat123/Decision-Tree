/*
 * Varun Batra
 * This class implements an instance of TreeNode
 * 
 */
public class TreeNode {
	private String[] keywords;
	private TreeNode left;
	private TreeNode right;
/*
 * TreeNode constructor 
 * @param String[] kw
 * key words
 * @param Treenode left
 * left child
 * @param treenode right
 * right child
 */
public TreeNode(String[]kw, TreeNode left, TreeNode right){
	this.keywords=kw;
	this.left=left;
	this.right=right;
}
/*
 * Returns a string array of this cursors keywords
 */
public String[] getKeywords(){
	return this.keywords;
}
/*
 * @ Return TreeNode
 * left child
 */
public TreeNode getleft(){
	return this.left;
	
}
/*
 * @ Return TreeNode
 * right child
 */
public TreeNode getRight(){
	return this.right;
	
}
/*
 * Set keywords of node
 */
public void setKeywords(String [] x){
	keywords=x;
	
}
/*
 * setLeft child to left
 */
public void setLeft(TreeNode left){
	this.left=left;
}
/*
 * set Right child to right
 */
public void setRight(TreeNode right){
	this.right=right;
}
/*
 * Return boolean
 * false if not leaf
 * true if leaf
 */
public boolean isLeaf(){
	boolean yes= false;
	if(this!=null){
	if(this.left== null&&this.right==null){
		yes= true;
	}
	}
	return yes;
	
}
}
