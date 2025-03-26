package LinkList;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesInLinkedList1721 {

    public static void main(String[] args) {
        SwappingNodesInLinkedList1721 r = new SwappingNodesInLinkedList1721();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node = r.swapNodes(n1, 2);

        while (node != null) {

            System.out.println(node.val);
            node = node.next;

        }

    }

    public ListNode swapNodes(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);

        ListNode valueKNode = null;
        int valueKnodeIndex = 1;

        List<ListNode> nodeList = new ArrayList<>();

        while (head != null) {

            if (valueKnodeIndex == k) {
                valueKNode = head;
            }

            valueKnodeIndex++;

            nodeList.add(head);
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }

        int size = nodeList.size();

        // System.out.println("size: " + size);

        // System.out.println("valueKNode: " + valueKNode.val);

        // System.out.println("valueKnodeIndex : " + valueKnodeIndex);

        nodeList.set(k - 1, nodeList.get(size - k));
        nodeList.set(size - k, valueKNode);

        head = dummy;

        for (ListNode n : nodeList) {

            System.out.println("value: " + n.val);

            head.next = n;
            head = head.next;
        }

        return dummy.next;

    }

}
