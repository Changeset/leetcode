package designproblems;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:39 2018/5/29
 * @ ModifiedBy:
 */
public class InsertDeleteGetRandomDupAllow {
    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> locs;
    Random rand = new Random();
    public InsertDeleteGetRandomDupAllow() {
        nums = new ArrayList<>();
        locs = new HashMap<Integer, Set<Integer>>();
    }

    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) locs.put(val, new LinkedHashSet<>());
        locs.get(val).add(nums.size());
        nums.add(val);
        return !contain;
    }

    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) return false;
        int loc = locs.get(val).iterator().next();
        locs.get(val).remove(loc);
        if (loc < nums.size() - 1) {
            int lastone = nums.get(nums.size() - 1);
            nums.set(loc, lastone);
            locs.get(lastone).remove(nums.size() - 1);
            locs.get(lastone).add(loc);
        }
        nums.remove(nums.size() - 1);

        if (locs.get(val).isEmpty()) locs.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
