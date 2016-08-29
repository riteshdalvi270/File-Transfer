package first.crackingthecode.linkedlist;

/**
 * Remove duplicates from unsorted linked list
 * <p>
 *     eg FOLLOW UP
 * </p>
 * @author Ritesh Dalvi (RD026600)
 */
public class RemoveDuplicatesFromUnsortedLL
{
    //solution: if ascii value matches remove it.

    // Very expensive. See the approach mentioned in the cracking code.
    public void deleteDuplicates(Node n) {

        Node head = n;
        while(head.next!=null)
        {
            while (n.next != null)
            {
                int value = n.value;

                n = n.next;
                if (value == n.value)
                {
                    Node runner = head;

                    while (runner.next != n)
                    {
                        runner = runner.next;
                    }

                    runner.next = n.next;
                    n = runner.next;
                }
            }

            head = head.next;
            n = head;
        }
    }

/*    // Recursive?

    public Node deleteDuplicatesRecursively(Node n, int value) {

        if(n == null) {
            return null;
        }

        deleteDuplicate(n.next, n.value);
    }

    public Node deleteDuplicate(Node n, int value) {

        if(n.value == value) {
            n.duplicate = true;
            return n;
        }

        deleteDuplicate(n.next,value);
    }*/

    class Node {
        char value;
        Node next;
        boolean duplicate;
    }
}
