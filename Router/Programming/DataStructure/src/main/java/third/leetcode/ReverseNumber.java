package third.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ritesh on 1/31/16.
 */
public class ReverseNumber {

    public static void main(String args[]) {

        int x = 123;

        System.out.println(reverse(x));

        int x1 = -123;

        System.out.println(reverse(x1));
    }

    public static int reverse(int x) {

        if(x == 0) {
            return x;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean flag = false;

        if(x<0) {
            flag = true;
            x = 0-x;
        }

        while(x>0) {
            int remainder = x%10;
            x = x/10;
            queue.add(remainder);
        }

        final StringBuffer stringBuffer = new StringBuffer();
        while(!queue.isEmpty()) {
            stringBuffer.append(String.valueOf(queue.remove()));
        }

        int result = Integer.parseInt(stringBuffer.toString());

        if(flag) {
            result = 0-result;
        }

        return result;
    }
}
