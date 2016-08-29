package second.crackingcode.stackqueues;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class MyQueue
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

    public void enqueue(int element)
    {

        if (stack1.top == null)
        {
            stack1.top = new Node(element);
            return;
        }

        Node newNode = new Node(element);
        newNode.next = stack1.top;
        stack1.top = newNode;
    }

    public int dequeue()
    {

        int data;
        if (stack1.top == null)
        {
            move(stack2, stack1);
            data = returnElement(stack2);
        }
        else
        {
            move(stack1, stack2);
            data = returnElement(stack1);
        }

        return  data;
    }

    public void move(Stack stack1, Stack stack2)
    {

        while (stack1.top != null)
        {

            if (stack2.top == null)
            {
                stack2.top = new Node(stack1.top.data);
            }
            else
            {
                Node newNode = new Node(stack1.top.data);
                newNode.next = stack2.top;
                stack2.top = newNode;
            }

            stack1.top = stack1.top.next;
        }
    }

    public int returnElement(Stack stack1) {
        int data = stack1.top.data;
        stack1.top = stack1.top.next;

        return data;
    }
}
