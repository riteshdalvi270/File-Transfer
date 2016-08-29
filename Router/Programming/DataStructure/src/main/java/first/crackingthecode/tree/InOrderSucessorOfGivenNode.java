package first.crackingthecode.tree;

/**
 * Find next node (in-order successor of given node).
 * @author Ritesh Dalvi (RD026600)
 */
public class InOrderSucessorOfGivenNode
{
    // Smaller node but greater than its successor (in-order successor).

    public TreeNode inOrderSuccessor(TreeNode node) {

        TreeNode y;

        // Case1
        if(node.right != null) {

            // minimum
            if(node.right.left != null) {
                return node.right.left;
            }
        }

        y = node.parent;

        //Case 2
        while(y !=null && y.right == node) {
            node = y;
            y = y.parent;
        }

        return node;
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }
}
