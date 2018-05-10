package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:18 2018/4/11
 * @ ModifiedBy:
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int size = 1;
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            size++;
            fast = fast.next;
        }
        for (int i = size - k % size; i > 1; i--)
            slow = slow.next;
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
