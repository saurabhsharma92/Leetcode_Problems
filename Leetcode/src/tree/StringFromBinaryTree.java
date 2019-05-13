package tree;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class StringFromBinaryTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);

        System.out.println(tree2str(t1));
    }

    public static String tree2str(TreeNode t) {
        if(t == null) return "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        String res=String.valueOf(t.val);
        if(!left.isEmpty() && !right.isEmpty()){
            res+="("+left+")("+right+")";
        }
        if(left.isEmpty() && !right.isEmpty()){
            res+="()("+right+")";
        }
        if(!left.isEmpty() && right.isEmpty()){
            res+="("+left+")";
        }
        return res;
    }

}
