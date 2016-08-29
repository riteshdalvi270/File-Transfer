package first.crackingthecode.linkedlist;

import java.util.Stack;

/**
 * Refre to question 2.5
 * @author Ritesh Dalvi (RD026600)
 */
public class AddingNodesInTheLinkedList
{
    // This solution is dfferent that in cracking code, but will surely work.
    public Node addNodesInLinkedList(Node head1, Node head2) {

        if(head1 == null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }

        if(head1==null && head2 == null) {
            return null;
        }

        Node current1 = head1;
        Node current2 = head2;

        Node newList = new Node();

        Node headOfNewList = newList;

        final Stack<Integer> stack = new Stack();

        while(current1!=null && current2!=null) {
           int sum =  current1.value + current2.value;

            if(!stack.isEmpty()) {
                int stackValue = stack.pop();
                sum = sum+stackValue;
            }

            int value = (sum%10);
            int quotient = sum/10;

            if(quotient > 0)
            {
                stack.add(quotient);
            }

            if(newList == null) {
                newList.value = value;
                newList.next = null;
                continue;
            }

            final Node node = new Node();
            node.value = value;
            node.next = null;

            newList.next = node;
            newList = node;
        }

        return headOfNewList;
    }

    class Node {
        int value;
        Node next;
    }
}
