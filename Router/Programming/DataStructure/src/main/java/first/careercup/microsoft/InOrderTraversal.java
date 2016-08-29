package first.careercup.microsoft;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class InOrderTraversal
{

    public static void main(String[] args) {
        Node<Integer> root = new Node(10);
        root.right = new Node<>(9);
        root.right.right = new Node<>(6);
        root.right.left = new Node<>(7);

        root.left = new Node<>(12);
        root.left.right = new Node<>(17);
        root.left.left = new Node<>(14);

        traverseBinaryTree(root);
    }

    public static Node traverseBinaryTree(Node<Integer> root) {

        if(root == null) {
            return null;
        }

       traverseBinaryTree(root.left);
        System.out.println("root:" + root.data);
       traverseBinaryTree(root.right);

        return root;
    }

    public static class Node<Integer> {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }

   // Solution:
    //http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
}
