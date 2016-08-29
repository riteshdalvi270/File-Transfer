package second.crackingcode.dynamicprogramming;

import java.util.List;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class SubsetOfASet
{
    public List<String> createSubsetOfSet(String s, List<String> permutation) {

        if(s == null) {
            return null;
        }

        if(s.equals("")){
            permutation.add("");
            return permutation;
        }

        char firstCHar = s.charAt(0);
        String remainder = s.substring(1);
        permutation = createSubsetOfSet(remainder,permutation);

        for(String perm : permutation) {
            for(int i =0;i< perm.length();i++) {
                // join
                permutation.add(joinString(i, firstCHar, perm));
            }
        }

        permutation.add(String.valueOf(firstCHar));

        return permutation;
    }

    public String joinString(int i, char firstChar,String perm) {
        return null;
    }
}
