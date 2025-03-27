package HashHeap;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList23 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode n : lists) {
            if (n != null) {
                pq.offer(n);

            }

        }

        while (!pq.isEmpty()) {

            ListNode n = pq.poll();

            tail.next = n;
            tail = tail.next;

            if (n.next != null) {
                pq.offer(n.next);
            }

        }

        return dummy.next;

    }

}

class ListNode {
    int val;

    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}