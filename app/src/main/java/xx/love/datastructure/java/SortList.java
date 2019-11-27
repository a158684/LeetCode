package xx.love.datastructure.java;

/**
 * @author : zhijun.li on 2019/11/24
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(1);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(7);
        listNode1.next.next.next.next.next = new ListNode(0);

//        ListNode listNode = sortList(listNode1);
//        System.out.println(listNode.val);
        sortList2(listNode1);

    }


    public static void sortList2(ListNode head) {

        ListNode fast = head.next, slow = head;
//        head.next=null;

        ListNode tmp = slow.next;

        slow.next = null;

        System.out.println(tmp.val);


    }
}
