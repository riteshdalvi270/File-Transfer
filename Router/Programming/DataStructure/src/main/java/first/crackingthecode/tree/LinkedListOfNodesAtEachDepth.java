package first.crackingthecode.tree;

import java.util.LinkedList;

/**
 * Create binary tree algorithm which creates linked list of all the nodes at each depth
 * @author Ritesh Dalvi (RD026600)
 */

// This is my solution. Refer to cracking code please

public class LinkedListOfNodesAtEachDepth {
    public static void main(String args[]) {

        int[] sortedArray = {45,56,67,87,98,101, 102};

        LinkedListOfNodesAtEachDepthProblem problem = new LinkedListOfNodesAtEachDepthProblem();
        TreeNode root = problem.binarySearchTree(sortedArray,0,sortedArray.length-1);
        LinkedList<TreeNode> linkedListOfNodes = new LinkedList<TreeNode>();
        problem.createLinkedListOfNodes(root,linkedListOfNodes);
    }
}

class LinkedListOfNodesAtEachDepthProblem
{

    public TreeNode createLinkedListOfNodes(TreeNode root, LinkedList<TreeNode> linkedListOfNodes) {

        if(root == null) {
            return null;
        }

        TreeNode left,right;

        left  = createLinkedListOfNodes(root.left,linkedListOfNodes);
        right = createLinkedListOfNodes(root.right,linkedListOfNodes);

        if(left!= null) {
            linkedListOfNodes.add(left);
            System.out.println("left:"+left.value);
        }

        if(right!=null) {
            linkedListOfNodes.add(right);
            System.out.println("right:"+right.value);
        }

        return root;
    }

    public TreeNode binarySearchTree(int[] sortedArray, int start, int end) {

        if(end<start) {
            return null;
        }

        int middle = (start+end)/2;
        TreeNode node = new TreeNode(sortedArray[middle]);
        System.out.print("binary middle:"+node.value);
        node.left = binarySearchTree(sortedArray, start, middle - 1);
        node.right = binarySearchTree(sortedArray,middle+1,end);

        return node;
    }
}

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
