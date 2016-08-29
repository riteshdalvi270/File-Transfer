package second.crackingcode.stackqueues;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class SortStack
{
    public class Node
    {
        int data;
        Node next;

        public Node(int element)
        {
            this.data = element;
        }
    }

    public class Stack
    {
        Node top;

        public Stack(int element)
        {
            top.data = element;
            top.next = null;
        }

        public Stack()
        {

        }
    }

    Stack stack1 = new Stack();
    Stack stack2 = new Stack();
    int MAX = 0;

    public void push(int element) {

        if(stack1.top == null) {
            stack1.top = new Node(element);
            stack1.top.next = null;
            MAX = element;
        } else {
            while(element < MAX){

                if(stack2.top == null) {
                    stack2.top = new Node(stack1.top.data);
                    stack2.top.next = null;
                    stack1.top = stack1.top.next;
                    MAX = stack1.top.data;
                } else {
                    Node newNode = new Node(stack1.top.data);
                    newNode.next = stack2.top;
                    stack2.top = newNode;
                    stack1.top = stack1.top.next;
                    MAX = stack1.top.data;
                }
            }

            Node newNode = new Node(element);
            newNode.next = stack1.top;
            stack1.top = newNode;
        }

        pushElementsBack();
    }


    public void pushElementsBack() {

        while(stack2.top!=null) {

            if(stack1.top == null) {
                stack1.top = new Node(stack2.top.data);
                stack1.top.next = null;
                stack2.top = stack2.top.next;
            } else {

                Node newNode = new Node(stack2.top.data);
                newNode.next = stack1.top;
                stack1.top = newNode;
                stack2.top = stack2.top.next;
            }
        }
        MAX = stack1.top.data;
    }

    public int pop() throws Exception {

        if(stack1.top == null) {
            throw new Exception("No element found");
        }

        int data = stack1.top.data;
        stack1.top = stack1.top.next;
        MAX = stack1.top.data;

        return data;
    }


}
