package second.crackingcode.searchingsorting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class GetRank
{
    private static HashMap<Integer, Rank> rankByNumber = new HashMap();

    public static void main(String args[])
    {
        int a[] = {5,1,4,4,5,9,7,13,3};

        for(int i = 0;i <a.length;i++)
        {

            generateNumber(a[i]);
        }

        int rank = getRankOfNumber(4);
        System.out.println("Rank:"+rank);
    }

    public static void generateNumber(int x)
    {
        track(x);
    }

    public static void track(int x)
    {
        if (rankByNumber.get(x) == null)
        {
            rankByNumber.put(x, new Rank());
            rankByNumber.get(x).setNumberOfOcuurence();
        } else {
            rankByNumber.get(x).setNumberOfOcuurence();
        }

        for(Map.Entry<Integer, Rank> entries:rankByNumber.entrySet()) {

            if(entries.getKey() <= x) {

                    Rank rank = rankByNumber.get(x);
                    rank.incrementRank();

            } else if(entries.getKey() > x) {
                entries.getValue().incrementRank();
            }
        }
    }

    public static int getRankOfNumber(int x)
    {
        Rank rank = rankByNumber.get(x);
        if(rankByNumber.get(x) != null)
        {
            if (rank.getNumberOfOcuurence() > 0)
            {
                return rank.getRank() - (rank.getNumberOfOcuurence()-1);
            }
            else
                return rankByNumber.get(x).getRank();
        }

        return -1;
    }

    public static class Rank
    {
        private int rank = 0;
        int numberOfOcuurence = 0;

        public void incrementRank()
        {
            rank++;
        }

        public int getRank()
        {
            return rank;
        }

        public int getNumberOfOcuurence() {
            return  numberOfOcuurence;
        }

        public void setNumberOfOcuurence() {
            numberOfOcuurence++;
        }
    }
}
