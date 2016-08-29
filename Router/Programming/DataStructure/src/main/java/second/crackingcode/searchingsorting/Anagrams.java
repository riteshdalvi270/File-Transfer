package second.crackingcode.searchingsorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class Anagrams
{

    // Wrong.
    public void anagramsSort(String[] anagrams)
    {

        Collections.sort(Arrays.asList(anagrams), new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return 0;
            }
        });
    }
}
