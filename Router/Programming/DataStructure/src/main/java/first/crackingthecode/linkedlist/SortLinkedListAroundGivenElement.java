package first.crackingthecode.linkedlist;

/**
 * Partition linked list around X.
 * @author Ritesh Dalvi (RD026600)
 */
public class SortLinkedListAroundGivenElement
{

    // This is my approach and it works fine. YAY.
    public void partitionLinkedList(Node head, int value) {

        Node current = head;

        Node before = null;
        Node beforeHead = null;

        Node after = null;
        Node afterHead = null;

        while(current!=null) {

            if(current.value <= value) {

                if(beforeHead ==  null) {
                    beforeHead = new Node(value,null);
                    continue;
                }

                if(before == null) {

                    before = new Node(value,null);
                    beforeHead.next = before;
                    continue;
                }

                final Node newBeforeNode = new Node(value,null);
                before.next = newBeforeNode;
                before = newBeforeNode;
            }

            if(current.value > value) {
                if(afterHead ==  null) {
                    afterHead = new Node(value,null);
                    continue;
                }

                if(after == null) {

                    after = new Node(value,null);
                    afterHead.next = before;
                    continue;
                }

                final Node afterNewNode = new Node(value,null);
                after.next = afterNewNode;
                after = afterNewNode;
            }


            // Merging two linked list
            before.next = afterHead;
        }
    }

    class Node {
        int value;
        Node next;

        public Node(int value,Node n) {
            this.value = value;
            this.next=n;
        }
    }
}
