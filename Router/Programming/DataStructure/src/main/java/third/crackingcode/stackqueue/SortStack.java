package third.crackingcode.stackqueue;

import assistant.Stack;

/**
 * Sort stack in ascending order.
 * Created by ritesh on 12/30/15.
 */
public class SortStack {

    public static void main(String args[]) {

        StackSorting stackSorting = new StackSorting();
        try {
            stackSorting.push(25);
            stackSorting.push(35);
            stackSorting.push(10);
            stackSorting.push(45);
            stackSorting.push(11);

            stackSorting.pop();
            stackSorting.pop();
            stackSorting.pop();
            stackSorting.pop();
            stackSorting.pop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class StackSorting {

    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public void push(int data) throws Exception {

        if(stack1.isEmpty()) {
            stack1.push(data);
        }else {
           sort(data);
        }
    }

    public void sort(int data) throws Exception {

        while(stack1.peek()!=-1 && data<stack1.peek()) {

            int value = stack1.pop();
            stack2.push(value);
        }

        stack1.push(data);
        stack1.pushAll(stack2);
    }

    public void pop() throws Exception {
        int value = stack1.pop();
        System.out.println(value);
    }
}
