package LinkList;

import java.util.List;

public class SortList148 {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        SortList148 s = new SortList148();

        ListNode node = s.sortList(n1);

        while (node != null) {

            System.out.println(node.val);
            node = node.next;

        }

    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode secondHead = cutToHelf(head);

        ListNode list1 = sortList(head);

        ListNode list2 = sortList(secondHead);

        return mergeList(list1, list2);

    }

    private ListNode cutToHelf(ListNode head) {

        int size = 0;
        ListNode tail = head;

        while (tail != null) {
            tail = tail.next;
            size++;
        }

        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode secondHeadPre = dummy;

        for (int i = 0; i < size / 2; i++) {
            secondHeadPre = secondHeadPre.next;
        }

        dummy.next = secondHeadPre.next;
        secondHeadPre.next = null;

        return dummy.next;

    }

    private ListNode mergeList(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;

            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        if (list1 != null) {
            head.next = list1;
        }

        if (list2 != null) {
            head.next = list2;
        }

        return dummy.next;

    }

}
