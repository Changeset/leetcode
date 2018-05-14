package designproblems;

import java.util.Iterator;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:10 2018/5/14
 * @ ModifiedBy:
 */
public class PeekingIterator implements Iterator<Integer> {
    private Integer next = null;
    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext())
            next = iter.next();
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    @Override
    public boolean hasNext(){
        return next != null;
    }
}
