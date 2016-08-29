package third.careercup.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find minimum distance between two words.
 * Created by ritesh on 1/7/16.
 */
public class MinimumDistanceBTWWords {

    public static void main(String args[]) {

        final List<String> words = new ArrayList<>();
        words.add("the");
        words.add("quick");
        words.add("brown");
        words.add("fox");
        words.add("quick");

        System.out.println(new WordDistanceFinder(words).distance("the", "fox"));

        System.out.println(new WordDistanceFinder(words).distance("fox", "quick"));
    }
}

class WordDistanceFinder {

    final List<String> words;

    public WordDistanceFinder(final List<String> words) {

        this.words = words;
    }

    public long distance(final String word1, final String word2) {

        long firstWordDistance = 0;
        long secondWordDistance = 0;

        final Map<String, Long> distance = new HashMap<>();

        for (final String word : words) {

            if (word.equals(word1)) {
                distance.put(word1, firstWordDistance);
            }

            if(word.equals(word2)) {
                distance.put(word2,secondWordDistance);
            }

            firstWordDistance++;
            secondWordDistance++;
        }

        return Math.abs(distance.get(word1) - distance.get(word2));
    }
}
