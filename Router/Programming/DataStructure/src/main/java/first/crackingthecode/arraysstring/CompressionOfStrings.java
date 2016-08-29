package first.crackingthecode.arraysstring;

/**
 * Compress strings.
 * @author Ritesh Dalvi (RD026600)
 */
public class CompressionOfStrings
{

    public static void main(String args[])
    {

        String s1 = "aabcccccaa";
        String compression = compression(s1);
        System.out.println(compression);
    }

    public static String compression(String s1)
    {

        char[] chars = s1.toCharArray();
        char[] newChar = new char[s1.length()];
        int sum[] = new int[256];

        for (int i = 0; i < s1.length(); i++)
        {

            sum[chars[i]] = sum[chars[i]] + 1;

            if (i + 1 != s1.length())
            {
                if (chars[i] != chars[i + 1] && sum[chars[i]] > 1)
                {
                    newChar[i] = Integer.toString(sum[chars[i]]).charAt(0);
                    sum[chars[i]] = 0;
                }
                else
                {
                    newChar[i] = chars[i];
                }
            } else {

                if(chars[i] == chars[i-1]) {
                    newChar[i] = Integer.toString(sum[chars[i]]).charAt(0);
                    sum[chars[i]] = 0;
                }
            }
        }

        if (newChar.length > chars.length)
        {
            return s1;
        }
        else
        {
            return String.valueOf(newChar);
        }
    }
}
