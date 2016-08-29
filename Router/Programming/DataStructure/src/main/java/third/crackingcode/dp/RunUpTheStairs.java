package third.crackingcode.dp;

/**
 * Created by ritesh on 1/5/16.
 */
public class RunUpTheStairs {

    public static void main(String args[]) {

        int n = 11;
        System.out.println(runUpTheStairs(n));
    }

    public static int runUpTheStairs(int n) {

        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        return runUpTheStairs(n-1)+runUpTheStairs(n-2)+runUpTheStairs(n-3);
    }
}
