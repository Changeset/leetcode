package greedy;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:45 2018/6/4
 * @ ModifiedBy:
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stack[top++] = c;
        }

        int idx = 0;
        while (idx < digits && stack[idx] == '0') idx++;
        return idx == digits ? "0" : new String(stack, idx, digits - idx);
    }

    public static void main(String[] args) {
        String num = "1432219";
        String num2 = "1020032";
        RemoveKDigits r = new RemoveKDigits();
        System.out.println(r.removeKdigits(num, 3));
        System.out.println(r.removeKdigits(num2, 3));
    }
}
