package third.careercup.linkedin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by ritesh on 1/9/16.
 */
public class FindRangeIntervalCovers {

    public static void main(String args[]) {

        Interval interval1 = new Interval(6,8);
        Interval interval2 = new Interval(1,9);
        Interval interval3 = new Interval(2,4);
        Interval interval4 = new Interval(4,7);

        Interval ranges[] = {interval1,interval2,interval3,interval4};

        RangeConvered rangeConvered = new RangeConvered();
        rangeConvered.rangeCovered(ranges);
    }
}

class RangeConvered {

    public void rangeCovered(final Interval[] intervals) {

        sortByStartTime(intervals);
        printIntervals(intervals);

        final Stack<Interval> stack = new Stack<>();

        for(final Interval interval: intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            }else {

                if(interval.coIncides(stack.peek())) {

                    stack.push(mergeInterval(interval,stack.pop()));
                }else {
                    stack.push(interval);
                }
            }
        }

        printElementsInStack(stack);
    }

    public void sortByStartTime(Interval[] intervals) {

        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval start1, Interval start2) {
                return Integer.compare(start1.start,start2.start);
            }
        };

        Arrays.sort(intervals,comparator);
    }

    public void printIntervals(final Interval[] intervals) {

        for(final Interval interval : intervals) {
            System.out.println("{"+interval.start+","+interval.stop+"}");
        }
    }

    public Interval mergeInterval(final Interval interval1,final Interval interval2) {

        Interval interval = null;

        if(interval1.stop < interval2.stop) {
            interval = new Interval(interval2.start,interval2.stop);
        }else {
            interval = new Interval(interval2.start, interval1.stop);
        }

        return interval;
    }

    public void printElementsInStack(final Stack<Interval> stack) {

        System.out.println("Printing Stack Elements");
        while(!stack.isEmpty()) {

           final Interval interval = stack.pop();

            System.out.println("{"+interval.start+","+interval.stop+"}");
        }
    }
}

class Interval {
    int start;
    int stop;

    public Interval(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }


    public boolean coIncides(final Interval interval) {

        if(this.start < interval.stop) {
            return true;
        }

        return false;
    }
}
