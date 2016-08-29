package second.crackingcode.binarytree;

/**
 * Implement a function to check if binary tree is binary search tree.
 * @author Ritesh Dalvi (RD026600)
 */
public class BinaryTreeBinarySearchTree
{

    //Not sure
    public boolean determineBinarySerachTree(Node root, int MIN, int MAX) {

        if(root == null) {
            return true;
        }

        MIN = Math.min(MIN, root.left.data);
        MAX = Math.max(MAX,root.right.data);

        if(root.left.data < root.data && MIN< root.data) {
            determineBinarySerachTree(root.left,MIN,MAX);
        } else {
            return false;
        }

        if(root.right.data > root.data && MAX > root.data) {
            determineBinarySerachTree(root.right,MIN,MAX);
        } else {
            return false;
        }

        return true;
    }

    //Right approach.
    public boolean determineBinarySearchTree(Node root, int MIN, int MAX) {

        if(root == null) {
            return true;
        }

        if(MIN > root.data || MAX < root.data) {
            return false;
        }

        if(determineBinarySearchTree(root.left,MIN, root.data) || determineBinarySearchTree(root.right,root.data,MAX)) {
            return true;
        } else {
            return false;
        }
    }


    public class Node {
        int data;
        Node right;
        Node left;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
