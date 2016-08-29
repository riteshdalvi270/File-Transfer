package third.crackingcode.binarytree;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * Find common ancestor of binary tree.
 * Created by ritesh on 1/3/16.
 */
public class CommonAncestor {

    public static void main(String args[]) {

        final TreeAssistant treeAssistant = new TreeAssistant();
        Tree first = treeAssistant.createBinaryTree(5, 6, 18, null);
        Tree secondLeft = treeAssistant.createBinaryTree(6,3,7,first);
        Tree thirdRight = treeAssistant.createBinaryTree(18,17,20,first);

        Tree firstTree = treeAssistant.createBinaryTree(3,2,4,secondLeft);

        first.left.left = firstTree;

        Tree secondTree = treeAssistant.createBinaryTree(7,13,9,secondLeft);

        first.left.right = secondTree;

        FindCommonAncestor findCommonAncestor = new FindCommonAncestor();
        Tree commonAncestor = findCommonAncestor.findCommonAncestor(first, firstTree, secondTree);

        System.out.print(commonAncestor.getData());
    }
}

// Looked at the solution.I was unsuccessful.
class FindCommonAncestor {

    public Tree findCommonAncestor(final Tree ancestor,final Tree node1, Tree node2) {

        return null;
    }
}