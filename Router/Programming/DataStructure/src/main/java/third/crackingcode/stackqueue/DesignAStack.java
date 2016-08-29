package third.crackingcode.stackqueue;

import assistant.Stack;

/**
 * Design a stackqueue in addition to push and pop, it also has a function min.
 * Created by ritesh on 12/29/15.
 */
public class DesignAStack {

    public static void main(String args[]) {

        final Stack stack = new Stack();
        designAStack(stack);
    }

    public static void designAStack(final Stack stack) {

        //push
        stack.push(45);
        stack.push(11);
        stack.push(32);
        stack.push(21);
        stack.push(4);


        //pop
        try {
            stack.pop();
            stack.pop();
            stack.push(43);
            stack.push(11);
            stack.push(3);
            stack.push(89);
            stack.push(2);
            stack.push(1);
            stack.push(4232);
        } catch (Exception e) {
            e.printStackTrace();
        }

        stack.min();
    }
}
