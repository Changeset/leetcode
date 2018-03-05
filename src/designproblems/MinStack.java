package designproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:14 2018/3/5
 * @ ModifiedBy:
 */
public class MinStack {
    private Node first;
    private int n;
    private Stack<Integer> stack;
    private class Node {
        private int val;
        private Node next;
        private Node(int x) {
            val = x;
        }
    }

    public MinStack() {
        first = null;
        n = 0;
        stack = new Stack<>();
    }

    public void push(int x) {
        Node oldfirst = first;
        first = new Node(x);
        if (oldfirst != null) first.next = oldfirst;
        else first.next = null;
        if (n == 0)
            stack.push(x);
        else stack.push(Math.min(stack.peek(), x));
        n++;
    }

    public void pop() {
        if (first == null) throw new IllegalArgumentException();
        first = first.next;
        stack.pop();
        --n;
    }

    public int top() {
        if (first == null) throw new IllegalArgumentException();
        return first.val;
    }

    public int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        MinStack min = new MinStack();
        min.push(-2);
        min.push(0);
        min.push(-3);
        System.out.println(min.getMin());
        min.pop();
        System.out.println(min.top());
        System.out.println(min.getMin());
    }
}
