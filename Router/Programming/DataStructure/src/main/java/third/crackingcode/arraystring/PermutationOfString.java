package third.crackingcode.arraystring;

/**
 * Write a method to decide if one is permutation of another.
 * Created by ritesh on 12/12/15.
 */
public class PermutationOfString {

    public static void main(String args[]) {
        String a = "asfas";
        String b = "mafas";

        System.out.println(permutation(a, b));
    }

    public static boolean permutation(String a, String b) {

        if(a.length() != b.length()) {
            return false;
        }

        int[] perm1 = new int[256];
        int[] perm2 = new int[256];

        for(int i=0; i<a.length(); i++) {

            perm1[a.charAt(i)] = perm1[a.charAt(i)] + 1;
            perm2[b.charAt(i)] = perm2[b.charAt(i)] +1;
        }

        for(int i = 0;i <a.length(); i++) {

            if(perm1[a.charAt(i)] != perm2[a.charAt(i)]) {
                return false;
            }

            if(perm1[b.charAt(i)] != perm2[b.charAt(i)]) {
                return false;
            }
        }

        return true;
    }
}
