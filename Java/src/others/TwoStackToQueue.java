package others;

import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:08 2018/8/28
 * @ ModifiedBy:
 */
public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                int data = stack1.pop();
                stack2.push(data);
            }
        }
        if (stack2.size() == 0) return 0;
        int head = stack2.pop();
        return head;
    }
}
