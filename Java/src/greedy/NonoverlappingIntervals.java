package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:12 2018/6/6
 * @ ModifiedBy:
 */
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
}
