package third.geekforgeeks;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ritesh on 1/18/16.
 */
public class JobSequencingProblem {

    public static void main(String args[]) {

        Job[] input = new Job[5];


        input[0] = new Job('a',2,100);
        input[1] = new Job('b',1,19);
        input[2] = new Job('c',2,27);
        input[3] = new Job('d',1,25);
        input[4] = new Job('e',3,15);

        printJobScheduling(input, input.length);
    }

    public static void printJobScheduling(Job arr[], int n)
    {

        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {

                return Integer.compare(o2.profit,o1.profit);
            }
        });

        int result[] = new int[n]; // To store result (Sequence of jobs)
        boolean[] slot = new boolean[n];  // To keep track of free time slots

        // Initialize all slots to be free
        for (int i=0; i<n; i++)
            slot[i] = false;

        // Iterate through all given jobs
        for (int i=0; i<n; i++)
        {
            // Find a free slot for this job (Note that we start
            // from the last possible slot)
            for (int j=Math.min(n, arr[i].dead)-1; j>=0; j--)
            {
                // Free slot found
                if (slot[j]==false)
                {
                    result[j] = i;  // Add this job to result
                    slot[j] = true; // Make this slot occupied
                    break;
                }
            }
        }

        // Print the result
        for (int i=0; i<n; i++)
            if (slot[i])
                System.out.println(arr[result[i]].id);
    }
}

class Job {

    char id;      // Job Id
    int dead;    // Deadline of job
    int profit;  // Profit if job is over before or on deadline

    public Job(char id, int dead, int profit) {

        this.id = id;
        this.dead = dead;
        this.profit = profit;
    }
}
