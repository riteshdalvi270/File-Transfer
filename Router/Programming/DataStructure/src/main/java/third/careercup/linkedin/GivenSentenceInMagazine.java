package third.careercup.linkedin;

/**
 * Created by ritesh on 1/16/16.
 */
public class GivenSentenceInMagazine {

    public static void main(String args[]) {

        final String note = "I want to kill ameya";
        final String maganzine = "I will be able to go to the bathroom alone. Will you help me my king";

        System.out.println(ransom(note,maganzine));
    }

    public static boolean ransom(final String note, final String magazine) {

        char[] charNote = note.toCharArray();
        char[] charMagazine = magazine.toCharArray();

        int magazineAscii[] = new int[256];
        int noteAscii[] = new int[256];

        for(final char charMagaz : charMagazine) {

            magazineAscii[charMagaz]++;
        }

        for(final char charNt : charNote) {

            if(magazineAscii[charNt]==0) {
                return false;
            }else {
                magazineAscii[charNt]--;
            }
        }

        return true;
    }
}
