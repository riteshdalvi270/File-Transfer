package second.crackingcode.dynamicprogramming;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class Coins
{
    public int count(int[] S, int m, int n) {

        if(n == 0) {
            return 1;
        }

        if(m<=0 && n >1) {
            return 0;
        }

        // 1.Exclude. 2. Include.
        int sum = count(S,m-1,n) + count(S,m,n-S[m-1]);

        return sum;
    }
}
