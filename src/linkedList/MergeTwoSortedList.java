package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:16 2018/3/1
 * @ ModifiedBy:
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode head1 = l1, head2 = l2, res = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next =l1;
                l1 = l1.next;
                res = res.next;
            }
            else {
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
        }
        if (l1 == null) res.next = l2;
        else res.next = l1;
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedList merge = new MergeTwoSortedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        merge.mergeTwoLists(l1, l2);
    }
}
