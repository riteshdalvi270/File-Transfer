package careercupbook;

import java.util.*;

/**
 * Subsets of all sets.
 * Created by ritesh on 1/31/16.
 */
public class SubsetsOfSets {

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);

        System.out.println(subsets.toString());

        ArrayList<ArrayList<Integer>> subsets1 = getSubsetsCTCI(list, 0);

        System.out.println(subsets1.toString());
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> subset,int index) {

        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

        if(subset.size() == index) {
            ArrayList<Integer> emptySet = new ArrayList<>();
            allSubsets.add(emptySet);
        }else {
            allSubsets = getSubsets(subset,index+1);

            final ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();

            Integer item = subset.get(index);

            for(final ArrayList<Integer> set :  allSubsets) {

                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(set);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }

            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;
    }

    public static ArrayList<ArrayList<Integer>> getSubsetsCTCI(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) { // Base case - add empty set
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }
}
