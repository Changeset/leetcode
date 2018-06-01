package math;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:34 2018/6/1
 * @ ModifiedBy:
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    public static void main(String[] args) {
        EliminationGame e = new EliminationGame();
        System.out.println(e.lastRemaining(9));
    }
}
