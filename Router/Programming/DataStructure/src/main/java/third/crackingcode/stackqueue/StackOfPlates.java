package third.crackingcode.stackqueue;

import assistant.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack of plates.
 * Created by ritesh on 12/30/15.
 */
public class StackOfPlates {

    public static void main(String args[]) {

        final SetOFStacks setOFStacks = new SetOFStacks();
        setOFStacks.push(45);
        setOFStacks.push(32);
        setOFStacks.push(22);
        setOFStacks.push(33);
        setOFStacks.push(24);

        setOFStacks.push(35);
        setOFStacks.push(26);
        setOFStacks.push(37);
        setOFStacks.push(21);
        setOFStacks.push(31);

        setOFStacks.push(26);
        setOFStacks.push(3232);
        setOFStacks.push(222);
        setOFStacks.push(324);
        setOFStacks.push(226);
        setOFStacks.pop();

        setOFStacks.pop(1);

        setOFStacks.stackCount();

    }
}

class SetOFStacks {

    List<Stack> setOfStacks = new ArrayList<>();
    int threshhold = 5;
    boolean firstStack = true;

    public void push(int data) {

        for (final Stack stack : setOfStacks) {

            firstStack = false;

            if (stack.count() > threshhold) {
                firstStack = true;
            } else {
                stack.push(data);
            }
        }

        if (firstStack) {

            Stack stack = new Stack();
            stack.push(data);
            setOfStacks.add(stack);
        }
    }

    public void pop() {

        for (final Stack stack : setOfStacks) {

            if (stack.peep() == 1) {
                try {

                    int value = stack.pop();
                    System.out.println(value);
                    break;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void pop(int index) {

        Stack stack = setOfStacks.get(index);

        if(stack.peep() == 1) {
            try {
                stack.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stackCount() {

        int counter = 1;

        for(final Stack stack : setOfStacks) {
            counter++;
        }

        System.out.print(counter);
    }
}
