package third.crackingcode.binarytree;

import assistant.TreeNode;

/**
 * Check if the tree is balanced.
 * Created by ritesh on 12/18/15.
 */
public class BalancedBinaryTree {

    public static void main(String args[]) {

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(21);


        node1.left = node2;
        node1.right = node3;

        node2.left= node4;
        node2.right= node5;

        node3.left = node7;
        node3.right = node6;


        System.out.println(isBalanced(node1));

    }

    public static int getHeight(TreeNode root) {

        if(root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode node) {

        if(node == null) {
            return false;
        }

        int height = getHeight(node.left) - getHeight(node.right);

        if(Math.abs(height) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }
}
