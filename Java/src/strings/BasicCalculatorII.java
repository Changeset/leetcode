package strings;

import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:34 2018/3/27
 * @ ModifiedBy:
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        char[] ch = s.toCharArray();
        char sign = '+';
        int res = 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                sum = sum * 10 + ch[i] - '0';
            }
            if ((!Character.isDigit(ch[i]) && ' ' != ch[i]) || i == ch.length - 1) {
                if (sign == '+') stack.push(sum);
                if (sign == '-') stack.push(-sum);
                if (sign == '*') stack.push(stack.pop()*sum);
                if (sign == '/') stack.push(stack.pop()/sum);
                sign = ch[i];
                sum = 0;
            }
        }
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
