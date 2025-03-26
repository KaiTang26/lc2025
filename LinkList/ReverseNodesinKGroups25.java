package LinkList;

import DFS.PermutationsII47;

public class ReverseNodesinKGroups25 {

    public static void main(String[] args) {
        ReverseNodesinKGroups25 r = new ReverseNodesinKGroups25();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node = r.reverseKGroup(n1, 2);

        while (node != null) {

            System.out.println(node.val);
            node = node.next;

        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre != null) {

            pre = reverseHelper(pre, k);

        }

        return dummy.next;
    }

    public ListNode reverseHelper(ListNode node, int k) {

        ListNode nodeK = node;

        for (int i = 0; i < k; i++) {
            if (nodeK != null) {
                nodeK = nodeK.next;
            }
        }

        if (nodeK == null) {
            return null;
        }

        ListNode pre = node;
        ListNode curr = node.next;

        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        node.next.next = curr;
        nodeK = node.next;
        node.next = pre;
        return nodeK;
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
