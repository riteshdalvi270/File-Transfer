package third.crackingcode.binarytree;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * Determine if binary tree is binary search tree.
 * Created by ritesh on 12/21/15.
 */
public class BinaryTreeBinarySearchTree {

    public static void main(String args[]) {

        int data[] = new int[]{3, 4, 6, 7, 8, 9};

        TreeAssistant treeAssistant = new TreeAssistant();
        Tree node = treeAssistant.createBinarySearchTree(data, 0, data.length - 1);

        System.out.println(determineIfBinaryTreeIsBinarySearchTree(node, Integer.MAX_VALUE, Integer.MIN_VALUE));


        /**
         * Create binary tree and not a search tree.
         */
        Tree root = treeAssistant.createBinaryTree(6, 3, 8);
        Tree left = treeAssistant.createBinaryTree(9, 10, 11);

        root.left.left = left;

        System.out.println(determineIfBinaryTreeIsBinarySearchTree(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    public static boolean determineIfBinaryTreeIsBinarySearchTree(Tree node, int min, int max) {

        if (node == null) {
            return true;
        }

        boolean leftIndicator = true, rightIndicator = true;

        if (node.getData() < min) {
           leftIndicator = determineIfBinaryTreeIsBinarySearchTree(node.left, node.getData(), Integer.MIN_VALUE);
        } else {
            leftIndicator = false;
            return leftIndicator;
        }

        if (node.getData() > max) {
            rightIndicator = determineIfBinaryTreeIsBinarySearchTree(node.right, Integer.MAX_VALUE, node.getData());
        } else {
            rightIndicator = false;
            return rightIndicator;
        }

        if(!leftIndicator || !rightIndicator) {
            return false;
        }

        return leftIndicator || rightIndicator;
    }
}
