package second.crackingcode.dynamicprogramming;

import java.util.List;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class NPairParanthesis
{

    //entirely wrong.Assumed the question entirely wrong. I assumed it as permuation of strings. (not entirly wrong)
    public List<String> npairParathesis(String s, List<String> permutation)
    {

        if (s == null)
        {
            return null;
        }

        if (s.equals(""))
        {
            permutation.add("");
            return permutation;
        }

        char firstChar = s.charAt(0);
        String remainder = s.substring(1);

        permutation = npairParathesis(remainder,permutation);

        for(String perm : permutation) {

            for(int i = 0; i<perm.length(); i++) {

                permutation.add(permuation(i,firstChar,perm));
            }
        }

        return permutation;
    }

    public String permuation(int i,char firstChar,String perm) {
        String start = perm.substring(0);
        String end = perm.substring(i,perm.length());

        return start + firstChar +end;
    }
}
