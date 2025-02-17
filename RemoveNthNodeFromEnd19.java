public class RemoveNthNodeFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode headPoint = head;

        int count = 0;

        while (headPoint != null) {
            count++;
            headPoint = headPoint.next;

        }

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode pre = dummy;

        for (int i = 0; i < count - n; i++) {

            pre = pre.next;

        }

        pre.next = pre.next.next;

        return dummy.next;

    }

    // fast and slow pointer solution
    // Move the fast pointer n + 1 steps ahead. This creates a gap of n nodes
    // between the slow and fast pointers.

    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = 0;

        while (fast != null) {

            fast = fast.next;

            if (count >= n + 1) {
                slow = slow.next;
            }

            count++;
        }

        slow.next = slow.next.next;

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
