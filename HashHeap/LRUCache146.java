package HashHeap;
// HashSet and LinkList

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LRUCache146 {

    Map<Integer, ListNode> map;
    int capacity;
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-2, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head.next = tail;
        tail.pre = head;
        
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);

        if (tail.pre != node) {

            node.pre.next = node.next;
            node.next.pre = node.pre;

            pushNodeToTail(node);
        }

        return node.val;

    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;

            if (tail.pre != node) {

                node.pre.next = node.next;
                node.next.pre = node.pre;

                pushNodeToTail(node);
            }

            return;

        }

        if (map.size() >= capacity) {
            if (head.next != tail) {

                ListNode removeNode = head.next;
                head.next = removeNode.next;
                removeNode.next.pre = head;
                removeNode.next = null;
                removeNode.pre = null;
                map.remove(removeNode.key);
            }
        }

        ListNode node = new ListNode(key, value);

        pushNodeToTail(node);
        map.put(key, node);

    }

    private void pushNodeToTail(ListNode node) {

        tail.pre.next = node;
        node.next = tail;
        node.pre = tail.pre;
        tail.pre = node;

    }

}

class ListNode {
    int val;
    int key;
    ListNode pre;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
