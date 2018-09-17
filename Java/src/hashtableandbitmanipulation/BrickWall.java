package hashtableandbitmanipulation;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:15 2018/9/13
 * @ ModifiedBy:
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (List<Integer> list : wall) {
            int length = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
    }

    public static void main(String[] args) {
        BrickWall b = new BrickWall();
        Integer[][] arr = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        List<List<Integer>> wall = new ArrayList<>();
        for (Integer[] a : arr) {
            List<Integer> l = new ArrayList<>();
            Collections.addAll(l, a);
            wall.add(l);
        }
        System.out.println(b.leastBricks(wall));
    }
}
