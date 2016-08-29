package third.careercup.linkedin;

/**
 * Edit distance problem.
 * Created by ritesh on 1/16/16.
 */
public class EditDistance {

    public static void main(String args[]) {

        final String input1 = "geek";
        final String input2 = "gesek";

       // System.out.println(editdistance(input1, input2).toString());

        final String input3 = "cat";
        final String input4 = "cut";

        //System.out.println(editdistance(input3, input4).toString());

        final String input5 = "sunday";
        final String input6 = "saturday";

        final Edit editdistance = editdistance(input5, input6);

        System.out.println("String:" + editdistance.stringBuffer +"distance:"+editdistance.distance);


        System.out.println(editDist(input5.toCharArray(),input6.toCharArray(),input5.length(),input6.length()));
    }


    //Iterative (not 100% accurate)
    public static Edit editdistance(final String input1, final String input2) {

        char[] charInput1 = input1.toCharArray();
        char[] charInput2 = input2.toCharArray();

        int length = charInput1.length > charInput2.length ? charInput1.length : charInput2.length;

        final StringBuffer stringBuffer = new StringBuffer();
        int counter = 0;

        int i,j;
        for (i = charInput1.length-1, j = charInput2.length-1; i >= 0; i--, j--) {

            if(i < 0 || j < 0) {
                continue;
            }

            if (charInput1[i] != charInput2[j]) {

                if(i-1 <0 || j-1<0) {
                    break;
                }

                if (charInput2[j - 1] != charInput1[i - 1]) {
                    stringBuffer.append(charInput2[j]);
                    stringBuffer.append(charInput1[i]);
                    counter++;
                    j=i;
                }else {
                    stringBuffer.append(charInput2[j]);
                    counter++;
                }
            }else {
                stringBuffer.append(charInput1[i]);
            }
        }

        if(i-1<0) {

            while(j >= 0) {
                stringBuffer.append(charInput2[j]);
                counter++;
                j--;
            }
        }else {
            while(i >= 0) {
                stringBuffer.append(charInput1[i]);
                counter++;
                i--;
            }
        }

        Edit editDistance = new Edit(stringBuffer.reverse(),counter);

        return editDistance;
    }

    public static int editDist(char[] str1 , char[] str2 , int m ,int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1[m-1] == str2[n-1])
            return editDist(str1, str2, m-1, n-1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min ( editDist(str1,  str2, m, n-1),    // Insert
                editDist(str1,  str2, m-1, n),   // Remove
                editDist(str1,  str2, m-1, n-1) // Replace
        );
    }

    // Utility function to find minimum of three numbers
    public static int min(int x, int y, int z)
    {
        return Math.min(Math.min(x, y), z);
    }
}

class Edit {
    StringBuffer stringBuffer;
    int distance = 0;

    public Edit(final StringBuffer stringBuffer, final int distance) {
        this.stringBuffer = stringBuffer;
        this.distance = distance;
    }
}
