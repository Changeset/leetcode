package designproblems;


import java.util.Hashtable;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:40 2018/4/23
 * @ ModifiedBy:
 */
public class LRUCache {
    private Hashtable<Integer, DLinkedNode>
        cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    //Always add the new node right after head;
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    //Remove an existing node from the linked list.
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    //Move certain node in between to the head.
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        //move the accessed node to the head;
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;
            if (count > capacity) {
                //pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            //update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        int param_1 = obj.get(1);
        obj.put(2,2);
        obj.put(3,3);
        int param_2 = obj.get(1);
        System.out.println(param_1 + ", " + param_2);
    }
}
