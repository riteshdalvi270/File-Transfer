package first.crackingthecode.tree;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class BalanceTreeWithRecursion
{

    public boolean checkBalancedTree(final TreeNode root){

        int height = determineHeight(root.left) - determineHeight(root.right);

        if(height > 1) {
            return false;
        } else {
            return checkBalancedTree(root.left) && checkBalancedTree(root.right);
        }
    }

    public int determineHeight(TreeNode node) {

        if(node == null) {
            return 0;
        }
            return Math.max(determineHeight(node.left), determineHeight(node.right)) +1;
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }
}
