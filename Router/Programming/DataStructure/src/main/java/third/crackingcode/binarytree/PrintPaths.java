package third.crackingcode.binarytree;

import assistant.Tree;
import assistant.TreeAssistant;

import java.util.LinkedList;

/**
 * Print paths which sum to a given value.
 * Created by ritesh on 1/3/16.
 */
public class PrintPaths {

    public static void main(String args[]) {


        final TreeAssistant treeAssistant = new TreeAssistant();
        Tree first = treeAssistant.createBinaryTree(5, 6, 18, null);
        Tree secondLeft = treeAssistant.createBinaryTree(6, 3, 7, first);
        Tree thirdRight = treeAssistant.createBinaryTree(18, 17, 20, first);

        Tree firstTree = treeAssistant.createBinaryTree(3, 2, 4, secondLeft);

        first.left.left = firstTree;

        Tree secondTree = treeAssistant.createBinaryTree(7, 13, 9, secondLeft);

        first.left.right = secondTree;

        Paths paths = new Paths();

        final LinkedList<Tree> pathsList = new LinkedList<>();
        paths.printPaths(first, 18,pathsList);
    }
}

class Paths {

    // Look in the book. not 100% accurate.
    public void printPaths(final Tree root, int sum, LinkedList<Tree> paths) {

        if(root == null) {
            return;
        }


        paths.add(root);

        if(root.getData() == sum) {
            printPaths(paths);
            return;
        }

        boolean left = covers(root.left, paths,sum,root.getData());

        if(left) {

            printPaths(paths);
            paths = new LinkedList<>();
            //print path;
            // empty the linked list for right;
        }

        boolean right = covers(root.right,paths,sum,root.getData());

        if(right) {
            printPaths(paths);
            //print path;
            //empty the linked list;
        }

        printPaths(root.left,sum, new LinkedList<>());
        printPaths(root.right,sum, new LinkedList<>());
    }

    public boolean covers(final Tree root, final LinkedList<Tree> paths, int sum, int pathSums) {

        if(root == null) {
            return false;
        }

        pathSums = root.getData() + pathSums;

        paths.add(root);

        if(pathSums == sum) {

            return true;
        }

        boolean isLeftPath = covers(root.left,paths,sum,pathSums);

        boolean isRightPath = covers(root.right, paths, sum, pathSums);

        if(!isLeftPath && !isRightPath) {
            paths.removeLast();
        }

        return isLeftPath || isRightPath;
    }

    public void printPaths(final LinkedList<Tree> paths) {
        for(final Tree path : paths) {

            System.out.println(path.getData());
        }
    }

}
