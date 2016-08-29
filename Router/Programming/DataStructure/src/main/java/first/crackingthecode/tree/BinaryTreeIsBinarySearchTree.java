package first.crackingthecode.tree;

/**
 * Implement an algorithm to check if binary tree is binary search tree. Refer cracking code for beeter approach
 * @author Ritesh Dalvi (RD026600)
 */
public class BinaryTreeIsBinarySearchTree
{

    // this solution will not work in the case mentioned in solution 2 of cracking code for this problem.
    // Use a traversal technique and determine if left < middle < right. I will go with postorder. This is my approach. Please refer to cracking code for a better approach.
    public TreeNode determineBinarySearchTreeRecursive(TreeNode node) {

        if(node == null) {
            return null;
        }

        TreeNode left,right;
        left = determineBinarySearchTreeRecursive(node.left);
        right = determineBinarySearchTreeRecursive(node.right);

        if(left!=null) {
            if(left.value > node.value) {
                System.out.println("Its not a binary Tree");
            }
        }

        if(right!=null) {
            if(right.value < node.value) {
                System.out.println("Its not a binary Tree");
            }
        }

        return node;
    }


  /*  public boolean determineBinarySearchTreeNonRecursive(TreeNode root) {

        if(root == null) {
            return false;
        }


    }*/

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            left=null;
            right=null;
        }
    }
}
