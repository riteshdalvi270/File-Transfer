package third.crackingcode.binarytree;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * Create a binary search tree with minimal height.
 * Created by ritesh on 12/20/15.
 */
public class BinarySearchTreeWithMinimalHeight {

    public static void main(String args[]) {

        int[] sortedArray = new int[]{3, 4, 6, 7, 8, 9};

        TreeAssistant treeAssistant = new TreeAssistant();

        treeAssistant.printTree(createBinarySearchTreeWithMinimalHeight(sortedArray));
    }

    /**
     * Iterative approach. Not an efficient solution.
     * @param sortedArray
     * @return
     */
    public static Tree createBinarySearchTreeWithMinimalHeight(final int[] sortedArray) {


        int middleIndex = (0 + sortedArray.length) / 2;
        int middleElement = sortedArray[middleIndex];

        Tree root = new Tree(middleElement);
        Tree runner = root;

        boolean isleft = false, isright=false;

        int i = 0;
        while (i < sortedArray.length) {

            if(sortedArray[i] == runner.getData()) {
                i++;
                continue;
            }

            while (sortedArray[i] < runner.getData()) {

                isleft = true;
                if(runner.left!=null) {
                    runner = runner.left;
                } else {
                    break;
                }
            }

            while (sortedArray[i] > runner.getData()) {

                isright = true;
                if(runner.right!=null) {
                    runner = runner.right;
                } else {
                    break;
                }
            }

            if(isright) {
                Tree newElement = new Tree(sortedArray[i]);
                runner.right = newElement;
            }else if(isleft) {
                Tree newElement = new Tree(sortedArray[i]);
                runner.left = newElement;
            }

            runner = root;

            i++;
        }

        return root;
    }


    /**
     * Recursive approach. Efficient solution.
     * @param data
     * @return
     */
    public Tree createBinarySearchTreeRecursive(int[] data) {
        return null;
    }
}
