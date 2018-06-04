package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:21 2018/6/4
 * @ ModifiedBy:
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight q = new QueueReconstructionByHeight();
        int[][] people = {
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };
        people = q.reconstructQueue(people);
        for (int[] cur : people) {
            for (int i : cur)
                System.out.print(i + ",");
            System.out.println();
        }
    }
}
