package second.crackingcode.stackqueues;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class ReturnMinElement
{
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node() {

        }
    }

    public class Stack {
        Node top = null;
        Node min = null;

        public void push(int element) {

            if(min == null) {
                min = new Node(element);
                min.next = null;
            } else if(min.data > element) {
                Node newMin = new Node(element);
                newMin.next = min;
                min = newMin;
            }

            if(top == null) {
                top = new Node(element);
                top.next = null;

                return;
            }

            Node newNode = new Node(element);
            newNode.next = top;
            top = newNode;
        }

        public int pop() {

            if(top == null) {
                return -1;
            }

            int data = top.data;
            top = top.next;

            if(data == min.data) {
                min = min.next;
            }

            return data;
        }

        public int minElement() {
            return min.data;
        }
    }
}
