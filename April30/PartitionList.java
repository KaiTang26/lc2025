package April30;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode dumLeft = new ListNode(-1);
        ListNode left = dumLeft;
        ListNode dumRight = new ListNode(-2);
        ListNode right = dumRight;

        while (head != null) {

            if (head.val < x) {
                left.next = head;
                left = left.next;

            } else {
                right.next = head;
                right = right.next;

            }

            head = head.next;

        }

        right.next = null;

        left.next = dumRight.next;

        return dumLeft.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
