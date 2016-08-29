package first.crackingthecode.tree;

/**
 * Given sorted array with unique integers, create binary serach tree with minimal height.
 * @author Ritesh Dalvi (RD026600)
 */
public class SortedArrayCreateBinarySearchTreeWithRecursion
{
    //sorted array, 45,56,67,87,98,101, 102.
    int[] sortedArray = {45,56,67,87,98,101, 102};

    public Tree binarySearchTree(int[] sortedArray, int start, int end) {

        if(end<start) {
            return null;
        }

        int middle = (start+end)/2;
        Tree node = new Tree(sortedArray[middle]);

        node.left = binarySearchTree(sortedArray,start+1,middle);
        node.right = binarySearchTree(sortedArray,middle,end-1);

        return node;
    }

    public class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value) {
            this.value = value;
            left=null;
            right=null;
        }
    }
}
