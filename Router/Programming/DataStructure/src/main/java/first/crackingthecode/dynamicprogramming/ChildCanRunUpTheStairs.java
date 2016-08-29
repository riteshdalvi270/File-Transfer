package first.crackingthecode.dynamicprogramming;

/**
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count how many possible ways a child can run up the stairs.
 * @author Ritesh Dalvi (RD026600)
 */
public class ChildCanRunUpTheStairs
{
    public static void main(String args[]) {

        int n = 5;
        int cache[] = new int[n+1];
        int cache1[] = new int[]{-1,-1,-1,-1,-1,-1};

        int i = runUpTheStairs(n, cache);

        System.out.println(i);

        int i1 = countWaysDp(n, cache1);
        System.out.println(i1);
    }

    // my aaproach is wrong
    public static int runUpTheStairs(int n, int cache[]) {

        if(n==0) {
            return 0;
        }

        if(n==1) {
            return 1;
        }

        if(n==2) {
            return 2;
        }

        if(n==3) {
            return 3;
        }

        if(cache[n]!=0) {
            return cache[n];
        }

        cache[n] = runUpTheStairs(n-1,cache) + runUpTheStairs(n-2,cache) + runUpTheStairs(n-3,cache);

        return cache[n];
    }

    //cracking code approach
    public static int countWaysDp(int n, int[] cache) {

        if(n<0) {
            return 0;
        }else if(n==0) {
            return 1;
        } else if(cache[n] > -1) {
            return cache[n];
        } else {
            cache[n] = countWaysDp(n-1,cache) + countWaysDp(n-2,cache) + countWaysDp(n-3,cache);
            return cache[n];
        }
    }
}
