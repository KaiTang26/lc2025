package LinkList;

public class ReorderList143 {

    public static void main(String[] args) {
        ReorderList143 r = new ReorderList143();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        r.reorderList(n1);

        ListNode node = n1;

        while (node != null) {

            System.out.println(node.val);
            node = node.next;

        }

    }

    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode curr = slow.next;
        slow.next = null;
        ListNode pre = null;

        while (curr != null) {

            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        // pre point to new head of reversed ListNode

        ListNode firstList = head;

        ListNode dummy = new ListNode(-1);
        head = dummy;

        boolean isOnfirstList = true;

        while (firstList != null && pre != null) {

            if (isOnfirstList) {

                head.next = firstList;
                firstList = firstList.next;

            } else {
                head.next = pre;
                pre = pre.next;

            }

            head = head.next;
            head.next = null;
            isOnfirstList = !isOnfirstList;
        }

        if (pre != null) {
            head.next = pre;
        }

        if (firstList != null) {
            head.next = firstList;
        }

        head = dummy.next;

    }

}
