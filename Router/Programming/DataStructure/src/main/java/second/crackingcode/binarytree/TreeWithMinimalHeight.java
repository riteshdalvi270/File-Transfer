package second.crackingcode.binarytree;

/**
 * Create tree with minimal height.
 * @author Ritesh Dalvi (RD026600)
 */
public class TreeWithMinimalHeight
{

    public Node createTreeWithMinimalHeight(int[] a, int left, int right) {

        int low= left;
        int high=right;

        int middle = (low+high)/2;

        Node rootNode = new Node(middle,null, null);

        Node leftNode = createTreeWithMinimalHeight(a,left,middle-1);
        Node rightNode = createTreeWithMinimalHeight(a,middle+1,right);

        rootNode.left = leftNode;
        rootNode.right = rightNode;

        return rootNode;
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
