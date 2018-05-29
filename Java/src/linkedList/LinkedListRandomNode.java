package linkedList;

import java.util.Random;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:28 2018/5/29
 * @ ModifiedBy:
 */
public class LinkedListRandomNode {
    ListNode head;
    Random random;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        ListNode curr = head;
        int r = curr.val;
        for (int i = 1; curr.next != null; i++) {
            curr = curr.next;
            if (random.nextInt(i + 1) == i) r = curr.val;
        }

        return r;
    }
}
