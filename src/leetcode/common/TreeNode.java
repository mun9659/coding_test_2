package leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}
    
    TreeNode(int val) { this.val = val; }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer... integers) {
        List<TreeNode> list = new ArrayList<>();
        this.val = integers[0];
        for (Integer integer : integers) {
            list.add(integer == null ? null : new TreeNode(integer));
        }
 
        if (integers.length > 1) {
            this.left = list.get(1);
        }
        if (integers.length > 2) {
            this.right = list.get(2);
        }
 
        for (int i = 3; i < integers.length; i++) {
            if (i % 2 == 0) {
                list.get((i - 1) / 2).right = list.get(i);
            } else {
                list.get((i - 1) / 2).left = list.get(i);
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val = " + val +
                ", left = " + left + "}" +
                ", right = " + right + "}";
    }
         
}
