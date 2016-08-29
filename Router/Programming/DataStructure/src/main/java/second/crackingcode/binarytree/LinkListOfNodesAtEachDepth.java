package second.crackingcode.binarytree;

import java.util.LinkedList;
import java.util.Map;

/**
 * Link list of nodes at each depth.
 * @author Ritesh Dalvi (RD026600)
 */
public class LinkListOfNodesAtEachDepth
{

    public Node LinkedListOfNodes(Node root, Map<Integer, LinkedList<Node>> mapOfLinkedList, int level)
    {

        if(root == null) {
            return null;
        }

        final LinkedList<Node> linkedListOfNodes = new LinkedList();
        level = level+1;

        linkedListOfNodes.add(LinkedListOfNodes(root.left, mapOfLinkedList, level));
        linkedListOfNodes.add(LinkedListOfNodes(root.right,mapOfLinkedList,level));

        mapOfLinkedList.put(level,linkedListOfNodes);

        return root;
    }

    public class Node
    {
        int data;
        Node left;
        Node right;
    }
}
