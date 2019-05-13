package tree;

import java.util.ArrayList;
import java.util.List;

import classes.TreeNode;

public class PathSum {
	
	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
		Note: A leaf is a node with no children.
		Example:		
		Given the below binary tree and sum = 22,
		
		      5
		     / \
		    4   8
		   /   / \
		  11  13  4
		 /  \      \
		7    2      1
		return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. 
	 */

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		System.out.println(hasPathSum(root,22));
	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(null == root) return false;
		List<Integer> results = checkPathSum(root,0,sum,new ArrayList<Integer>());
        return results.contains(sum);
    }
    
    public static List<Integer> checkPathSum(TreeNode root,int tempSum, int sum,List<Integer> results){
        if(null != root){
        	tempSum = tempSum + root.val;
            checkPathSum(root.left,tempSum,sum,results);
            if(null == root.left && null == root.right && sum == tempSum) {
            	results.add(tempSum);
            }
            checkPathSum(root.right,tempSum,sum,results);
        }
        return results;
    }
}
