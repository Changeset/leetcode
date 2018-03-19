package sortandsearch;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:55 2018/3/19
 * @ ModifiedBy:
 */
public class TopKFrequnet {
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        List<Integer> result = new ArrayList<>();
//        Map<Integer, Integer>  map = new HashMap<>();
//        for (int num : nums)
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
//            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
//                return a.getValue() - b.getValue();
//            }
//        });
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            pq.add(entry);
//            if (pq.size() > k)
//                pq.poll();
//        }
//        while (pq.size() > 0) {
//            Map.Entry<Integer, Integer> entry = pq.poll();
//            result.add(0, entry.getKey());
//        }
//        return result;
//    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null)
                res.addAll(bucket[pos]);
        }
        return res.subList(0, k);
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        TopKFrequnet t = new TopKFrequnet();
        System.out.println(t.topKFrequent(nums, 2));
    }
}
