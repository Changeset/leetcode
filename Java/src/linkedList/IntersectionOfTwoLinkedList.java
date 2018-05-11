package linkedList;



/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:26 2018/3/15
 * @ ModifiedBy:
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA, nodeB = headB;
        ListNode A = headA, B = headB;
        int a = 0, b = 0;
        while (nodeA != null) {
            a++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            b++;
            nodeB = nodeB.next;
        }
        int k = Math.abs(a-b);
        if (a > b) {
            A = headA;
            while (k > 0) {
                A = A.next;
                k--;
            }
        } else {
            B = headB;
            while (k > 0) {
                B = B.next;
                k--;
            }
        }
        while (A != null && B != null) {
            if (A == B) return A;
            A = A.next;
            B = B.next;
        }
        return null;
    }

    public ListNode getIntersection(ListNode A, ListNode B) {
        if (A == null || B == null) return null;
        ListNode a = A;
        ListNode b = B;
        while (a != b) {
            a = a == null ? B : a.next;
            b = b == null ? A : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        ListNode B = new ListNode(4);
        IntersectionOfTwoLinkedList i = new IntersectionOfTwoLinkedList();
        System.out.println(i.getIntersection(A, B));
    }
}
