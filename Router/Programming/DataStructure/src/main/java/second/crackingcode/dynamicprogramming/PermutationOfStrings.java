package second.crackingcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class PermutationOfStrings
{

    public List<String> permutationOfStrings(String s,List<String> permutation) {

        if(s.length() == 0) {
            return new ArrayList();
        }

        if(s.equals("")) {
            permutation.add("");
        }

        char firstChar = s.charAt(0);
        String remainder = s.substring(1);
        permutation = permutationOfStrings(remainder, permutation);

        for(String perm : permutation) {

            for(int i = 0; i< perm.length(); i++) {

                permutation.add(joinStrings(i, perm, firstChar));
            }
        }

        return permutation;
    }

    public String joinStrings(int i, String perm, char firstChar) {
        String value = perm.substring(i);
        String remaining = perm.substring(i,perm.length());

        return value+firstChar+remaining;
    }
}
