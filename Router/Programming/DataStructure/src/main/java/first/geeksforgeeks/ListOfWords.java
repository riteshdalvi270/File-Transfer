package first.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class ListOfWords
{
    public static void main(String args[]) {

        List<String> w1 = new ArrayList();
        List<String> w2 = new ArrayList();
        List<String> w3 = new ArrayList();

        w1.add("you");
        w1.add("we");

        w2.add("have");
        w2.add("are");

        w3.add("sleep");
        w3.add("eat");
        w3.add("drink");

        List<List<String>> sentences = new ArrayList();

        System.out.println(determineListOfWords(w1,w2,w3,sentences,0,0,0));
    }

    public static List<List<String>> determineListOfWords(List<String> w1, List<String> w2, List<String> w3, List<List<String>> sentences, int x, int y, int z) {

        if(x>=w1.size()) {
            return sentences;
        }

        if(y>=w2.size()) {
            return sentences;
        }

        if(z>=w3.size()) {
            return  sentences;
        }

        final String s1 = w1.get(x);
        final String s2 = w2.get(y);
        final String s3 = w3.get(z);

        List<String> listOfWords =  new ArrayList();
        listOfWords.add(s1);
        listOfWords.add(s2);
        listOfWords.add(s3);

        sentences.add(listOfWords);

        determineListOfWords(w1, w2, w3, sentences, x, y, z+1);
        determineListOfWords(w1,w2,w3,sentences,x,y+1,z);
        determineListOfWords(w1,w2,w3,sentences,x+1,y,z);

        return sentences;
    }
}
