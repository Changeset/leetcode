package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:26 2018/3/1
 * @ ModifiedBy:
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pReverseHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) pReverseHead = pNode;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }
}