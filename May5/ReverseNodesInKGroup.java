package May5;

import javax.swing.text.html.HTMLEditorKit.LinkController;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dumyNode = new ListNode(-1);
        dumyNode.next = head;

        ListNode pre = dumyNode;

        while (pre != null) {

            pre = reverserHelper(dumyNode, k);

        }

        return dumyNode.next;

    }

    private ListNode reverserHelper(ListNode node, int k) {

        ListNode nodeK = node;

        for (int i = 0; i < k; i++) {

            if (nodeK != null) {
                nodeK = nodeK.next;
            }

        }

        if (nodeK != null) {

            ListNode pre = node;
            ListNode curr = node.next;

            for (int i = 0; i < k; i++) {

                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }

            ListNode nextPre = node.next;

            node.next.next = curr;
            node.next = pre;

            return nextPre;

        }

        return null;

    }

}
