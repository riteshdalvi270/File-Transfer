package crackingcodefive.binary;

/**
 * Created by ritesh on 8/25/16.
 */
public class BalancedBinaryTree {

    public static void main(String args[]) {

        final Tree root = new Tree(null, 5, null);
        final Tree left = new Tree(null, 3, null);
        final Tree right = new Tree(null, 6, null);

        final Tree left1 = new Tree(null,7, null);
        final Tree left2 = new Tree(null, 8, null);

        root.left = left;
        root.right = right;

        left.left = left1;
        left1.left = left2;

        System.out.println(isBalancedTree(root));
    }

    public static boolean isBalancedTree(final Tree root) {

        if(root == null) {
            return true;
        }

        int height = treeHeight(root.left) -  treeHeight(root.right);

        if(height > 1) {
            return false;
        }

        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    public static int treeHeight(final Tree node) {

        if(node == null) {

            return 1;
        }

        return Math.max(treeHeight(node.left), treeHeight(node.right)) + 1;
    }

    static class Tree {

        int data;
        Tree left;
        Tree right;

        Tree(Tree left, int data, Tree right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
