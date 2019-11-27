package xx.love.datastructure.java;

import java.util.List;

/**
 * @author : zhijun.li on 2019/11/26
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode l1=new ListNode(0);
        l1.next=head;
        int length=0;
        ListNode l2=head;
        while (l2!=null){
            length++;
            l2=l2.next;
        }
        length-=n;
        l2=l1;
        while (length>0){
            length--;
            l2=l2.next;
        }
        l2.next=l2.next.next;

        return l1.next;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode l1=head;
        ListNode l2=head;
        int current=n;
        while (current>-1){
            if (l1!=null) {
                l1 = l1.next;
                current--;
            }else {
                if (0==current){
                    return head.next;
                }
            }
        }
        while (l1!=null){
            l1=l1.next;
            l2=l2.next;
        }
        l2.next=l2.next.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(1);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(7);
        listNode1.next.next.next.next.next = new ListNode(0);
        RemoveNthFromEnd s=new RemoveNthFromEnd();
        ListNode listNode = s.removeNthFromEnd2(listNode1, 6);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
