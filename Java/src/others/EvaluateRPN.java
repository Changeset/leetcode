package others;

import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:10 2018/5/2
 * @ ModifiedBy:
 */
public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if (s.equals("+"))
                S.add(S.pop() + S.pop());
            else if (s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            }
            else if (s.equals("*"))
                S.add(S.pop() * S.pop());
            else if (s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            }
            else S.add(Integer.parseInt(s));
        }
        return S.pop();
    }
}
