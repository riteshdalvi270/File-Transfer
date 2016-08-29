package first.crackingthecode.stackandqueues;

/**
 * Push, pop and min should operate in O(1).
 * @author Ritesh Dalvi (RD026600)
 */
// My implementation.
public class DesignAStack
{
    int[] a;
    int top=0;
    int MIN = Integer.MIN_VALUE;

    public void push(int value) {

        if(value<MIN) {
            MIN = value;
        }

        a[top] = value;
        top++;
    }

    public int pop() {
        if(top==0) {
            return 0;
        }

        int value = a[top];
        top--;

        if(value<MIN) {
            MIN = value;
        }

        return value;
    }

    public int min() {
        return MIN;
    }
}
