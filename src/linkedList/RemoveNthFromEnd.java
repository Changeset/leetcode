package linkedList;

import java.util.Iterator;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:16 2018/3/1
 * @ ModifiedBy:
 */
public class RemoveNthFromEnd {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int length = n;
//        ListNode p = head, prep = null;
//        while (!isNode(p, n)) {
//            prep = p;
//            p = p.next;
//        }
//        if (p.next == null) {
//            if (head == p) return null;
//            else {
//                prep.next = null;
//                return head;
//            }
//        }
//        p.val = p.next.val;
//        p.next = p.next.next;
//        return head;
//    }
//
//    public boolean isNode(ListNode node, int n) {
//        while (n > 0) {
//            node = node.next;
//            n--;
//        }
//        if (node == null) return true;
//        else return false;
//    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
    public static void main(String[] args) {
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);

        r.removeNthFromEnd(head, 1);
    }
}
