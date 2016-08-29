package third.careercup.linkedin;


/**
 * List of integers weighted by depth.
 * Created by ritesh on 1/9/16.
 */
public class ListOfIntegersWeightedByDepth {

    // Solution:
    /*
    public class ListOfIntegersWeightedByDepth {

	public int getListSum(final NestedInteger root, int depth) {

		if(root.isIntegers()) {
			return root.getInteger() * depth;
		}

		List<NestedInteger> nestedIntegers = root.getList();

		int sum = 0;

		for(final NestedInteger nestedInteger : nestedIntegers) {

			sum = sum + getListSum(nestedInteger,depth++);
		}

		return sum;
	}
}
    */

}
