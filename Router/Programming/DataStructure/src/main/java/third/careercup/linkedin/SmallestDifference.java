package third.careercup.linkedin;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * You have two arrays of integers, where the integers do not repeat and the two arrays have no common integers.

 Let x be any integer in the first array, y any integer in the second. Find min(Abs(x-y)). That is, find the smallest difference between any of the integers in the two arrays.

 Assumptions: Assume both arrays are sorted in ascending order.
 * Created by ritesh on 1/13/16.
 */
public class SmallestDifference {

    public static void main(String args[]) {

        int input1[] = new int[]{6, 7, 8, 9, 20};
        int input2[] = new int[]{11, 13, 15, 17, 18};

        TreeAssistant treeAssistant = new TreeAssistant();
        Tree root1 = treeAssistant.createBinarySearchTree(input1, 0, input1.length - 1);
        Tree root2 = treeAssistant.createBinarySearchTree(input2, 0, input2.length - 1);


        System.out.println(findSmallestDifference(root1, root2, Integer.MAX_VALUE));
    }

    public static int findSmallestDifference(Tree root1, Tree root2, int min) {

        if (root1 == null || root2 == null) {
            return min;
        }

        int temp = Math.abs(root1.data - root2.data);

        if (temp < min) {
            min = temp;
        }

        temp = Math.min(findSmallest(root1.left, root2, min), findSmallest(root1.right, root2, min));

        if (temp < min) {
            min = temp;
        }
        return Math.min(findSmallestDifference(root1, root2.left, min), findSmallestDifference(root1, root2.right, min));
    }

    public static int findSmallest(Tree root1, Tree root2, int min) {

        if (root1 == null || root2 == null) {
            return min;
        }

        int temp = Math.abs(root1.data - root2.data);

        if (temp < min) {
            min = temp;
        }

        return Math.min(findSmallest(root1.left, root2, min), findSmallest(root1.right, root2, min));
    }
}
