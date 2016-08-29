package first.crackingthecode.linkedlist;

/**
 * Determine if linked list is palidrome. eg dad, pop.
 * @author Ritesh Dalvi (RD026600)
 */
public class LinkListIsPalidrome
{
    public void determineLinkListIsPalidrome(Node head, Node tail) {

        Node currentFromHead = head;
        Node currentFromTail = tail;

        while(currentFromHead!=null && currentFromTail!=null && currentFromHead!=currentFromTail) {

            if(currentFromHead.value == currentFromTail.value) {
                currentFromHead = currentFromHead.next;
                currentFromTail =currentFromTail.next;
            } else {
                System.out.print("Not a  plaidrome");
                System.exit(0);
            }
        }

        if(currentFromHead.value != currentFromTail.value) {
            System.out.print("Not a  plaidrome");
        }
    }

    //fast runner and slow runner techinque. save it on stackqueue. look at cracking code solution.
    public void determinePalidrome(Node head) {


    }

    class Node {
        char value;
        Node next;
    }
}
