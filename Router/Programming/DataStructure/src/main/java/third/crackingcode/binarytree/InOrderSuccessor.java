package third.crackingcode.binarytree;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * Created by ritesh on 1/2/16.
 */
public class InOrderSuccessor {

    public static void main(String args[]) {


    }
}

class FindSuccessor {

    public void createBinaryTree(final TreeAssistant treeAssistant, int data, int left, int right) {

        treeAssistant.createBinaryTree(data,left,right);
    }

    public Tree inorderSucessor(Tree node) {

        if(node.right!=null) {
            node = findTreeMinimum(node.right);
        }

        Tree y = node.parent;

        while(node!=null && node == y.right) {

            node = y;
            y = y.parent;
        }

        return y;
    }

    public Tree findTreeMinimum( Tree node) {

        while(node.left!=null) {
            node = node.left;
        }

        return node;
    }
}
