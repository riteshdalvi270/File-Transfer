package second.crackingcode.stackqueues;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class OneArrayImplementThreeStacks
{
    int STACK_SIZE = 100;
    int buffer[] = new int[3*100];
    int[] stackPointer = {-1,-1,-1};

    public void push(int element, int numberOfStack) {

        if(stackPointer[numberOfStack] == -1) {
            int top = stackPointer[numberOfStack];
            stackPointer[numberOfStack] = top++;
            buffer[top] = element;
            return;
        }

        if(stackPointer[numberOfStack] > STACK_SIZE) {
            numberOfStack = numberOfStack+1;
            push(element,numberOfStack);
        }
    }


    public int pop(int stackNumber) {

        if(stackPointer[stackNumber] == -1) {
            return -1;
        }

        int top = stackPointer[stackNumber];
        int element = buffer[top];
        stackPointer[stackNumber] = top--;

        return element;
    }

}
