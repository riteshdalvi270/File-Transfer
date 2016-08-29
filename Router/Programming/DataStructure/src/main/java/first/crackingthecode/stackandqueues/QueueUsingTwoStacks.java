package first.crackingthecode.stackandqueues;

/**
 * Implement queue using two stacks.
 * @author Ritesh Dalvi (RD026600)
 */
public class QueueUsingTwoStacks
{
        Stack s1 = new Stack();
        Stack s2 = new Stack();

    public void enqueue(int value)
    {
        if(s2.top == null)
        {
            s2.top.value = value;
            s2.top.next = null;
        } else
        {
            Node node = new Node();
            node.value = value;
            node.next = s2.top;
            s2.top = node;
        }
    }

    public int dequeue()
    {
        int value = 0;
        if(s1.top == null)
        {
            while (s2.top != null)
            {
                Node node = new Node();
                node.value = s2.top.value;
                node.next = s1.top;
                s1.top = node;
            }

            value = s1.top.value;
            s1.top = s1.top.next;
        } else {
            while (s1.top != null)
            {
                Node node = new Node();
                node.value = s1.top.value;
                node.next = s2.top;
                s2.top = node;
            }

            value = s2.top.value;
            s2.top = s2.top.next;
        }

        return value;
    }

    class Stack
    {
        Node top = null;
    }

    class Node
    {
        int value;
        Node next;
    }

}
