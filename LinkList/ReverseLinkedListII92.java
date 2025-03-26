package LinkList;

public class ReverseLinkedListII92 {

    public static void main(String[] args) {
        ReverseLinkedListII92 r = new ReverseLinkedListII92();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node = r.reverseBetween(n1, 2, 4);

        while (node != null) {

            System.out.println(node.val);
            node = node.next;

        }

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode leftPre = dummy;

        for (int i = 1; i < left; i++) {
            leftPre = leftPre.next; // pre ndoe before left
        }

        ListNode rightNode = dummy;

        for (int i = 0; i < right; i++) {
            rightNode = rightNode.next;
        }

        System.out.println("rightNode: " + rightNode.val);

        ListNode pre = leftPre;
        ListNode curr = leftPre.next;

        System.out.println("curr: " + curr);

        for (int i = 0; i <= (right - left); i++) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;

        }

        leftPre.next.next = curr;
        leftPre.next = pre;

        return dummy.next;

    }

}
