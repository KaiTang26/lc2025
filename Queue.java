public class Queue {

    ListNode dummy;
    ListNode tail;

    public Queue() {
        dummy = new ListNode(-1);
        tail = dummy;
    }

    public void enqueue(int val) {

        ListNode node = new ListNode(val);

        tail.next = node;
        tail = node;
    }

    public int dequeue() {
        int val = dummy.next.val;

        dummy.next = dummy.next.next;

        if (dummy.next == null) {
            tail = dummy;
        }

        return val;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}