package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:49 2018/3/11
 * @ ModifiedBy:
 */
public class BestRotation {
    public int bestRotation(int[] A) {
        int[] scoresIncrease = new int[A.length+1];
        for (int i = 0; i < A.length; i++) {
            int v = A[i];
            if (i - v >= 0) {
                scoresIncrease[0]++;
                scoresIncrease[i - v + 1]--;
            }
            scoresIncrease[i + 1]++;
            if (i - v + A.length + 1 <= A.length)
                scoresIncrease[i - v + A.length + 1]--;
        }
        int scores = 0;
        int maxScores = 0;
        int bestK = 0;
        int k = -1;
        while(k < A.length) {
            k++;
            scores += scoresIncrease[k];
            if (scores > maxScores) {
                maxScores = scores;
                bestK = k;
            }
        }
        return bestK;
    }

    public static void main(String[] args) {
        int[] a = {1,3,0,2,4};
        BestRotation b = new BestRotation();
        System.out.println(b.bestRotation(a));
    }
}
