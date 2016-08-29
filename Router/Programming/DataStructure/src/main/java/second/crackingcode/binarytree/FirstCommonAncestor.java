package second.crackingcode.binarytree;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class FirstCommonAncestor
{

    public static void main(String args[])
    {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        CreateBinarySearchTree createBinarySearchTree = new CreateBinarySearchTree(a);

    }

    // Assuming it child has link to its parent, we can perform BFS and then see the common parent. Will write the code later.

    // Assuming it does not have links to its parents.
    // Wrong
    public static int findCommonAncestor(Node root, Node p, Node q)
    {
        if (root == null)
        {
            return -1;
        }

        boolean isPOnTheLeft = covers(root.left, p);
        boolean isQOnTheLeft = covers(root.left, q);

        if (isPOnTheLeft && !isQOnTheLeft)
        {
            covers(root.left, q);
        }

        if (!isPOnTheLeft && isQOnTheLeft)
        {
            covers(root.right, p);
        }

        if (isPOnTheLeft && isQOnTheLeft)
        {
            return root.data;
        }

        return -1;
    }

    public static boolean covers(Node root, Node tobeSearched)
    {

        if (root == null)
        {
            return false;
        }

        if (root == tobeSearched)
        {
            return true;
        }

        return covers(root.left, tobeSearched) || covers(root.right, tobeSearched);
    }

    public Node findCommonAncestorTraversingOnce(Node root, Node p, Node q)
    {

        if (root == null)
        {
            return null;
        }

        if (root == p && root == q)
        {
            return root;
        }

        Node x = findCommonAncestorTraversingOnce(root.left, p,q);

        if(x!=null) {

        }
        return null;
    }

    public static class CreateBinarySearchTree
    {

        private TreeNode root;

        public CreateBinarySearchTree()
        {
        }

        /**
         * Will create a BST imperative on order of elements in the array
         */
        public CreateBinarySearchTree(int[] a)
        {
            this();
            for (int i : a)
            {
                add(i);
            }
        }

        private class TreeNode
        {
            TreeNode left;
            int item;
            TreeNode right;

            TreeNode(TreeNode left, int item, TreeNode right)
            {
                this.left = left;
                this.right = right;
                this.item = item;
            }
        }

        public void add(int item)
        {
            if (root == null)
            {
                root = new TreeNode(null, item, null);
                return;
            }

            TreeNode node = root;
            while (true)
            {
                if (item < node.item)
                {
                    if (node.left == null)
                    {
                        node.left = new TreeNode(null, item, null);
                        break;
                    }
                    node = node.left;
                }
                else
                {
                    if (node.right == null)
                    {
                        node.right = new TreeNode(null, item, null);
                        break;
                    }
                    node = node.right;
                }
            }
        }
    }

    public class Node
    {
        int data;
        Node right;
        Node left;

        public Node(int data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
