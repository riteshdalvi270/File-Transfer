package second.crackingcode.dynamicprogramming;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class ChildRunningUpTheStairs
{

    public int childRun(int n,int a[]) {

        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(a[n] > -1) {
            return a[n];
        }

        a[n] = childRun(n-1,a) +childRun(n-2,a) +childRun(n-3,a);

        return a[n];
    }
}
