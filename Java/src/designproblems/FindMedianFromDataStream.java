package designproblems;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:27 2018/5/15
 * @ ModifiedBy:
 */
public class FindMedianFromDataStream {
    private Queue<Long> small = new PriorityQueue<>(),
                        large = new PriorityQueue<>();
    /** initialize your data structure here. */
    public FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream f = new FindMedianFromDataStream();
        f.addNum(1);
        f.addNum(2);
        System.out.println(f.findMedian());
        f.addNum(3);
        System.out.println(f.findMedian());
        f.addNum(2);
        System.out.println(f.findMedian());
    }
}
