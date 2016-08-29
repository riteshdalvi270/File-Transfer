package third.careercup.linkedin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ritesh on 1/11/16.
 */
public class Isomorphic {

    public static void main(String args[]) {

        final String input1 = "turtle";
        final String inout2 = "tletur";

        System.out.println(isIsomorphic(input1,inout2));

        final String input3 = "foo";
        final String inout4 = "app";

        System.out.println(isIsomorphic(input3,inout4));


        final String input5 = "ab";
        final String inout6 = "ca";

        System.out.println(isIsomorphic(input5,inout6));

        final String input7 = "bar";
        final String inout8 = "foo";

        System.out.println(isIsomorphic(input7,inout8));
    }

    public static boolean isIsomorphic(String input1, String input2) {

        final Map<Character, Character> isomorphic = new HashMap<>();

        if (input1.length() != input2.length()) {
            return false;
        }

        char[] charInput1 = input1.toCharArray();
        char[] charInput2 = input2.toCharArray();

        for (int i = 0; i < input1.length(); i++) {

            Character character = isomorphic.get(charInput1[i]);
            if (character == null) {

                if (isomorphic.containsValue(charInput2[i])) {

                    return false;
                }

                isomorphic.put(charInput1[i], charInput2[i]);
            } else {

                if (!character.equals(charInput2[i])) {

                    return false;
                }
            }
        }

        return true;
    }
}
