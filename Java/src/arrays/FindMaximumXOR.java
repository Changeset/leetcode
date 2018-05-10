package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:22 2018/3/18
 * @ ModifiedBy:
 */
public class FindMaximumXOR {
//    public class TrieNode {
//        int val;
//        TrieNode[] child;
//        public TrieNode() {
//            val = 0;
//            child = new TrieNode[2];
//            child[0] = child[1] = null;
//        }
//    }
//    public int findMaximumXOR(int[] nums) {
//        TrieNode root = new TrieNode();
//        int prefix, res = Integer.MIN_VALUE;
//        if (nums.length <= 1) return 0;
//        insert(root, nums[0]);
//        for (int i = 0; i < nums.length; i++) {
//            prefix = nums[i];
//            res = Math.max(res, query(root, prefix));
//            insert(root, prefix);
//        }
//        return res;
//    }
//
//    public void insert(TrieNode root, int prefix) {
//        TrieNode node = root;
//        for (int i = 31; i >= 0; i--) {
//            int value = (prefix & (1 << i)) > 0 ? 1 : 0;
//            if (node.child[value] == null)
//                node.child[value] = new TrieNode();
//            node = node.child[value];
//        }
//        node.val = prefix;
//    }
//
//    public int query(TrieNode root, int prefix) {
//        TrieNode node = root;
//        for (int i = 31; i >= 0; i--) {
//            int value = (prefix & (1 << i)) > 0 ? 1 : 0;
//            if (node.child[1 - value] != null)
//                node = node.child[1 - value];
//            else node = node.child[value];
//        }
//        return prefix ^ node.val;
//    }

    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {4,6,7};
        FindMaximumXOR m = new FindMaximumXOR();
        System.out.println(m.findMaximumXOR(nums));
    }
}
