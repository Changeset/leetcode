package designproblems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:23 2018/3/22
 * @ ModifiedBy:
 */
public class RandomizedSet {
    Set<Integer> set;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        } else return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        } else return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int n = set.size();
        if (n == 0) return 0;
        Object[] res = set.toArray();
        Random rand = new Random();
        int result = rand.nextInt(n);
        return (Integer)res[result];
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.insert(10);
        obj.insert(20);
        int param_3 = obj.getRandom();
        param_3 = obj.getRandom();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
