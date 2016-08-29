package first.crackingthecode.tree;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class BalanceBinaryTree
{
    // Bottom-up approach of recursion.
    public boolean isBalanced(TreeNode node) {

        if(checkHeight(node) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int checkHeight(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);

        if(leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1) {
            return -1;
        }

        int height = leftHeight - rightHeight;

        if(Math.abs(height) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

}
