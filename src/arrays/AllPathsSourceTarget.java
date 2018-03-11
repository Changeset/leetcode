package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:28 2018/3/11
 * @ ModifiedBy:
 */
public class AllPathsSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        int n = graph.length;
        if (n == 0) return res;
        res = dfsToTarget(graph,0, graph.length-1);
        return res;
    }

    public List<List<Integer>> dfsToTarget(int[][] graph, int begin, int target) {
        List<List<Integer>> paths = new LinkedList<>();
        if (begin == target) {
            List<Integer> list = new LinkedList<>();
            list.add(begin);
            paths.add(list);
            return paths;
        }
        for (int v : graph[begin]) {
            List<List<Integer>> results = dfsToTarget(graph, v, target);
            for (List<Integer> result : results) {
                result.add(0, begin);
                paths.add(result);
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},
                            {2,3},
                            {3,4},
                            {4},
                            {}};
        AllPathsSourceTarget a = new AllPathsSourceTarget();
        System.out.println(a.allPathsSourceTarget(graph));
    }
}


