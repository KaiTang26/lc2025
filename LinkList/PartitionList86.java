package LinkList;

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode(-1);
        ListNode smallHead = smallDummy;

        ListNode bigDummy = new ListNode(-1);
        ListNode bigHead = bigDummy;

        // partition
        while (head != null) {

            if (head.val < x) {
                smallHead.next = head;
                smallHead = head;
                head = head.next;
                smallHead.next = null;

            } else {
                bigHead.next = head;
                bigHead = head;
                head = head.next;
                bigHead.next = null;

            }
        }

        smallHead.next = bigDummy.next;
        return smallDummy.next;

    }

}
