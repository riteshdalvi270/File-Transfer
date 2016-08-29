package first.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palidrome substring.
 * Created by ritesh on 10/3/15.
 */
public class PalidromeSubstring {

    public static void main(String args[]) {

        final String s = "abdadcnursemadam";

        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(final String s) {

        final char[] charArray = s.toCharArray();
        boolean visited[] = new boolean[128];

        final Map<String, String> palindromeByChar = new HashMap<String, String>();


        for (int i = 0; i < charArray.length; i++) {

            visited[charArray[i]] = true;
            for (int j = i + 1; j < charArray.length; j++) {

                if (visited[charArray[j]]) {

                    String palindrome = determineIfPalindrome(i, j, s);
                    if( palindrome != null) {
                        palindromeByChar.put(String.valueOf(charArray[i]),palindrome);
                    }

                    break;
                }
            }

            visited[charArray[i]] = false;
        }

        int max = 0;
        String maxPlindrome = "";

        for(String value : palindromeByChar.values()) {

            if(value.length() > max) {
                maxPlindrome = value;
            }
        }

        return maxPlindrome;
    }

    public static String determineIfPalindrome(int i, int j, String s) {

        String substring = s.substring(i, j+1);

        char[] chars = substring.toCharArray();

        int a = 0;
        int b = chars.length-1;

        while(a < b) {

            if(chars[a] != chars[b]) {
                return null;
            }

            a++;
            b--;
        }

        return substring;
    }
}
