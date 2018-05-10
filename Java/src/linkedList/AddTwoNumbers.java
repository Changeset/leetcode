package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:31 2018/3/14
 * @ ModifiedBy:
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode c1 =l1;
        ListNode c2 =l2;
        int sum = 0;
        while(c1 != null || c2 != null)
        {
            sum/=10;
            if(c1 != null)
            {
                sum+=c1.val;
                c1 = c1.next;
            }
            if(c2 != null)
            {
                sum+=c2.val;
                c2 = c2.next;
            }
            tail.next = new ListNode(sum%10);
            tail = tail.next;
        }
        if(sum/10 == 1)
            tail.next = new ListNode(1);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
        AddTwoNumbers a = new AddTwoNumbers();
        System.out.println(a.addTwoNumbers(l1,l2));
        System.out.println();
    }
}
