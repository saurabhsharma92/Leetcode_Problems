package tree;

import java.util.ArrayList;
import java.util.List;

import classes.TreeNode;

public class PathSumII {
	
	/**
	 *Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
		Note: A leaf is a node with no children.		
		Example: Given the below binary tree and sum = 22,
		
		      5
		     / \
		    4   8
		   /   / \
		  11  13  4
		 /  \    / \
		7    2  5   1
		Return:	[ [5,4,11,2], [5,8,4,5] ]
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
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		System.out.println(pathSum(root,22));
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(null == root) return results;
        List<Integer> temp = new ArrayList<Integer>();
        checkPathSum(root,sum,0,results,temp);
        return results;
    }
    
    public static List<List<Integer>> checkPathSum(TreeNode root, int sum, int tempSum, List<List<Integer>> results,List<Integer> temp){
        if(null != root){
            tempSum = tempSum + root.val;
            temp.add(root.val);
            checkPathSum(root.left, sum, tempSum, results,temp);
            checkPathSum(root.right, sum, tempSum, results,temp);
            if(null == root.left && null == root.right && sum == tempSum){
            	List<Integer> swap = new ArrayList<Integer>();
            	swap.addAll(temp);
                results.add(swap);
            }
            temp.remove(temp.size()-1);
        }
        return results;
    }
}
