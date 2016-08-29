package first.careercup.microsoft;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class GenerateLowestNumberProblem
{
    public static void main(String args[]) {

        String a = "2200010300";
        int n = 4;
        System.out.println(generateLowestNumber(a,n));
    }

    public static String generateLowestNumber(String s, int n) {

        if(s == null) {
            return null;
        }

        if(s.isEmpty()) {
            return "";
        }

        final StringBuilder stringBuilder = new StringBuilder();

        char[] value = s.toCharArray();

        for(int i = 0; i<s.length(); i++) {

            if(n > 0)
            {
                if (i + 1 < s.length() && value[i] > value[i + 1])
                {
                    continue;
                }
                else if(i+1 <s.length() && value[i]<value[i+1])
                {
                    stringBuilder.append(value[i]);
                }

                n--;
            } else {
                break;
            }
        }

        return stringBuilder.toString();
    }
}
