package xx.love.datastructure.java;

import java.util.Stack;

/**
 * @author : zhijun.li on 2020/3/17
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] nodes=new int[stack.size()];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i]=stack.pop();
        }
        return nodes;
    }
}
