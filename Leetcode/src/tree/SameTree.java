package tree;

import java.util.LinkedList;
import java.util.List;

import classes.TreeNode;

public class SameTree {

	public static void main(String[] args) {
		TreeNode pNode = new TreeNode(1);
		pNode.left = new TreeNode(2);
		pNode.right = new TreeNode(1);
		TreeNode qNode = new TreeNode(1);
		qNode.left = new TreeNode(1);
		qNode.right = new TreeNode(2);
		System.out.println();
		System.out.println(new SameTree().isSameTree(pNode,qNode));
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		List pList = new LinkedList();
		List qList = new LinkedList();
		pList = getTreeNodes(p,pList);
        qList = getTreeNodes(q,qList);
        System.out.println(" pList : "+pList.toString());
        System.out.println(" qList : "+qList.toString());
        if(qList.equals(pList)){
            return true;
        }else{
            return false;
        }
    }
    
    public List<Integer> getTreeNodes(TreeNode node, List tempList){
        if(node != null) {
        	tempList.add(node.val);
        	if(null != node.left){
                getTreeNodes(node.left,tempList);
            }
        	else if(null == node.left && null != node.right) {
            	tempList.add(null);
            }
            if(null != node.right) {
                getTreeNodes(node.right,tempList);
            }/*else {
            	tempList.add(null);
            }*/
        }
        return tempList;
    }
	
    //best answer
	/*public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }*/
}
