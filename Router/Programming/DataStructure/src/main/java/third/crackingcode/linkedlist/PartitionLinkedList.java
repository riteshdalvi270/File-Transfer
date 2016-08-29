package third.crackingcode.linkedlist;

import assistant.LinkedList;
import assistant.LinkedListAssistant;

/**
 * Partition a linkedlist around value x.
 * Created by ritesh on 12/17/15.
 */
public class PartitionLinkedList {

    public static void main(String args[]) {

        final int[] value = new int[]{0, 7, 8, 3, 2, 4, 9};

        int number = 3;

        try {
            LinkedListAssistant.printIntLinkedList(partitionNotInPlace(LinkedListAssistant.createLinkedList(value), number));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Wrong solution
    public static LinkedList partitionWrong(final LinkedList node, final int number) throws Exception {

        LinkedList head = node;
        LinkedList partitionNumber = head;
        LinkedList temp = partitionNumber;

        while (temp != null) {

            if (temp.intData == number) {
                break;
            }

            temp = temp.next;
        }

        if (temp == null) {
            throw new Exception("Number not found");
        }

        LinkedList tail = temp.next;

        while(tail.next!=null) {
            tail = tail.next;
        }

        LinkedList leftRunner = partitionNumber;
        LinkedList rightRunner = partitionNumber;

        while(leftRunner!=null) {

            if(leftRunner.intData > temp.intData) {

                if(leftRunner == head) {

                    LinkedList newNode = new LinkedList();
                    newNode.intData = head.intData;
                    newNode.next = null;

                    tail.next = newNode;
                }else {

                    LinkedList newNode = new LinkedList();
                    newNode.intData = leftRunner.intData;
                    newNode.next = head.next;
                    head.next = newNode;
                }
            }

            leftRunner = leftRunner.next;
        }

        while(rightRunner!=null) {

            if(rightRunner.intData < temp.intData) {

                if(rightRunner ==  tail) {

                    LinkedList newNode = new LinkedList();
                    newNode.intData = tail.intData;
                    newNode.next = head.next;
                    head.next = newNode;
                    tail = null;
                } else {


                }
            }
        }

        return head;
    }

    public static LinkedList partitionNotInPlace(final LinkedList linkedList, final int number) throws Exception {

        LinkedList head = linkedList;

        LinkedList runner = head;


        LinkedList temp = head;

        while (temp != null) {

            if (temp.intData == number) {
                break;
            }

            temp = temp.next;
        }

        if (temp == null) {
            throw new Exception("Number not found");
        }

        LinkedList leftHeadLinkedList = null;
        LinkedList leftPartition = null;
        LinkedList rightHeadLinkedList = null;
        LinkedList rightPartition = null;

        while(runner!=null) {

            if(runner.intData < temp.intData) {

                if(leftHeadLinkedList == null) {
                    leftHeadLinkedList = new LinkedList();
                    leftHeadLinkedList.intData = runner.intData;
                    leftHeadLinkedList.next = null;
                    leftPartition = leftHeadLinkedList;
                }else {
                    LinkedList tempLinkedList = new LinkedList();
                    tempLinkedList.intData = runner.intData;
                    tempLinkedList.next = null;
                    leftPartition.next = tempLinkedList;
                    leftPartition = tempLinkedList;
                }
            }

            if(runner.intData > temp.intData) {

                if(rightHeadLinkedList == null) {
                    rightHeadLinkedList = new LinkedList();
                    rightHeadLinkedList.intData = runner.intData;
                    rightHeadLinkedList.next = null;
                    rightPartition = rightHeadLinkedList;
                }else {
                    LinkedList tempLinkedList = new LinkedList();
                    tempLinkedList.intData = runner.intData;
                    tempLinkedList.next = null;
                    rightPartition.next = tempLinkedList;
                    rightPartition = tempLinkedList;
                }
            }

            runner = runner.next;
        }

        leftPartition.next = temp;
        temp.next = rightHeadLinkedList;

        return leftHeadLinkedList;
    }
}
