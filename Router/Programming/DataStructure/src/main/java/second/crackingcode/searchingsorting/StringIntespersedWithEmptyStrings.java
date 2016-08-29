package second.crackingcode.searchingsorting;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class StringIntespersedWithEmptyStrings
{
    public static void main(String args[]) {

        String s1[] = {"at", "", "", "", "", "", "ball", "" ,"", "car", "", "", "dad", "", "", "", ""};
        int index = binarySearch(s1, 0, s1.length,"at");

        if(index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found"+index);
        }
    }

    public boolean findString(String[] s1, int element) {

        for(String s : s1) {

            if(s.equals("")) {
                continue;
            } else if(s.equals(element)) {
                return true;
            }
        }

        return false;
    }


    //modification to binary serach. Approach is right, coding is wrong.
    public static int binarySearch(String[] s1,int low, int high, String element) {

        int middle = (low+high)/2;

        while(low < high) {

            if(s1[middle].equals("")) {
                middle++;
                continue;
            }

            if(s1[middle].equals(element)) {
                return middle;
            }

            if(s1[middle].compareToIgnoreCase(element) < -1) {
                low = middle +1;
            } else if(s1[middle].compareToIgnoreCase(element) > 1) {
                high = middle-1;
            }

            middle = (low+high)/2;
        }

        return -1;
    }

}
