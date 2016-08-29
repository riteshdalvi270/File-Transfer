package assistant;

/**
 * Created by ritesh on 12/19/15.
 */
public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("TreeNode",data);
    }
}
