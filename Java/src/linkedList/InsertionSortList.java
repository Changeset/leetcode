package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:26 2018/5/1
 * @ ModifiedBy:
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode helper = new ListNode(0);
        ListNode cur = head;
        ListNode pre = helper;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        InsertionSortList i = new InsertionSortList();
        System.out.println(i.insertionSortList(head));
    }
}
