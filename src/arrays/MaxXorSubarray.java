package arrays;

import designproblems.MinStack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:27 2018/3/17
 * @ ModifiedBy:
 */
public class MaxXorSubarray {
    public class TrieNode {
        int val;
        TrieNode[] child;
        TrieNode() {
            this.val = 0;
            this.child = new TrieNode[2];
            this.child[0] = this.child[1] = null;
        }
    }
    public int maxXorSubarray(int[] nums) {
        TrieNode root = new TrieNode();
        insert(root, 0);
        int res = Integer.MIN_VALUE, prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix = prefix ^ nums[i];
            insert(root, prefix);
            res = maxVal(res, query(root, prefix));
        }
        return res;
    }

    public void insert(TrieNode root, int prefix) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int value = (prefix & (1 << i)) > 0 ? 1 : 0;
            if (node.child[value] == null)
                node.child[value] = new TrieNode();
            node = node.child[value];
        }
        node.val = prefix;
    }

    public int query(TrieNode root, int prefix) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int value = (prefix & (1 << i)) > 0 ? 1 : 0;
            if (node.child[1-value] != null)
                node = node.child[1-value];
            else node = node.child[value];
        }
        return prefix ^ (node.val);
    }

    public int maxVal(int a, int b) {
        return a > b ? a : b;
    }
    public static void main(String[] args) {
        int[] nums = {8,1,2,12,7,6};
        MaxXorSubarray m = new MaxXorSubarray();
        System.out.println(m.maxXorSubarray(nums));
    }
}
