package crackingcodefive.binary;

/**
 * Created by ritesh on 8/25/16.
 */
public class BinarySearchWithMinimalHeight {

    public static void main(String args[]) {

        int a[]= {3,5,6,8,10,11,13,14,16};

        buildTreeWithMinimalHeight(a, 0, a.length-1);
    }

    public static Tree buildTreeWithMinimalHeight(int[] array, int low, int high) {

        if(low>high) {
            return null;
        }
        int mid = (low + high)/2;

        int midValue = array[mid];

        final Tree node = new Tree(null,midValue,null);

        node.left = buildTreeWithMinimalHeight(array,low, mid-1);
        node.right = buildTreeWithMinimalHeight(array, mid+1, high);

        return node;
    }

    static class Tree {

        int data;
        Tree left;
        Tree right;

        Tree(Tree left, int data, Tree right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
