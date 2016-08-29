package third.careercup.linkedin;

import assistant.Tree;
import assistant.TreeAssistant;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * Print every level in the tree in its own line.
 * Created by ritesh on 1/16/16.
 */
public class PrintLevelTree {

    public static void main(String args[]) {

        int data[] = {1,2,3,4,5,6};

        TreeAssistant treeAssistant = new TreeAssistant();
        Tree root = treeAssistant.createBinarySearchTree(data,0,data.length-1);

        treeAssistant.printTree(root);

        printLevelOfTree(root);
    }

    public static void printLevelOfTree(Tree root) {

        final Queue<Tree> queue = new ArrayDeque<>();

        queue.add(root);

        System.out.println();
        System.out.println(root.data);
        while (!queue.isEmpty()) {

            Tree element = queue.remove();

            if (element.left != null) {
                queue.add(element.left);
                System.out.print(element.left.data);
            }

            if (element.right != null) {
                queue.add(element.right);
                System.out.print(element.right.data);
            }

            System.out.println();
        }
    }
}
