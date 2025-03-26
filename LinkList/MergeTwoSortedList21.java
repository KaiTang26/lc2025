package LinkList;

public class MergeTwoSortedList21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (list2 != null && list1 != null) {

            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
                head = head.next;

            } else {
                head.next = list2;
                list2 = list2.next;
                head = head.next;

            }

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
