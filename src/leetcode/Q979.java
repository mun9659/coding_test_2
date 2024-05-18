package leetcode;

import leetcode.common.TreeNode;

public class Q979 {

    public static void main(String[] args) {

        // 979. Distribute Coins in Binary Tree
        // You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
        // In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
        // Return the minimum number of moves required to make every node have exactly one coin.
        
        // 다시 풀 예정
        
        TreeNode root = new TreeNode(3,0,0);

        System.out.println(distributeCoins(root));
    }

    private static int distributeCoins(TreeNode root) {
        TreeNode dummy = new TreeNode();
        return dfs(root, dummy);
    }

    private static int dfs(TreeNode cur_node, TreeNode parent) {
        if(cur_node == null)
            return 0;

        int moves = dfs(cur_node.left, cur_node) + dfs(cur_node.right, cur_node);
        int from_this = cur_node.val - 1;
        parent.val += from_this;
        moves += Math.abs(from_this);
        return moves;
    }

}
