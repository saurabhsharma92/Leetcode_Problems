package tree;

import classes.TreeNode;

public class SymmetryTree {

	public static void main(String[] args) {
		TreeNode pNode = new TreeNode(1);
		pNode.left = new TreeNode(2);
		pNode.right = new TreeNode(2);
		pNode.left.right = new TreeNode(3);
		pNode.right.right = new TreeNode(3);
		
		TreeNode qNode = new TreeNode(1);
		qNode.left = new TreeNode(2);
		qNode.right = new TreeNode(2);
		qNode.left.left = new TreeNode(3);
		qNode.left.right = new TreeNode(4);
		qNode.right.left = new TreeNode(4);
		qNode.right.right = new TreeNode(3);
		System.out.println(isSymmetric(pNode));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null) return false;
		return testSymmetry(root.left,root.right);
    }

	private static boolean testSymmetry(TreeNode left, TreeNode right) {
		if(null == left || null == right) return left == right;
		return left.val == right.val && testSymmetry(left.left, right.right) && testSymmetry(left.right, right.left);
	}
}
