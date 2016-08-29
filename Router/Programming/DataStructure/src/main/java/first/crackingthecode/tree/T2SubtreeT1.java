package first.crackingthecode.tree;

/**
 * Determine if T2 is subtree of T1.
 * @author Ritesh Dalvi (RD026600)
 */
public class T2SubtreeT1
{
    // I peeked into the solution a little, but did a better job (need to focus more). Please refer to the approach in the book. This may have bug.
    public boolean binaryTree(TreeNode t1, TreeNode t2) {

        if(t2 == null) {
            return true;
        }

        return inOrder(t1,t2);
    }

    public boolean inOrder(TreeNode t1, TreeNode t2) {

        if(t1 == null) {
            return false;
        }

        if(t2 != null && t1 == t2)  {
            return matchTree(t1,t2);
        }

        return (inOrder(t1.left,t2) || inOrder(t1.right,t2));
    }

    public boolean matchTree(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null) {
            return true;
        }

        if(t1.value == t2.value) {
            return true;
        } else {
           return matchTree(t1.left,t2.left) && matchTree(t1.right,t2.left);
        }
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }
}
