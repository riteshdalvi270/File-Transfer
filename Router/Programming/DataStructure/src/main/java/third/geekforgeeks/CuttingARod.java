package third.geekforgeeks;

/**
 * Cutting a rod.
 * Created by ritesh on 1/18/16.
 */
public class CuttingARod {

    public static void main(String args[]) {

        int lengths[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

        int lengthOfRod = lengths.length;

        System.out.println(cuttingRod(price, lengthOfRod));
    }

    public static int cuttingRod(int price[], int lengthOfRod) {

        if (lengthOfRod <= 0) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < lengthOfRod; i++) {

            maxValue = max(maxValue, price[i] + cuttingRod(price, lengthOfRod - i - 1));
        }

        return maxValue;
    }

    public static int max(int a, int b) {

        return a > b ? a : b;
    }

    public static int cut(int price[], int lengthOfRod) {

        return price[lengthOfRod];
    }
}
