package third.crackingcode.binarytree;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * T2 is a subtree of T1.
 * Created by ritesh on 1/3/16.
 */
public class IndenticalTree {

    public static void main(String args[]) {


        //Original
        final TreeAssistant treeAssistant = new TreeAssistant();
        Tree first = treeAssistant.createBinaryTree(5, 6, 18, null);
        Tree secondLeft = treeAssistant.createBinaryTree(6, 3, 7, first);
        Tree thirdRight = treeAssistant.createBinaryTree(18, 17, 20, first);

        Tree firstTree = treeAssistant.createBinaryTree(3, 2, 4, secondLeft);

        first.left.left = firstTree;

        Tree secondTree = treeAssistant.createBinaryTree(7, 13, 9, secondLeft);

        first.left.right = secondTree;

        // Subtree
        Tree subtreefirst = treeAssistant.createBinaryTree(6, 3, 7);

        Tree subtree = treeAssistant.createBinaryTree(3, 2, 4);
        subtreefirst.left = subtree;

        //Tree secondTree1 = treeAssistant.createBinaryTree(7, 13, 9, secondLeft);

        //subtreefirst.right = secondTree1;

        Subtree subtree1 = new Subtree();
        System.out.println(subtree1.isSubtree(first, subtreefirst));
    }
}

class Subtree {

    public boolean isSubtree(Tree node1, Tree node2) {

        if (node1 == null && node2 != null) {
            return false;
        } else if (node1 != null && node2 == null) {
            return true;
        }

        if (cover(node1.left, node2) || cover(node1.right, node2)) {
            return true;
        }

        return isSubtree(node1.left, node2) || isSubtree(node1.right, node2);
    }

    public boolean cover(Tree node1, Tree node2) {

        if (node1 == null && node2 == null) {
            return true;
        } else if (node2 == null && node1 != null) {
            return false;
        } else if (node1 == null && node2 != null) {
            return false;
        }

        if (node1.getData() == node2.getData()) {
            return cover(node1.left, node2.left) && cover(node1.right, node2.right);
        } else if (node1.getData() != node2.getData()) {
            return false;
        }

        return true;
    }
}


