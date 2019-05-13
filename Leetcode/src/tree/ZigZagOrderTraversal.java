package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import classes.TreeNode;

public class ZigZagOrderTraversal {
	/**
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

		For example:
		Given binary tree [3,9,20,null,null,15,7],
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its zigzag level order traversal as:
		[
		  [3],
		  [20,9],
		  [15,7]
		]
	 */
	public static void main(String[] args) {
		TreeNode pNode = new TreeNode(3);
		pNode.left = new TreeNode(9);
		pNode.right = new TreeNode(20);
		//pNode.left.left = new TreeNode(4);
		pNode.right.left = new TreeNode(15);
		pNode.right.right = new TreeNode(7);
		
		TreeNode qNode = new TreeNode(1);
		qNode.left = new TreeNode(2);
		qNode.right = new TreeNode(3);
		qNode.left.left = new TreeNode(4);
		//qNode.left.right = new TreeNode(4);
		//qNode.right.left = new TreeNode(4);
		qNode.right.right = new TreeNode(5);
		
		System.out.println("pNode : "+zigzagLevelOrder(pNode).toString());
		//System.out.println("qnode : "+zigzagLevelOrder(qNode).toString());
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = breadthFirstSearch(root);
        return result;
    }
    
    public static List<List<Integer>> breadthFirstSearch(TreeNode root){
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        q1.add(root);
        int levelCount = 1;
        int currentCount = 0;
        int depth = 0;
        while(!q1.isEmpty()){
            TreeNode node = q1.poll();
            temp.add(node.val);
            if(null != node.left){
                q1.add(node.left); 
                currentCount++;
            }
            if(null != node.right){
                q1.add(node.right); 
                currentCount++;
            }
            levelCount --;
            if(levelCount == 0){
                levelCount = currentCount;
                currentCount = 0;
                if(depth % 2 != 0) {
                	Collections.reverse(temp);
                }
                result.add(temp);
                depth++;
                temp = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
