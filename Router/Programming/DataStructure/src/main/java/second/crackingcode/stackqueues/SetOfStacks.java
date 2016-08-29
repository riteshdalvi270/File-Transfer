package second.crackingcode.stackqueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class SetOfStacks
{
    int threshhold = 100;
    ArrayList<Stack> stacks = new ArrayList();

    // counter to determine the last stackqueue in the list of stacks.
    int index = 0;

    public void push(int element)
    {
        Stack stack = getLastStack();

        if (!stack.isEmpty())
        {

            if (stack.size() > threshhold)
            {
                index++;
                Stack newStack = new Stack();
                newStack.push(element);
                stacks.add(newStack);

                return;
            }
        }
        stack.push(element);
    }

    public void pop()
    {
        Stack stack = getLastStack();

        if(stack.isEmpty()) {
            stacks.remove(index);
            index--;
        }

        stack = stacks.get(index);

        stack.pop();
    }

    public Stack getLastStack()
    {
        return stacks.get(index);
    }
}
