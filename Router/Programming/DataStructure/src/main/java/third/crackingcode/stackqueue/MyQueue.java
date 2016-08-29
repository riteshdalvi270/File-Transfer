package third.crackingcode.stackqueue;

import assistant.Stack;

/**
 * Implement queue using two stacks.
 * Created by ritesh on 12/30/15.
 */
public class MyQueue {

    public static void main(String args[]) {

        Queue queue = new Queue();
        try {
            queue.enqueue(34);
            queue.enqueue(25);
            queue.enqueue(10);
            queue.enqueue(45);
            queue.enqueue(11);

            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Queue {

    final Stack stack1 = new Stack();
    final Stack stack2 = new Stack();

    public void enqueue(int data) throws Exception {

        if (stack1.isEmpty()) {

            if(stack2.isEmpty()) {
                stack1.push(data);
            }else {
                stack1.pushAll(stack2);
                stack1.push(data);
            }
        }

        stack2.pushAll(stack1);
    }

    public void dequeue() throws Exception {

        if(!stack2.isEmpty()) {
            int value = stack2.pop();
            System.out.println("Deque:"+value);
        } else {
            throw new Exception("Queue is empty");
        }
    }
}
