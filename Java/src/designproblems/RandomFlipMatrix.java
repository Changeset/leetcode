package designproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:09 2018/8/24
 * @ ModifiedBy:
 */
public class RandomFlipMatrix {

    Map<Integer, Integer> map;
    int rows, cols, total;
    Random rand;

    public RandomFlipMatrix(int n_rows, int n_cols) {
        map = new HashMap<>();
        rand = new Random();
        rows = n_rows;
        cols = n_cols;
        total = rows * cols;
    }

    public int[] flip() {
        int r = rand.nextInt(total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        map.clear();
        total = rows * cols;
    }

    public static void main(String[] args) {
        RandomFlipMatrix r = new RandomFlipMatrix(4, 4);

    }
}
