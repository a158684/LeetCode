package xx.love.datastructure.java;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : zhijun.li on 2019/11/26
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        queue.addAll(Stream.of(lists).filter(Objects::nonNull).collect(Collectors.toList()));
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null)
                queue.add(node.next);
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        final int length = lists.length;
        if (length == 0) return null;
        return mergeKLists2(lists, 0, length - 1);

    }

    public ListNode mergeKLists2(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        final int mid = (left + right) >> 1;
        final ListNode l1 = mergeKLists2(lists, left, mid);
        final ListNode l2 = mergeKLists2(lists, mid + 1, right);
        return mergeKLists2(l1, l2);
    }

    private ListNode mergeKLists2(ListNode l1, ListNode l2) {
//       if (l1==null){
//           return l2;
//       }
//       if (l2==null){
//           return l1;
//       }
//       if (l1.val<l2.val){
//
//          l1.next= mergeKLists2(l1.next,l2);
//          return l1;
//       }else {
//            l2.next=mergeKLists2(l1,l2.next);
//            return l2;
//       }
        ListNode pre = new ListNode(-1);
        ListNode cummry = pre;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cummry.next = l1;
                    l1 = l1.next;
                } else {
                    cummry.next = l2;
                    l2 = l2.next;
                }
                cummry = cummry.next;
                cummry.next = l1 == null ? l1 : l2;
            }
        return pre.next;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode listNode3 = new ListNode(0);
        listNode3.next = new ListNode(6);
        listNode3.next.next = new ListNode(8);
        MergeKLists kLists = new MergeKLists();
        System.out.println(System.currentTimeMillis());
        ListNode listNode = kLists.mergeKLists2(new ListNode[]{listNode1, listNode2, listNode3});
        System.out.println(System.currentTimeMillis());
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
