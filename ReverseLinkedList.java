public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;

        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }

        return pre;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;

    }
}


// A common way to solve this problem is to use two pointers (or three if you
// count a temporary pointer):
// prev: Starts as null. After reversal, this will be the new head.
// current: Starts at the head of the list and progresses through the list.
// next: A temporary pointer to store current.next, ensuring you don’t lose the
// remaining list.