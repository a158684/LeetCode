package xx.love.datastructure.java;

/**
 * @author : zhijun.li on 2019/11/23
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
       ListNode preHead=new ListNode(-1);
       ListNode prev=preHead;
       while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                prev.next=l1;
                l1=l1.next;
            }else {
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;
            // exactly one of l1 and l2 can be non-null at this point, so connect
           // the non-null list to the end of the merged list.
           prev.next = l1 == null ? l2 : l1;
       }
       return preHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists2(listNode1, listNode2);
        System.out.println(listNode.val);
        while (listNode.next!=null){
            listNode=listNode.next;
            System.out.println(listNode.val);
        }

    }
}
