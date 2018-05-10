package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:51 2018/4/15
 * @ ModifiedBy:
 */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pNode = head, pNext = head.next;
        while (pNext != null) {
            while (pNext != null && pNode.val == pNext.val) {
                pNext = pNext.next;
            }
            pNode.next = pNext;
            pNode = pNext;
        }
        return head;
    }
}
