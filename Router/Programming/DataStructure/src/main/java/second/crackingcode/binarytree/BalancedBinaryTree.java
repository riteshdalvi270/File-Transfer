package second.crackingcode.binarytree;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class BalancedBinaryTree
{

    public int determineHeight(Node root) {

        if(root == null) {
            return 0;
        }

        return Math.max(determineHeight(root.left),determineHeight(root.right)) +1;
    }

    public boolean balancedTree(Node root) {

        if(root == null) {
            return true;
        }

        int height = determineHeight(root.left) - determineHeight(root.right);

        if(Math.abs(height) > 1) {
            return  false;
        }

        return balancedTree(root.left) && balancedTree(root.right);
    }


    public boolean isBalancedWithoutRecursion(Node root) {

        if(root == null) {

            return true;
        }

        if(Math.abs(chechHeight(root)) > 1) {
            return false;
        }

        return true;

    }

    public int chechHeight(Node root) {

        if(root == null) {
            return 0;
        }

        int leftheight = chechHeight(root.left);

        if(leftheight ==  -1) {
            return -1;
        }

        int rightheight = chechHeight(root.right);

        if(rightheight == -1) {
            return -1;
        }

        int height = Math.max(leftheight,rightheight) +1;

        if(Math.abs(height) > 1) {
            return -1;
        }

        return height;
    }


    public class Node  {
        int data;
        Node left;
        Node right;
    }
}
