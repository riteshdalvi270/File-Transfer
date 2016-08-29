package assistant;

import java.util.Date;

/**
 * Implementation of stackqueue using linked list.
 * Created by ritesh on 12/29/15.
 */
public class Stack {

    Node top = null;
    Node min = null;

    public Node getTop() {
        return top;
    }

    public void push(int data) {

        if (top == null) {
            top = new Node();
            top.data = data;
            top.next = null;

            min = new Node();
            min.data = data;
            min.next = null;

            return;
        }

        Node next = new Node();
        next.data = data;
        next.next = top;
        top = next;

        if(data < min.data) {
            Node newMin = new Node();
            newMin.data = data;
            newMin.next = min;
            min = newMin;
        }
    }

    public int peek() {

        if(!this.isEmpty()) {
            return this.top.data;
        }

        return -1;
    }

    public int pop() throws Exception {

        if(top == null) {
            throw new Exception("Stack overflow");
        }

        int data = top.data;
        Node n = top.next;
        top.next = null;
        top = n;

        if(data == min.data) {
            Node newMin = min.next;
            min.next = null;
            min = newMin;
        }

        return data;
    }

    public void pushAll(final Stack stack) throws Exception {

        while(!stack.isEmpty()) {
            int value = stack.pop();
            this.push(value);
        }
    }

    public int peep() {

        if(top == null) {
            return -1;
        }

        return 1;
    }

    public boolean isEmpty() {

        if(top == null) {
            return true;
        }

        return false;
    }

    public int count() {

        if(top == null) {
            return 0;
        }

        Node runner = top;
        int counter = 0;

        while(runner.next!=null) {
            counter++;
            runner = runner.next;
        }

        return counter;
    }

    public void min() {
        System.out.println(min.data);
    }
}

class Node {

    int data;
    Node next;
}
