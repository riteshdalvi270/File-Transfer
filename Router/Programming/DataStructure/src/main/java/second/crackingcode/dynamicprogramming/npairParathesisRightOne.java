package second.crackingcode.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class npairParathesisRightOne
{

    public Set<String> npairParathesis(int n) {

        Set<String> hashSet = new HashSet();

        if(n ==  0) {
            hashSet.add("");
            return hashSet;
        }

        hashSet = npairParathesis(n-1);

        for(String s : hashSet) {

            for(int i = 0; i<s.length();i++) {

                if(s.charAt(i) == '(') {
                    insertBrackets(s,i);
                }
            }

            hashSet.add("()"+s);
        }

        return hashSet;
    }

    public String insertBrackets(String s, int i) {
        String firstChar = s.substring(0,i+1);
        final String remainingString = s.substring(i+1,s.length());

        return firstChar + "()" +remainingString;
    }
}
