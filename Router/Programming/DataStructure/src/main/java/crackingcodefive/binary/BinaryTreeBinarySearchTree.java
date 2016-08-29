package crackingcodefive.binary;

/**
 * Created by ritesh on 8/26/16.
 */
public class BinaryTreeBinarySearchTree {

    public static void main(String args[]) {

        isBinaryTreeBinarySearchTree();
    }

    public static boolean isBinaryTreeBinarySearchTree(final Tree root) {

        if(root == null) {
            return true;
        }


    }

    private static class Tree {
        int data;
        Tree left;
        Tree right;
    }
}
