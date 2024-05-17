package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1325 {

    public static void main(String[] args) {

        // 1325. Delete Leaves With a Given Value
        // Given a binary tree root and an integer target, delete all the leaf nodes with value target.

        // Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you cannot).
        TreeNode root = new TreeNode(1, 2, 3, 2, null, 2, 4);
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = null;
        // root.left.left = new TreeNode(2);
        // root.left.left.left= new TreeNode(2);

        int target = 2;

        System.out.println(removeLeafNodes(root, target));
    }

    private static TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if(root.left == null && root.right == null && root.val == target)
            return null;

        return root;
    }

}
