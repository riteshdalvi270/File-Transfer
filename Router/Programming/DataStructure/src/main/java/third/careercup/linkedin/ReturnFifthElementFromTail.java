package third.careercup.linkedin;

import assistant.LinkedList;
import assistant.LinkedListAssistant;

/**
 * Return 5th element from the end of the tail.
 * Created by ritesh on 1/14/16.
 */
public class ReturnFifthElementFromTail {

    public static void main(String args[]) {

        int[] data = new int[] {1,2,3,4,5,6,7,8,9,10,22,11};
        LinkedListAssistant linkedListAssistant = new LinkedListAssistant();
        LinkedList linkedList = linkedListAssistant.createLinkedList(data);

        System.out.println(return5thElement(linkedList));
    }

    public static int return5thElement(final LinkedList head) {

        LinkedList runner, element;
        element = head;
        runner = element.next.next.next.next.next;

        while(runner.next!=null) {

            element = element.next;
            runner = element.next.next.next.next.next;
        }

        return element.intData;
    }
}
