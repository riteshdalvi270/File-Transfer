package first.crackingthecode.linkedlist;

/**
 * Determine circular link list.
 * @author Ritesh Dalvi (RD026600)
 */
public class CircularLinkList
{
    public Node determineCircularLinkList(Node head) {

        Node current = head;
        char asciiValue;

        while(current!=null) {
            asciiValue = current.value;

            Node runner = current.next;
            while(runner!=null) {

                if(asciiValue == runner.value) {
                    return runner;
                }

                runner = runner.next;
            }

            current = current.next;
        }

        return null;
    }

    // fast runner and slow runner technique.
    public Node determineCircular(Node head) {

     Node slowRunner = head;
     Node fastRunner = head;

        while(slowRunner!=null && fastRunner!=null && slowRunner.next!=fastRunner) {

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        if(slowRunner.next.value == fastRunner.value) {
            return fastRunner;
        }

        return null;
    }

    class Node {
        char value;
        Node next;
    }
}
