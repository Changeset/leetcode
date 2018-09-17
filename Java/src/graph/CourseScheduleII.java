package graph;



import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:05 2018/5/4
 * @ ModifiedBy:
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
        // return solveByBFS(incLinkCounts, adjs);
        return solveByDFS(adjs);
    }

    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
        int n = incLinkCounts.length;
        while (n-- > 0) adjs.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }
    private int[] solveByDFS(List<List<Integer>> adjs) {
        BitSet hasCycle = new BitSet(1);
        BitSet visited = new BitSet(adjs.size());
        BitSet onStack = new BitSet(adjs.size());
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = adjs.size() - 1; i >= 0; i--) {
            if (!visited.get(i) && !hasOrder(i, adjs, visited, onStack, order))
                return new int[0];
        }
        int[] orderArray = new int[adjs.size()];
        for (int i = 0; !order.isEmpty(); i++) orderArray[i] = order.pop();
        return orderArray;
    }
    private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
        visited.set(from);
        onStack.set(from);
        for (int to : adjs.get(from)) {
            if (!visited.get(to)) {
                if (!hasOrder(to, adjs, visited, onStack, order)) return false;
            } else if (onStack.get(to)) return false;
        }
        onStack.clear(from);
        order.push(from);
        return true;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[][] prerequisites = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
    }
}
