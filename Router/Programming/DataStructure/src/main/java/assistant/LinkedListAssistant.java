package assistant;

/**
 * Created by ritesh on 12/16/15.
 */
public class LinkedListAssistant {

   public static LinkedList createLinkedList(final String stringValue) {

       LinkedList head = null;
       LinkedList node = null;


       for(int i = 0; i< stringValue.length(); i++) {

           if(head == null) {
               head = new LinkedList();
               head.charData = stringValue.charAt(i);
               head.next = null;
               node = head;
           }else {
               LinkedList temp = new LinkedList();
               temp.charData = stringValue.charAt(i);
               temp.next = null;
               node.next = temp;
               node = temp;
           }
       }

       return head;
   }

    public static LinkedList createLinkedList(final int value[]) {

        LinkedList head = null;
        LinkedList node = null;


        for(int i = 0; i< value.length; i++) {

            if(head == null) {
                head = new LinkedList();
                head.intData = value[i];
                head.next = null;
                node = head;
            }else {
                LinkedList temp = new LinkedList();
                temp.intData = value[i];
                temp.next = null;
                node.next = temp;
                node = temp;
            }
        }

        return head;
    }

    public static void printLinkedList(LinkedList linkedList) {

        LinkedList temp = linkedList;
        while(temp.next!=null) {
            System.out.print(temp.charData);
            temp = temp.next;
        }
        System.out.print(temp.charData);
    }

    public static void printIntLinkedList(LinkedList linkedList) {

        LinkedList temp = linkedList;
        while(temp.next!=null) {
            System.out.print(temp.intData);
            temp = temp.next;
        }
        System.out.print(temp.intData);
    }
}
