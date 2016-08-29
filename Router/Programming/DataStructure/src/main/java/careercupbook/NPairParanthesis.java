package careercupbook;

/**
 * Print all valid combination of n pair paranthesis.
 * Created by ritesh on 1/30/16.
 */
public class NPairParanthesis {

    public static void main(String args[]) {

        int number = 3;

        final char[] str = new char[number*2];
        npairParatheses(0,number,0,0,str);
    }

    public static void npairParatheses(int pos,int count,int open, int close,char[] str) {

        if(close  == count) {
            System.out.println(String.valueOf(str));
            return;
        }

        if(open > close) {

            str[pos] = '}';
            npairParatheses(pos+1,count,open,close+1,str);
        }

        if(open < count) {

            str[pos] = '{';
            npairParatheses(pos+1,count,open+1,close,str);
        }
    }

}
