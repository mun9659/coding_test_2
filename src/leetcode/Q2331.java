package leetcode;

import leetcode.common.TreeNode;

public class Q2331 {
    
    public static void main(String[] args) {
        // 2331. 
        // You are given the root of a full binary tree with the following properties:

        // Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
        // Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
        // The evaluation of a node is as follows:

        // If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
        // Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
        // Return the boolean result of evaluating the root node.

        // A full binary tree is a binary tree where each node has either 0 or 2 children.

        // A leaf node is a node that has zero children.
        // TreeNode tree = new TreeNode(2, 1, 3, null, null, 0, 1);
        TreeNode tree = new TreeNode(0);
    
        System.out.println(evaluateTree(tree));
    }

    private static boolean evaluateTree(TreeNode tree) {
        return calculate(tree);
    }

    private static boolean calculate(TreeNode tree) {
        if(tree.val == 0 || tree.val == 1) {
            return tree.val == 1;
        } else if(tree.val == 2) {
            return calculate(tree.left) || calculate(tree.right);
        } else if(tree.val == 3) {
            return calculate(tree.left) && calculate(tree.right);
        }

        return false;
    } 

}
