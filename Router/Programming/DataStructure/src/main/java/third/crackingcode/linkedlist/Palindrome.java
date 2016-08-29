package third.crackingcode.linkedlist;

import assistant.LinkedList;
import assistant.LinkedListAssistant;

/**
 * Check if linked list is a palidrome
 * Created by ritesh on 12/17/15.
 */
public class Palindrome {

    public static void main(String args[]) {

        int[] data = new int[] {1,1,0,1,1,};

        System.out.println(palindrome(LinkedListAssistant.createLinkedList(data)));
    }

    public static boolean palindrome(final LinkedList node) {

        LinkedList head = node;
        LinkedList tail = node;

        while(tail.next!=null) {
            tail = tail.next;
        }

        while(head !=tail) {

            if(head.intData != tail.intData) {
                return false;
            }

            LinkedList runner = head;
            while(runner.next!=tail) {
                runner = runner.next;
            }

            tail = runner;
            head = head.next;
        }

        return true;
    }
}
