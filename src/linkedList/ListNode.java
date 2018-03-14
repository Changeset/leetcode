package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:23 2018/3/1
 * @ ModifiedBy:
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode() {}
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode start = head;
        start.val = 1;
        System.out.println(head.val);
    }
}
