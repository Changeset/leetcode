package linkedList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:23 2018/3/1
 * @ ModifiedBy:
 */

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
