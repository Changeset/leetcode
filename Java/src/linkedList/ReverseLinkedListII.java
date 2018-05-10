package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:35 2018/4/16
 * @ ModifiedBy:
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode pPrev = new ListNode(0), pNode = head, pStart = head, pEnd;
        pPrev.next = head;
        ListNode result = pPrev;
        for (int i = 1; i < m; i++) {
            pPrev = pNode;
            pNode = pNode.next;
        }
        pStart = pPrev;
        pPrev = pNode;
        pNode = pNode.next;
        pEnd = pPrev;
        n = n - m;
        pPrev.next = null;
        while (n > 0) {
            ListNode pNext = pNode.next;
            n--;
            if (n == 0) {
                pEnd = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        pStart.next.next = pNode;
        pStart.next = pEnd;
        return result.next;
    }

    public ListNode reverBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) pre = pre.next;
        ListNode start = pre.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedListII r = new ReverseLinkedListII();
        System.out.println(r.reverseBetween(head, 2, 2));
    }
}
