package May1;

public class ReverserLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {

            ListNode temp = curr;
            curr = curr.next;
            temp.next = pre;
            pre = temp;

        }

        return pre;

    }

}
