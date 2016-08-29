package third.crackingcode.arraystring;

/**
 * Implement basic string compression.
 * Created by ritesh on 12/16/15.
 */
public class Compression {

    public static void main(String args[]) {

        final String uncompressedString = "aaabcccccaa";

        System.out.println(compressString(uncompressedString));
    }

    public static String compressString(final String uncompressedString) {

        StringBuffer stringBuffer = new StringBuffer();

        final char[] uncompressedCharArray = uncompressedString.toCharArray();

        int count = 1;

        for (int i = 0; i < uncompressedString.length(); i++) {

            if (i == uncompressedString.length() - 1 || uncompressedCharArray[i] != uncompressedCharArray[i + 1]) {
                stringBuffer.append(uncompressedCharArray[i]);
                stringBuffer.append(count);
                count = 1;
            } else {
                count++;
            }
        }

        if (stringBuffer.length() > uncompressedString.length()) {
            return uncompressedString;
        }

        return stringBuffer.toString();
    }
}
