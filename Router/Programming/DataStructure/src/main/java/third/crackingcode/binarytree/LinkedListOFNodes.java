package third.crackingcode.binarytree;

import assistant.Tree;
import assistant.TreeAssistant;

import java.util.*;

/**
 * Given a binary tree, create linked list of nodes at each depth.
 * Created by ritesh on 12/21/15.
 */
public class LinkedListOFNodes {

    public static void main(String args[]) {


        int data[] = new int[]{3,4,6,7,8,9};

        TreeAssistant treeAssistant = new TreeAssistant();
        Tree root = treeAssistant.createBinarySearchTree(data,0,data.length-1);

        Map<Integer,List<java.util.LinkedList>> linkedListByDepth = new HashMap<>();

        createLinkedListAtEachDepth(root,0,linkedListByDepth);

        for(Map.Entry<Integer,List<LinkedList>> entrySet : linkedListByDepth.entrySet()) {
            Integer depth = entrySet.getKey();

            System.out.print("Depth:"+depth);

            ListIterator<LinkedList> linkedListListIterator = entrySet.getValue().listIterator();
            while(linkedListListIterator.hasNext()) {

                System.out.println(linkedListListIterator.next());
            }
        }
    }

    /**
     * Works fine.
     * @param node
     * @param depth
     * @param linkedListsByDepth
     */
    public static void createLinkedListAtEachDepth(Tree node, int depth,  Map<Integer,List<java.util.LinkedList>> linkedListsByDepth) {

        if(node == null) {
            return;
        }

        List<java.util.LinkedList> linkedLists = null;
        if(linkedListsByDepth.get(depth)!=null) {
            linkedLists = linkedListsByDepth.get(depth);
        }else {
            linkedLists = new ArrayList<>();
        }

        java.util.LinkedList linkedList = new java.util.LinkedList();
        linkedList.add(node.getData());

        linkedLists.add(linkedList);

        linkedListsByDepth.put(depth,linkedLists);

        createLinkedListAtEachDepth(node.left,depth+1,linkedListsByDepth);
        createLinkedListAtEachDepth(node.right,depth+1, linkedListsByDepth);
    }
}
