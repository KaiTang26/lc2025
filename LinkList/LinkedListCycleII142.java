package LinkList;

public class LinkedListCycleII142 {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }

        }

        if (!hasCycle) {
            return null;
        }

        slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;

    }

}
