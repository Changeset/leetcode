package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:17 2018/4/16
 * @ ModifiedBy:
 */
public class UniqueBST {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        UniqueBST u = new UniqueBST();
        System.out.println(u.numTrees(1));
    }
}
