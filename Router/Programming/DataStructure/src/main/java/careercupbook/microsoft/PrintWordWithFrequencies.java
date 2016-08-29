package careercupbook.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Print k words with frequencies.
 * Created by ritesh on 3/3/16.
 */
public class PrintWordWithFrequencies {

    public static void main(String args[]) {

        final String input = "hello ritesh how are you, are you coming home tonight? are you?";

        System.out.println(kMostFrequentWords(input));
    }

    public static String kMostFrequentWords(final String input) {


        final HashMap<String,Long> frequenciesByWord = new HashMap<>();

        StringTokenizer stringTokenizer = new StringTokenizer(input);

        while(stringTokenizer.hasMoreElements()) {

            String token = stringTokenizer.nextToken();

            if(frequenciesByWord.get(token) == null) {

                frequenciesByWord.put(token,1L);
            }else {
                Long count = frequenciesByWord.get(token);
                count = count+1;
                frequenciesByWord.put(token,count);
            }
        }

        long count = 0;
        String output = null;

        for(Map.Entry<String,Long> entrySet : frequenciesByWord.entrySet()) {

            Long frequency = entrySet.getValue();

            if(count < frequency) {
                count = frequency;
                output = entrySet.getKey();
            }
        }

        return output;
    }
}
