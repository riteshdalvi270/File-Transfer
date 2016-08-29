package first.crackingthecode.searchingAndSorting;

/**
 * Sort an array of strings so that all anagrams (cinema is anagram for iceman) are next to each other.
 * @author Ritesh Dalvi (RD026600)
 */
public class Anagrams
{
    // There can be two approach
    // 1. sort it in place: (not sure how).
    // 2. Use three arrays. first array is the given array of strings, second will store ascii value wrt to the index of original array. Third will
    // contain the sorted value.

    // Its an anagram when number of characters is the same and ascii value matches.

    // This is not a good approach. refer to cracking code.
    public void sortStringsOFAnagrams(String[] anagrams, String helper[], int low, int high)
    {

        if (low < high)
        {
            return;
        }

        int middle = (high + low) / 2;

        sortStringsOFAnagrams(anagrams, helper, low, middle);
        sortStringsOFAnagrams(anagrams, helper, middle + 1, high);

        merge(anagrams, helper, low, middle, high);
    }

    public void merge(String[] anagrams, String[] helper, int low, int middle, int high)
    {
        // save the sub array in helper array to compare.
        for(int i= low; i<=high; i++) {
            helper[i] = anagrams[i];
        }

        int leftHelper = low;
        int rightHelper = middle+1;
        int current = low;

        // Ascii array to store ascii values.
        int[] AsciiHelper = {};

        while(leftHelper< middle && rightHelper<high) {

            int Leftsum = 0;
            int rightsum = 0;

            String leftValue = helper[leftHelper];
            char[] leftChars = leftValue.toCharArray();

            // Calculate the sum of ascii values.
            for(char leftChar : leftChars) {
                Leftsum = Leftsum +leftChar;
            }

            // Store the value in the asci array.
            AsciiHelper[leftHelper] = Leftsum;

            String rightValue = helper[rightHelper];
            char[] rightChars = rightValue.toCharArray();

            // Calculate the sum of ascii value of right subarray
            for(char rightChar : rightChars) {
                rightsum = rightsum +rightChar;
            }

            AsciiHelper[rightHelper] = rightsum;

            // Compare the ascci value and sort the array. The ascii value will be same and the length of string will be the same.
            if(AsciiHelper[leftHelper] ==  AsciiHelper[rightHelper] && helper[leftHelper].length() == helper[rightHelper].length()) {
                anagrams[current] = helper[leftHelper];
                current++;
                leftHelper++;
                anagrams[current] = helper[rightHelper];
                current++;
                rightHelper++;
            }else {
                anagrams[current] = helper[rightHelper];
                rightHelper++;
                current++;
            }
        }

        // Copy over the left elements.
        while(leftHelper<middle) {
           anagrams[current] = helper[leftHelper];
        }
    }

}
