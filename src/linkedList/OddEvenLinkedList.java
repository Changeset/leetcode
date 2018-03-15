package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:11 2018/3/14
 * @ ModifiedBy:
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        if (evenNode == null) return oddNode;
        int n = 0;
        if (oddNode != null ) {
            n++;
            oddNode = oddNode.next;
        }
        return null;
    }

    public void exch(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
