package assistant;

/**
 * Assistant to provide helper methods for tree.
 * Created by ritesh on 12/20/15.
 */
public class TreeAssistant {

    public Tree printTree(Tree node) {

        if(node == null) {
            return null;
        }

        System.out.print(node.getData());
        printTree(node.left);
        printTree(node.right);

        return node;
    }

    public Tree createBinarySearchTree(int[] data, int start, int end) {

        if(end<start) {
            return null;
        }

        int middle = (start+end)/2;
        Tree n = new Tree(data[middle]);

        n.left = createBinarySearchTree(data,start, middle-1);
        n.right = createBinarySearchTree(data,middle+1,end);

        return n;
    }

    public Tree createBinaryTree(int root, int left, int right) {

        Tree binaryNode = new Tree(root);
        Tree leftBinaryNode = new Tree(left);
        Tree rightBinaryNode = new Tree(right);

        binaryNode.left = leftBinaryNode;
        binaryNode.right = rightBinaryNode;

        return binaryNode;
    }

    public Tree createBinaryTree(int root, int left, int right, Tree parent) {

        Tree binaryNode = new Tree(root);
        Tree leftBinaryNode = new Tree(left);
        Tree rightBinaryNode = new Tree(right);

        binaryNode.left = leftBinaryNode;
        binaryNode.right = rightBinaryNode;
        binaryNode.parent = parent;

        return binaryNode;
    }
}
